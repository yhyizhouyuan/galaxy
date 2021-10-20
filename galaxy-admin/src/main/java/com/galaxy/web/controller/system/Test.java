package com.galaxy.web.controller.system;

import com.galaxy.common.core.domain.entity.SysUser;
import com.galaxy.common.utils.ShiroUtils;
import com.galaxy.common.utils.bean.BeanUtils;
import org.apache.shiro.subject.Subject;
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

    public static void main(String[] args) {
        Subject subject = ShiroUtils.getSubject();
        Object principal = subject.getPrincipal();
        System.out.println(principal);
    }

}
