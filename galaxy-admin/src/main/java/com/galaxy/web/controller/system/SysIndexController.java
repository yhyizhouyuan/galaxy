package com.galaxy.web.controller.system;

import com.galaxy.common.config.GalaxyConfig;
import com.galaxy.common.core.controller.BaseController;
import com.galaxy.common.core.domain.entity.SysMenu;
import com.galaxy.common.core.domain.entity.SysUser;
import com.galaxy.common.core.text.Convert;
import com.galaxy.common.utils.DateUtils;
import com.galaxy.common.utils.ServletUtils;
import com.galaxy.common.utils.StringUtils;
import com.galaxy.system.service.ISysConfigService;
import com.galaxy.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import java.util.Date;
import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/14 10:29
 */
@Controller
public class SysIndexController extends BaseController {
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private ISysConfigService configService;
    @GetMapping("/index")
    public String index(ModelMap mmap){
        SysUser user = getSysUser();
        List<SysMenu> menus = menuService.selectMenuByUser(user);
        mmap.put("menus",menus);
        mmap.put("user",user);
        mmap.put("sideTheme",configService.selectConfigByKey("sys.index.sideTheme"));
        mmap.put("skinName",configService.selectConfigByKey("sys.index.skinName"));
        Boolean footer = Convert.toBool(configService.selectConfigByKey("sys.index.footer"), true);
        Boolean tagsView = Convert.toBool(configService.selectConfigByKey("sys.index.tagsView"), true);
        mmap.put("footer",footer);
        mmap.put("tagsView",tagsView);
        mmap.put("mainClass",contentMainClass(footer,tagsView));
        mmap.put("copyrightYear", GalaxyConfig.getCopyrightYear());
        mmap.put("demoEnabled",GalaxyConfig.isDemoEnabled());
        mmap.put("isDefaultModifyPwd",initPasswordIsModify(user.getPwdUpdateDate()));
        mmap.put("isPasswordExpired",passwordIsExpiration(user.getPwdUpdateDate()));
        mmap.put("isMobile", ServletUtils.checkAgentIsMobile(ServletUtils.getRequest().getHeader("User-Agent")));

        String menuStyle = configService.selectConfigByKey("sys.index.menuStyle");
        String indexStyle = ServletUtils.checkAgentIsMobile(ServletUtils.getRequest().getHeader("User-Agent")) ? "index" : menuStyle;
        Cookie[] cookies = ServletUtils.getRequest().getCookies();
        for (Cookie cookie : cookies) {
            if (StringUtils.isNotEmpty(cookie.getName())&&"nav-style".equalsIgnoreCase(cookie.getName())){
                indexStyle = cookie.getValue();
                break;
            }
        }
        String webIndex = "topnav".equalsIgnoreCase(indexStyle)? "index-topnav" : "index";
        return webIndex;
    }

    private boolean passwordIsExpiration(Date pwdUpdateDate) {
        Integer passwordValidateDays = Convert.toInt(configService.selectConfigByKey("sys.account.passwordValidateDays"));
        if (passwordValidateDays != null && passwordValidateDays>0){
            if (StringUtils.isNull(pwdUpdateDate)){
                return true;
            }
            Date nowDate = DateUtils.getNowDate();
            return DateUtils.differentDaysByMillisecond(nowDate,pwdUpdateDate)>passwordValidateDays;
        }
        return false;
    }

    // 检查初始密码是否提醒修改
    private boolean initPasswordIsModify(Date pwdUpdateDate) {
        Integer initPasswordModify = Convert.toInt(configService.selectConfigByKey("sys.account.initPasswordModify"));
        return initPasswordModify != null && initPasswordModify ==1 && pwdUpdateDate == null;
    }

    @GetMapping("/system/main")
    public String main(ModelMap mmap){
        mmap.put("version",GalaxyConfig.getVersion());
        return "main";
    }

    // content-main class
    public String contentMainClass(Boolean footer, Boolean tagsView)
    {
        if (!footer && !tagsView)
        {
            return "tagsview-footer-hide";
        }
        else if (!footer)
        {
            return "footer-hide";
        }
        else if (!tagsView)
        {
            return "tagsview-hide";
        }
        return StringUtils.EMPTY;
    }

}
