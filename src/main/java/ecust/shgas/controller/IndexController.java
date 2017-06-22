package ecust.shgas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huchao on 2017/4/12.
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/view/{formName}")
    public String loginForm(@PathVariable String formName){
        //动态跳转页面
        return formName;
    }
}

