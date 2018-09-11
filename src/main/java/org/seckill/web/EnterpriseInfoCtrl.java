package org.seckill.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/frontend/enterpriseInfo")
public class EnterpriseInfoCtrl {

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
     * 显示搜索结果/企业信息（只能由银行用户进入）
     * @return
     */
    @RequestMapping("searchResult")
    public String searchResult(HttpServletRequest request, Model model){
        return "/views/frontend/enterpriseInfo/index";
    }

}