package com.galaxy.web.controller.system;

import com.galaxy.common.core.controller.BaseController;
import com.galaxy.common.core.domain.entity.SysUser;
import com.galaxy.common.utils.ShiroUtils;
import com.galaxy.common.utils.bean.BeanUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/19 8:50
 */
@Controller
public class Test extends ServletRequestAttributes {
    public Test(HttpServletRequest request) {
        super(request);
    }
    @Autowired
    private static HttpServletRequest request;

    @RequestMapping("/test")
    public String test(){
        return "login";
    }

    public static void main(String[] args) {

        System.out.println(demo(request));
    }

    public static String demo(HttpServletRequest request){
        String method = request.getMethod();
        return method;
    }



}
