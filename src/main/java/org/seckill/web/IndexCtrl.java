package org.seckill.web;

import com.alibaba.fastjson.JSONObject;
import org.seckill.entity.ResultBean;
import org.seckill.entity.User;
import org.seckill.service.UserService;
import org.seckill.util.SessionUtils;
import org.seckill.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/frontend")
public class IndexCtrl {

    @Autowired
    private UserService userService;
    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
//        User user = (User)request.getSession().getAttribute("_user");
//
//        if(user != null) {
//            request.getSession().setAttribute("_user",user);
//        }

        return "/index";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/login/index")
    public String loginPage(HttpServletRequest request, Model model) {
        return "/views/frontend/user/login";
    }

    /**
     * 登录验证，将用户存储到session中
     * @param body
     * @param request
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultBean login(@RequestBody JSONObject body, HttpServletRequest request) {

        /*验证用户输入的密码和用户名是否匹配*/
        //1.验证用户名是否存在
        //2.验证密码是否和此用户名对应的密码相同

        String userName = body.getString("userName");
        String passwd = body.getString("passwd");

        User user = this.userService.getUserByUserName(userName);
        if(user!=null) {    //如果该用户名存在
            if(StringUtils.MD5(passwd).equals(user.getPassword())) { //如果密码正确
                SessionUtils.setUser(request, user);
                return new ResultBean(200, "登录成功");
            } else {
                return new ResultBean(500,"密码错误");
            }
        } else {
            return new ResultBean(500, "用户名不存在");
        }

    }

    /**
     * 退出登录功能
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        /*退出登录，移除session中的用户*/
        //1.移除session中的用户
        //2.跳转到主页

        SessionUtils.removeSessionAttribute(request,"_user");
        return "/index";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("/sign/index")
    public String signINPage() {
        return "/views/frontend/user/sign";
    }


    /**
     * 实现注册功能
     * @param body
     * @param request
     * @return
     */
    @RequestMapping("/signIn")
    public ResultBean signIn(@RequestBody JSONObject body, HttpServletRequest request) {
        /*用户注册*/
        //1.获取用户在前端页面输入的用户名、密码等信息
        //2.对密码进行md5加密
        //3.存储用户信息
        //4.将注册成功与否的结果用ReaultBean返回
        String userName = body.getString("userName");
        String passwd = body.getString("passwd");
        //todo:还要从body中获取其他信息，即用户注册时填写的其他信息，获取值的方法和上面的相同

        User user = this.userService.getUserByUserName(userName);
        ResultBean result;

        if(user!=null) {
            result = new ResultBean(500,"用户名已存在");
        } else {
            user = new User();
            user.setId(StringUtils.UUID());
            user.setUserName(userName);
            user.setPassword(StringUtils.MD5(passwd));
            user.setIsBank(new Byte("0"));
            result = this.userService.addUser(user);
        }

        return result;
    }
}
