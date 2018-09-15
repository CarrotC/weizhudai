package org.seckill.web;

import com.alibaba.fastjson.JSONObject;
import org.seckill.dao.*;
import org.seckill.entity.*;
import org.seckill.service.*;
import org.seckill.util.ListSortByDate;
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
import java.util.ArrayList;
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

    @Autowired
    CompTaxService compTaxService;
    @Autowired
    CompLawsuitService compLawsuitService;

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

        ListSortByDate.flowListSort(flowList);

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

            Date now = new Date();
            if(payAmountForOneBank.compareTo(loanAmountFromOneBank) < 0){
                if(loanList.get(i).getRepaymentPeriod().after(now)){
                    loanList.get(i).setStatus("负债中");   //未逾期，待还款
                    loanList.get(i).setStatusIndex("0");
                } else {
                    loanList.get(i).setStatus("未还清不良记录");   //逾期，待还款
                    loanList.get(i).setStatusIndex("3");
                    BigDecimal temp = loanAmountFromOneBank.subtract(payAmountForOneBank);
                    delayAmountFromAllBank = delayAmountFromAllBank.add(temp);
                    delayCount++;
                }
            }else if(loanList.get(i).getRepaymentPeriod().after(now)){
                loanList.get(i).setStatus("按时还款");
                loanList.get(i).setStatusIndex("1");
            } else {
                loanList.get(i).setStatus("已还清不良记录");
                loanList.get(i).setStatusIndex("2");
            }
        }

        ListSortByDate.loanListSort(loanList);

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
         return "/views/frontend/enterpriseInfo/financialInfo";
    }
    /**
     * 显示纳税情况
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("taxSituation")
    public String taxSituation(String companyId, HttpServletRequest request, Model model){
        //todo: 按时间分组
        List<CompTax> compTaxList = compTaxService.getCompTaxById(companyId);
        String year1 = "2016";
        Double taxToPay1 = 0.0;
        Double taxPaid1 = 0.0;
        String status1 = "已缴清";
        List<CompTax> compTaxList1 = new ArrayList<>();
        String year2 = "2017";
        Double taxToPay2 = 0.0;
        Double taxPaid2 = 0.0;
        String status2 = "已缴清";
        List<CompTax> compTaxList2 = new ArrayList<>();
        for(CompTax c: compTaxList){
            if(c.getDt().before(new Date(2017-01-01)) && c.getDt().after(new Date(2015-12-31))){
                compTaxList1.add(c);
                taxToPay1 += c.getTaxShouldPay();
                taxPaid1 += c.getTaxPaid();
                if(!c.getStatus().equals("已缴清")){
                    status1 = "欠税";
                }
            }else if(c.getDt().before(new Date(2018-01-01)) && c.getDt().after(new Date(2016-12-31))){
                compTaxList2.add(c);
                taxToPay2 += c.getTaxShouldPay();
                taxPaid2 += c.getTaxPaid();
                if(!c.getStatus().equals("已缴清")){
                    status2 = "欠税";
                }
            }
        }

        model.addAttribute("year1", year1);
        model.addAttribute("taxToPay1", taxToPay1);
        model.addAttribute("taxPaid1", taxPaid1);
        model.addAttribute("status1", status1);
        model.addAttribute("compTaxList1", compTaxList1);
        model.addAttribute("year2", year2);
        model.addAttribute("taxToPay2", taxToPay2);
        model.addAttribute("taxPaid2", taxPaid2);
        model.addAttribute("status2", status2);
        model.addAttribute("compTaxList2", compTaxList2);
        //todo:前端需要添加页面
        return "/views/frontend/enterpriseInfo/taxSituation";
    }

    /**
     * 显示涉诉情况
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("complaint")
    public String complaint(String companyId, HttpServletRequest request, Model model){
        List<CompLawsuit> compLawsuitList = compLawsuitService.getCompLawsuitById(companyId);
        model.addAttribute("compLawsuitList", compLawsuitList);
        //todo:前端需要添加页面
        return "/views/frontend/enterpriseInfo/complaint";
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
        model.addAttribute("companyType", companyType.getCompanyType());
        model.addAttribute("companyId", companyId);

        //从数据库中加载企业基本信息
        Comp comp = compService.getCompById(companyId);
        List<CompFormerName> compFormerName = compFormerNameService.getCompFormerNameById(companyId);
        List<CompMembers> compMembers = compMembersService.getCompMembersById(companyId);
        List<CompShareholder> compShareHolder =  compShareHolderService.getCompShareholderById(companyId);
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
    public String financialInfo(String companyId, HttpServletRequest request, Model model){
        String compId = companyId;

        //变现能力
        List<Cashability> cashabilityList = cashabilityService.getCashabilityById(compId);
        int cashabilityListSize = cashabilityList.size();
        //Integer[] years = new Integer[cashabilityListSize];
        //Double[] currentRatios = new Double[cashabilityListSize];//流动比率
        String[][] currentRatios = new String[2][cashabilityListSize];
        //Double[] quickRatios = new Double[cashabilityListSize];//速动比率
        String[][] quickRatios = new String[2][cashabilityListSize];
        for(int i = 0; i < cashabilityListSize; i++){
            //years[i] = cashabilityList.get(i).getYear();
            //currentRatios[i] = cashabilityList.get(i).getCurrentRatio();
            //quickRatios[i] = cashabilityList.get(i).getQuickRatio();
            currentRatios[0][i] = cashabilityList.get(i).getYear() + "-" + cashabilityList.get(i).getQuarter();
            currentRatios[1][i] = String.valueOf(cashabilityList.get(i).getCurrentRatio());
            quickRatios[0][i] = cashabilityList.get(i).getYear() + "-" + cashabilityList.get(i).getQuarter();
            quickRatios[1][i] = String.valueOf(cashabilityList.get(i).getQuickRatio());
        }
        //model.addAttribute("years", years);
        model.addAttribute("currentRatios", currentRatios);
        model.addAttribute("quickRatios", quickRatios);

        //资产管理比率
        List<AssetManagementRatio> assetManagementRatioList = assetManagementRatioService.getAssetManagementRatioById(compId);
        int assetManagementRatioListSize = assetManagementRatioList.size();
        //Double[] inventoryTurnover = new Double[assetManagementRatioListSize];//存货周转率
        String[][] inventoryTurnover = new String[2][assetManagementRatioListSize];
        //Double[] inventoryTurnoverInDays = new Double[assetManagementRatioListSize];//存货周转天数
        String[][] inventoryTurnoverInDays = new String[2][assetManagementRatioListSize];
        //Double[] accountReceivableTurnover = new Double[assetManagementRatioListSize];//应收账款周转率
        String[][] accountReceivableTurnover = new String[2][assetManagementRatioListSize];
        //Double[] accountReceivableTurnoverInDays = new Double[assetManagementRatioListSize];//应收账款周转天数
        String[][] accountReceivableTurnoverInDays = new String[2][assetManagementRatioListSize];
        //Double[] operatingCycle = new Double[assetManagementRatioListSize];//营业周期
        String[][] operatingCycle = new String[2][assetManagementRatioListSize];
        //Double[] currentAssetTurnover = new Double[assetManagementRatioListSize];//流动资产周转率
        String[][] currentAssetTurnover = new String[2][assetManagementRatioListSize];
        //Double[] totalAssetTurnover = new Double[assetManagementRatioListSize];//总资产周转率
        String[][] totalAssetTurnover = new String[2][assetManagementRatioListSize];
        for(int i = 0; i < assetManagementRatioListSize; i++){
//            inventoryTurnover[i] = assetManagementRatioList.get(i).getInventoryTurnover();
//            inventoryTurnoverInDays[i] = assetManagementRatioList.get(i).getInventoryTurnoverInDays();
//            accountReceivableTurnover[i] = assetManagementRatioList.get(i).getAccountReceivableTurnover();
//            accountReceivableTurnoverInDays[i] =  assetManagementRatioList.get(i).getAccountReceivableTurnoverInDays();
//            operatingCycle[i] = assetManagementRatioList.get(i).getOperatingCycle();
//            currentAssetTurnover[i] = assetManagementRatioList.get(i).getCurrentAssetTurnover();
//            totalAssetTurnover[i] = assetManagementRatioList.get(i).getTotalAssetTurnover();
            inventoryTurnover[0][i] = assetManagementRatioList.get(i).getYear() + "-" + assetManagementRatioList.get(i).getQuarter();
            inventoryTurnoverInDays[0][i] = assetManagementRatioList.get(i).getYear() + "-" + assetManagementRatioList.get(i).getQuarter();
            accountReceivableTurnover[0][i] = assetManagementRatioList.get(i).getYear() + "-" + assetManagementRatioList.get(i).getQuarter();
            accountReceivableTurnoverInDays[0][i] = assetManagementRatioList.get(i).getYear() + "-" + assetManagementRatioList.get(i).getQuarter();
            operatingCycle[0][i] = assetManagementRatioList.get(i).getYear() + "-" + assetManagementRatioList.get(i).getQuarter();
            currentAssetTurnover[0][i] = assetManagementRatioList.get(i).getYear() + "-" + assetManagementRatioList.get(i).getQuarter();
            totalAssetTurnover[0][i] = assetManagementRatioList.get(i).getYear() + "-" + assetManagementRatioList.get(i).getQuarter();

            inventoryTurnover[1][i] = String.valueOf(assetManagementRatioList.get(i).getInventoryTurnover());
            inventoryTurnoverInDays[1][i] = String.valueOf(assetManagementRatioList.get(i).getInventoryTurnoverInDays());
            accountReceivableTurnover[1][i] = String.valueOf(assetManagementRatioList.get(i).getAccountReceivableTurnover());
            accountReceivableTurnoverInDays[1][i] = String.valueOf(assetManagementRatioList.get(i).getAccountReceivableTurnoverInDays());
            operatingCycle[1][i] = String.valueOf(assetManagementRatioList.get(i).getOperatingCycle());
            currentAssetTurnover[1][i] = String.valueOf(assetManagementRatioList.get(i).getCurrentAssetTurnover());
            totalAssetTurnover[1][i] = String.valueOf(assetManagementRatioList.get(i).getTotalAssetTurnover());


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
        //Double[] assetLiabilityRatio = new Double[debtRatioListSize];//资产负债比率
        String[][] assetLiabilityRatio = new String[2][debtRatioListSize];
        //Double[] equityRatio = new Double[debtRatioListSize];//产权比率
        String[][] equityRatio = new String[2][debtRatioListSize];
        //Double[] tangibleDebtRatio = new Double[debtRatioListSize];//有形净资产债务率
        String[][] tangibleDebtRatio = new String[2][debtRatioListSize];
        //Double[] interestEarnedRatio = new Double[debtRatioListSize];//已获利息倍
        String[][] interestEarnedRatio = new String[2][debtRatioListSize];
        for(int i = 0; i < debtRatioListSize; i++){
//            assetLiabilityRatio[i] = debtRatioList.get(i).getAssetLiabilityRatio();
//            equityRatio[i] = debtRatioList.get(i).getEquityRatio();
//            tangibleDebtRatio[i] = debtRatioList.get(i).getTangibleDebtRatio();
//            interestEarnedRatio[i] = debtRatioList.get(i).getInterestEarnedRatio();
            assetLiabilityRatio[0][i] = debtRatioList.get(i).getYear() + "-" + debtRatioList.get(i).getQuarter();
            equityRatio[0][i] = debtRatioList.get(i).getYear() + "-" + debtRatioList.get(i).getQuarter();
            tangibleDebtRatio[0][i] = debtRatioList.get(i).getYear() + "-" + debtRatioList.get(i).getQuarter();
            interestEarnedRatio[0][i] = debtRatioList.get(i).getYear() + "-" + debtRatioList.get(i).getQuarter();

            assetLiabilityRatio[1][i] = String.valueOf(debtRatioList.get(i).getAssetLiabilityRatio());
            equityRatio[1][i] = String.valueOf(debtRatioList.get(i).getEquityRatio());
            tangibleDebtRatio[1][i] = String.valueOf(debtRatioList.get(i).getTangibleDebtRatio());
            interestEarnedRatio[1][i] = String.valueOf(debtRatioList.get(i).getInterestEarnedRatio());
        }
        model.addAttribute("assetLiabilityRatio", assetLiabilityRatio);
        model.addAttribute("equityRatio", equityRatio);
        model.addAttribute("tangibleDebtRatio", tangibleDebtRatio);
        model.addAttribute("interestEarnedRatio", interestEarnedRatio);

        //盈利能力比率
        List<ProfitabilityRatio> profitabilityRatioList = profitabilityRatioService.getProfitabilityRatioById(compId);
        int profitabilityRatioListSize = profitabilityRatioList.size();
        //Double[] netProfitRatioInSale = new Double[profitabilityRatioListSize];//销售净利率
        String[][] netProfitRatioInSale = new String[2][profitabilityRatioListSize];
        //Double[] grossProfitRatioInSale = new Double[profitabilityRatioListSize];//销售毛利率
        String[][] grossProfitRatioInSale = new String[2][profitabilityRatioListSize];
        //Double[] netProfitRatioInAsset = new Double[profitabilityRatioListSize];//资产净利率
        String[][] netProfitRatioInAsset = new String[2][profitabilityRatioListSize];
        //Double[] netAssetIncomeRatio = new Double[profitabilityRatioListSize];//净资产收益率
        String[][] netAssetIncomeRatio = new String[2][profitabilityRatioListSize];
        for(int i = 0; i < profitabilityRatioListSize; i++){
//            netProfitRatioInSale[i] = profitabilityRatioList.get(i).getNetProfitRatioInSale();
//            grossProfitRatioInSale[i] = profitabilityRatioList.get(i).getGrossProfitRatioInSale();
//            netProfitRatioInAsset[i] = profitabilityRatioList.get(i).getNetProfitRatioInAsset();
//            netAssetIncomeRatio[i] = profitabilityRatioList.get(i).getNetAssetIncomeRatio();

            netProfitRatioInSale[0][i] = profitabilityRatioList.get(i).getYear() + "-" + profitabilityRatioList.get(i).getQuarter();
            grossProfitRatioInSale[0][i] = profitabilityRatioList.get(i).getYear() + "-" + profitabilityRatioList.get(i).getQuarter();
            netProfitRatioInAsset[0][i] = profitabilityRatioList.get(i).getYear() + "-" + profitabilityRatioList.get(i).getQuarter();
            netAssetIncomeRatio[0][i] = profitabilityRatioList.get(i).getYear() + "-" + profitabilityRatioList.get(i).getQuarter();

            netProfitRatioInSale[1][i] = String.valueOf(profitabilityRatioList.get(i).getNetProfitRatioInSale());
            grossProfitRatioInSale[1][i] = String.valueOf(profitabilityRatioList.get(i).getGrossProfitRatioInSale());
            netProfitRatioInAsset[1][i] = String.valueOf(profitabilityRatioList.get(i).getNetProfitRatioInAsset());
            netAssetIncomeRatio[1][i] = String.valueOf(profitabilityRatioList.get(i).getNetAssetIncomeRatio());
        }
        model.addAttribute("netProfitRatioInSale", netProfitRatioInSale);
        model.addAttribute("grossProfitRatioInSale", grossProfitRatioInSale);
        model.addAttribute("netProfitRatioInAsset", netProfitRatioInAsset);
        model.addAttribute("netAssetIncomeRatio", netAssetIncomeRatio);

        //现金流量分析
        List<CashFlow> cashFlowList = cashFlowService.getCashFlowById(compId);
        int cashFlowSize = cashFlowList.size();
        //Double[] cashMaturityDebtRatio = new Double[cashFlowSize];//现金到期债务比
        String[][] cashMaturityDebtRatio = new String[2][cashFlowSize];
        //Double[] cashFlowDebtRatio = new Double[cashFlowSize];//现金流动债务比
        String[][] cashFlowDebtRatio = new String[2][cashFlowSize];
        //Double[] totalCashDebtRatio = new Double[cashFlowSize];//现金债务总额比
        String[][] totalCashDebtRatio = new String[2][cashFlowSize];
        for(int i = 0; i < cashFlowSize; i++){
//            cashMaturityDebtRatio[i] = cashFlowList.get(i).getCashMaturityDebtRatio();
//            cashFlowDebtRatio[i] = cashFlowList.get(i).getCashFlowDebtRatio();
//            totalCashDebtRatio[i] = cashFlowList.get(i).getTotalCashDebtRatio();

            cashMaturityDebtRatio[0][i] = cashFlowList.get(i).getYear() + "-" + cashabilityList.get(i).getQuarter();
            cashFlowDebtRatio[0][i] = cashFlowList.get(i).getYear() + "-" + cashabilityList.get(i).getQuarter();
            totalCashDebtRatio[0][i] = cashFlowList.get(i).getYear() + "-" + cashabilityList.get(i).getQuarter();

            cashMaturityDebtRatio[1][i] = String.valueOf(cashFlowList.get(i).getCashFlowDebtRatio());
            cashFlowDebtRatio[1][i] = String.valueOf(cashFlowList.get(i).getCashFlowDebtRatio());
            totalCashDebtRatio[1][i] = String.valueOf(cashFlowList.get(i).getTotalCashDebtRatio());
        }
        model.addAttribute("cashMaturityDebtRatio", cashMaturityDebtRatio);
        model.addAttribute("cashFlowDebtRatio", cashFlowDebtRatio);
        model.addAttribute("totalCashDebtRatio", totalCashDebtRatio);

        //获现能力
        List<Profitability> profitabilityList = profitabilityService.getProfitabilityById(compId);
        int profitabilitySize = profitabilityList.size();
        //Double[] saleCashRatio = new Double[profitabilitySize];
        String[][] saleCashRatio = new String[2][profitabilitySize];
        //Double[] cashRecoveryRatio = new Double[profitabilitySize];
        String[][] cashRecoveryRatio = new String[2][profitabilitySize];
        for(int i = 0; i < profitabilitySize; i++){
            saleCashRatio[0][1] = profitabilityList.get(i).getYear() + "-" + profitabilityList.get(i).getQuarter();
            cashRecoveryRatio[0][1] = profitabilityList.get(i).getYear() + "-" + profitabilityList.get(i).getQuarter();

            saleCashRatio[1][i] = String.valueOf(profitabilityList.get(i).getSaleCashRatio());
            cashRecoveryRatio[1][i] = String.valueOf(profitabilityList.get(i).getCashRecoveryRatio());
        }
        model.addAttribute("saleCashRatio", saleCashRatio);
        model.addAttribute("cashRecoveryRatio", cashRecoveryRatio);


        return "/views/frontend/enterpriseInfo/financialInfo";
    }


}