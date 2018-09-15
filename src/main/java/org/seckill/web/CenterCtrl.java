package org.seckill.web;

import com.alibaba.fastjson.JSONObject;
import org.seckill.entity.CompanyType;
import org.seckill.entity.ResultBean;
import org.seckill.entity.User;
import org.seckill.service.CompanyTypeService;
import org.seckill.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/frontend/center")
public class CenterCtrl {

    @Autowired
    private CompanyTypeService companyTypeService;

    /**
     * 根据用户类型跳转不同的主页
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model){
        //todo
        //1.判断用户是企业用户还是银行用户
        //2.如果是企业用户，进入search.jsp页面
        //3.如果是银行用户，进入enterpriseInfo.jsp页面（或者重定向到EnterpriseInfoCtrl）
        User user = SessionUtils.getUser(request);

        if(user.getIsBank().equals(new Byte("0"))){  //是企业用户
            return "/views/frontend/enterpriseInfo/index";
        } else {
            return "/views/frontend/center/index";      //是银行用户
        }

    }

    /**
     * 处理用户搜索
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public ResultBean search(@RequestBody JSONObject body, HttpServletRequest request, Model model){
        //todo:实现搜索功能
        String input = body.getString("input");
        List<CompanyType> companyTypeList = this.companyTypeService.getCompanyByFuzzyName(input);
        model.addAttribute("companyList", companyTypeList);
        return null;
    }

    /**
     * 跳转行业分类页面
     */
    @RequestMapping("/industryCategory")
    public String industryCategory(String index, HttpServletRequest request, Model model) {
        //获取所有行业分类
        List<String> companyTypeList = this.companyTypeService.getAllCompanyType();

        if(companyTypeList.size()!=0){

            model.addAttribute("companyTypeList",companyTypeList);
            List<CompanyType> companyList = this.companyTypeService.getAllCompanyByType(companyTypeList.get(Integer.parseInt(index)));
            model.addAttribute("companyList",companyList);
            return "/views/frontend/center/industryCategory";
        } else {
            return "/views/frontend/base/error";
        }


    }

    @RequestMapping("/aboutUs")
    public String aboutUs() {
        return "/views/frontend/center/aboutUs";
    }
}
