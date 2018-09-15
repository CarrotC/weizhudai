package org.seckill.web;

import com.alibaba.fastjson.JSONObject;
import org.seckill.entity.CompanyType;
import org.seckill.entity.Flow;
import org.seckill.entity.Loan;
import org.seckill.entity.ResultBean;
import org.seckill.service.CompanyTypeService;
import org.seckill.service.LoanAndFlowService;
import org.seckill.util.SessionUtils;
import org.seckill.util.TxtReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/frontend/enterpriseInfo")
public class EnterpriseInfoCtrl {

    @Autowired
    private CompanyTypeService companyTypeService;

    @Autowired
    private LoanAndFlowService loanAndFlowService;

    /**
     * 显示企业信息（只能由企业用户进入的）
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request, Model model){
        //验证是否为企业用户
        return "/views/frontend/enterpriseInfo/index";
    }

    /**
     * 显示企业流水
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("companyFlow")
    public String companyFlow(String companyId, HttpServletRequest request, Model model){
        if(companyId==null){
            companyId = SessionUtils.getUser(request).getId();
        }

        CompanyType companyType = this.companyTypeService.getCompanyById(companyId);

        String realPath = request.getSession().getServletContext().getRealPath("/");
        List<Flow> flowList = loanAndFlowService.getAllTransactionRecord(realPath, companyId);

        model.addAttribute("flowList", flowList);
        model.addAttribute("companyType", companyType);

        return "/views/frontend/enterpriseInfo/companyFlow";
    }

    /**
     * 显示企业信用
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("companyLoan")
    public String companyLoan(String companyId, HttpServletRequest request, Model model){
        if(companyId==null){
            companyId = SessionUtils.getUser(request).getId();
        }

        CompanyType companyType = this.companyTypeService.getCompanyById(companyId);

        String realPath = request.getSession().getServletContext().getRealPath("/");
        Map result = loanAndFlowService.getAllLoanRecord(realPath, companyId);
        List<Loan> loanList = (List<Loan>)result.get("loanList");
        List<Loan> payList = (List<Loan>)result.get("payList");

        int delayCount = 0;//拖欠次数
        BigDecimal loanAmountFromAllBank = new BigDecimal("0");//贷款总金额
        BigDecimal payAmountForAllBank = new BigDecimal("0");//还款总金额
        BigDecimal delayAmountFromAllBank = new BigDecimal("0");//拖欠总金额

        for(int i = 0; i < loanList.size(); i++){

            loanAmountFromAllBank = loanAmountFromAllBank.add(loanList.get(i).getAmount());//计算贷款总额

            BigDecimal loanAmountFromOneBank = loanList.get(i).getAmount();
            BigDecimal payAmountForOneBank = new BigDecimal("0");

            for(int j = 0; j < payList.size(); j++){
                payAmountForAllBank = payAmountForAllBank.add(payList.get(j).getAmount());//计算在所有银行下的还款总额
                //todo:添加时间的判断，是否拖欠
                if(loanList.get(i).getBank().equals(payList.get(j).getBank())){
                    payAmountForOneBank = payAmountForOneBank.add(payList.get(j).getAmount());//计算在同一个银行下的还款总额
                }
            }

            if(payAmountForOneBank.compareTo(loanAmountFromOneBank) < 0){
                Date now = new Date();
                if(loanList.get(i).getRepaymentPeriod().after(now)){
                    loanList.get(i).setStatus("待还款");   //未逾期，待还款
                } else {
                    loanList.get(i).setStatus("拖欠");   //逾期，待还款
                    BigDecimal temp = loanAmountFromOneBank.subtract(payAmountForOneBank);
                    delayAmountFromAllBank = delayAmountFromAllBank.add(temp);
                    delayCount++;
                }
            }else{
                loanList.get(i).setStatus("已还款");
            }
        }

        model.addAttribute("loanList", loanList);//贷款记录
        model.addAttribute("payList", payList);//还款记录
        model.addAttribute("delayCount", delayCount);//拖欠次数
        model.addAttribute("loanAmount", loanAmountFromAllBank);//贷款总金额
        model.addAttribute("payAmount", payAmountForAllBank);//还款总金额
        model.addAttribute("delayAmount", delayAmountFromAllBank);//拖欠总金额
        model.addAttribute("companyType", companyType);

        return "/views/frontend/enterpriseInfo/companyLoan";
    }

    /**
     * 显示财务信息
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("companyFinance")
    public String companyFinance(HttpServletRequest request, Model model){

        //todo:前端需要添加页面
        return "";
    }

    /**
     * 显示搜索结果/企业信息（只能由银行用户进入）
     * @return
     */
    @RequestMapping("searchResult")
    public String searchResult(HttpServletRequest request, Model model){
        return "/views/frontend/enterpriseInfo/index";
    }

    /**
     * 行业分类页面点击企业信息的控制器（只能由银行用户进入）
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("companyInfo")
    @ResponseBody
    public ResultBean companyInfo(@RequestBody JSONObject body, HttpServletRequest request, Model model){
        String companyId = body.getString("companyId");
        if(companyId!=null){
            CompanyType companyType = this.companyTypeService.getCompanyById(companyId);
            if(companyType!=null&&companyType.getIsRegister().equals(new Byte("1"))){
                String url = "/frontend/enterpriseInfo/showCompanyInfo?companyId=" + companyId;
                return new ResultBean(200,url,"获取企业资料成功");
            }
        }
        return new ResultBean(500,"获取企业资料失败");
    }

    /**
     * 显示企业信息（搜索和行业分类通用，只有银行可以用）
     * @param companyId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("showCompanyInfo")
    public String showCompanyInfo(String companyId, HttpServletRequest request, Model model){
        //todo:从数据库中获取企业信息
        //todo:从区块链中获取流水和借贷信息
        CompanyType companyType = this.companyTypeService.getCompanyById(companyId);
        model.addAttribute("companyName",companyType.getCompanyName());
        return "/views/frontend/enterpriseInfo/index";
    }


}