package org.seckill.web;

import com.alibaba.fastjson.JSONObject;
import org.seckill.dao.*;
import org.seckill.entity.*;
import org.seckill.service.*;
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


    @Autowired
    AssetManagementRatioService assetManagementRatioService;
    @Autowired
    CashabilityService cashabilityService;
    @Autowired
    CashFlowService cashFlowService;
    @Autowired
    DebtRatioService debtRatioService;
    @Autowired
    ProfitabilityService profitabilityService;
    @Autowired
    ProfitabilityRatioService profitabilityRatioService;

    @Autowired
    CompService compService;
    @Autowired
    CompFormerNameService compFormerNameService;
    @Autowired
    CompMembersService compMembersService;
    @Autowired
    CompShareHolderService compShareHolderService;


    /**
     * 显示企业信息（只能由企业用户进入的）
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request, Model model){
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
                //model.addAttribute("companyId",companyId);
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
        model.addAttribute("companyId", companyId);

        //从数据库中加载企业基本信息
        Comp comp = compService.getCompById(companyId);
        CompFormerName compFormerName = compFormerNameService.getCompFormerNameById(companyId);
        CompMembers compMembers = compMembersService.getCompMembersById(companyId);
        CompShareholder compShareHolder =  compShareHolderService.getCompShareholderById(companyId);
        model.addAttribute("comp", comp);
        model.addAttribute("compFormerName", compFormerName);
        model.addAttribute("compMembers", compMembers);
        model.addAttribute("compShareHolder", compShareHolder);

        return "/views/frontend/enterpriseInfo/index";
    }

    /**
     * 显示搜索结果/财务信息（只能由银行用户进入）
     * @return
     */
    @RequestMapping("financialInfo")
    public String financialInfo(HttpServletRequest request, Model model){
        //todo
        //1.从前端获取具体企业

        String compId = "1"; //测试所用

        //变现能力
        List<Cashability> cashabilityList = cashabilityService.getCashabilityById(compId);
        int cashabilityListSize = cashabilityList.size();
        Integer[] years = new Integer[cashabilityListSize];
        Double[] currentRatios = new Double[cashabilityListSize];//流动比率
        Double[] quickRatios = new Double[cashabilityListSize];//速动比率
        for(int i = 0; i < cashabilityListSize; i++){
            years[i] = cashabilityList.get(i).getYear();
            currentRatios[i] = cashabilityList.get(i).getCurrentRatio();
            quickRatios[i] = cashabilityList.get(i).getQuickRatio();
        }
        model.addAttribute("years", years);
        model.addAttribute("currentRatios", currentRatios);
        model.addAttribute("quickRatios", quickRatios);

        //资产管理比率
        List<AssetManagementRatio> assetManagementRatioList = assetManagementRatioService.getAssetManagementRatioById(compId);
        int assetManagementRatioListSize = assetManagementRatioList.size();
        Double[] inventoryTurnover = new Double[assetManagementRatioListSize];//存货周转率
        Double[] inventoryTurnoverInDays = new Double[assetManagementRatioListSize];//存货周转天数
        Double[] accountReceivableTurnover = new Double[assetManagementRatioListSize];//应收账款周转率
        Double[] accountReceivableTurnoverInDays = new Double[assetManagementRatioListSize];//应收账款周转天数
        Double[] operatingCycle = new Double[assetManagementRatioListSize];//营业周期
        Double[] currentAssetTurnover = new Double[assetManagementRatioListSize];//流动资产周转率
        Double[] totalAssetTurnover = new Double[assetManagementRatioListSize];//总资产周转率
        for(int i = 0; i < assetManagementRatioListSize; i++){
            inventoryTurnover[i] = assetManagementRatioList.get(i).getInventoryTurnover();
            inventoryTurnoverInDays[i] = assetManagementRatioList.get(i).getInventoryTurnoverInDays();
            accountReceivableTurnover[i] = assetManagementRatioList.get(i).getAccountReceivableTurnover();
            accountReceivableTurnoverInDays[i] =  assetManagementRatioList.get(i).getAccountReceivableTurnoverInDays();
            operatingCycle[i] = assetManagementRatioList.get(i).getOperatingCycle();
            currentAssetTurnover[i] = assetManagementRatioList.get(i).getCurrentAssetTurnover();
            totalAssetTurnover[i] = assetManagementRatioList.get(i).getTotalAssetTurnover();
        }
        model.addAttribute("inventoryTurnover", inventoryTurnover);
        model.addAttribute("inventoryTurnoverInDays", inventoryTurnoverInDays);
        model.addAttribute("accountReceivableTurnover", accountReceivableTurnover);
        model.addAttribute("accountReceivableTurnoverInDays",accountReceivableTurnoverInDays);
        model.addAttribute("operatingCycle", operatingCycle);
        model.addAttribute("currentAssetTurnover", currentAssetTurnover);
        model.addAttribute("totalAssetTurnover", totalAssetTurnover);



        //负债比率
        List<DebtRatio> debtRatioList = debtRatioService.getDebtRatioById(compId);
        int debtRatioListSize = debtRatioList.size();
        Double[] assetLiabilityRatio = new Double[debtRatioListSize];//资产负债比率
        Double[] equityRatio = new Double[debtRatioListSize];//产权比率
        Double[] tangibleDebtRatio = new Double[debtRatioListSize];//有形净资产债务率
        Double[] interestEarnedRatio = new Double[debtRatioListSize];//已获利息倍
        for(int i = 0; i < debtRatioListSize; i++){
            assetLiabilityRatio[i] = debtRatioList.get(i).getAssetLiabilityRatio();
            equityRatio[i] = debtRatioList.get(i).getEquityRatio();
            tangibleDebtRatio[i] = debtRatioList.get(i).getTangibleDebtRatio();
            interestEarnedRatio[i] = debtRatioList.get(i).getInterestEarnedRatio();
        }
        model.addAttribute("assetLiabilityRatio", assetLiabilityRatio);
        model.addAttribute("equityRatio", equityRatio);
        model.addAttribute("tangibleDebtRatio", tangibleDebtRatio);
        model.addAttribute("interestEarnedRatio", interestEarnedRatio);

        //盈利能力比率
        List<ProfitabilityRatio> profitabilityRatioList = profitabilityRatioService.getProfitabilityRatioById(compId);
        int profitabilityRatioListSize = profitabilityRatioList.size();
        Double[] netProfitRatioInSale = new Double[profitabilityRatioListSize];//销售净利率
        Double[] grossProfitRatioInSale = new Double[profitabilityRatioListSize];//销售毛利率
        Double[] netProfitRatioInAsset = new Double[profitabilityRatioListSize];//资产净利率
        Double[] netAssetIncomeRatio = new Double[profitabilityRatioListSize];//净资产收益率
        for(int i = 0; i < profitabilityRatioListSize; i++){
            netProfitRatioInSale[i] = profitabilityRatioList.get(i).getNetProfitRatioInSale();
            grossProfitRatioInSale[i] = profitabilityRatioList.get(i).getGrossProfitRatioInSale();
            netProfitRatioInAsset[i] = profitabilityRatioList.get(i).getNetProfitRatioInAsset();
            netAssetIncomeRatio[i] = profitabilityRatioList.get(i).getNetAssetIncomeRatio();
        }
        model.addAttribute("netProfitRatioInSale", netProfitRatioInSale);
        model.addAttribute("grossProfitRatioInSale", grossProfitRatioInSale);
        model.addAttribute("netProfitRatioInAsset", netProfitRatioInAsset);
        model.addAttribute("netAssetIncomeRatio", netAssetIncomeRatio);

        //现金流量分析
        List<CashFlow> cashFlowList = cashFlowService.getCashFlowById(compId);
        int cashFlowSize = cashFlowList.size();
        Double[] cashMaturityDebtRatio = new Double[cashFlowSize];//现金到期债务比
        Double[] cashFlowDebtRatio = new Double[cashFlowSize];//现金流动债务比
        Double[] totalCashDebtRatio = new Double[cashFlowSize];//现金债务总额比
        for(int i = 0; i < cashFlowSize; i++){
            cashMaturityDebtRatio[i] = cashFlowList.get(i).getCashMaturityDebtRatio();
            cashFlowDebtRatio[i] = cashFlowList.get(i).getCashFlowDebtRatio();
            totalCashDebtRatio[i] = cashFlowList.get(i).getTotalCashDebtRatio();
        }
        model.addAttribute("cashMaturityDebtRatio", cashMaturityDebtRatio);
        model.addAttribute("cashFlowDebtRatio", cashFlowDebtRatio);
        model.addAttribute("totalCashDebtRatio", totalCashDebtRatio);

        //获现能力
        List<Profitability> profitabilityList = profitabilityService.getProfitabilityById(compId);
        int profitabilitySize = profitabilityList.size();
        Double[] saleCashRatio = new Double[profitabilitySize];
        Double[] cashRecoveryRatio = new Double[profitabilitySize];
        for(int i = 0; i < profitabilitySize; i++){
            saleCashRatio[i] = profitabilityList.get(i).getSaleCashRatio();
            cashRecoveryRatio[i] = profitabilityList.get(i).getCashRecoveryRatio();
        }
        model.addAttribute("saleCashRatio", saleCashRatio);
        model.addAttribute("cashRecoveryRatio", cashRecoveryRatio);


        return "/views/frontend/enterpriseInfo/index";
    }


}