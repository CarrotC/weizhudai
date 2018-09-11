package org.seckill.web;

import org.seckill.entity.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frontend/hello")
public class TestCtrl {

    @RequestMapping("/index")
    public ResultBean test() {
        return new ResultBean("200","成功");
    }


}
