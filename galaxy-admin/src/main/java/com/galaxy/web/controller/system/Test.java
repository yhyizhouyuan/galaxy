package com.galaxy.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/19 8:50
 */
@Controller
public class Test {
    @RequestMapping("/test")
    public String test(){
        return "login";
    }

}
