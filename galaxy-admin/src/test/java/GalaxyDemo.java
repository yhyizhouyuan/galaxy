import com.galaxy.GalaxyApplication;
import com.galaxy.common.core.controller.BaseController;
import com.galaxy.common.core.domain.entity.SysDept;
import com.galaxy.common.core.domain.entity.SysMenu;
import com.galaxy.common.core.domain.entity.SysUser;
import com.galaxy.common.core.domain.entity.Ztree;
import com.galaxy.common.utils.StringUtils;
import com.galaxy.common.utils.bean.BeanUtils;
import com.galaxy.domain.SysPost;
import com.galaxy.system.service.ISysDeptService;
import com.galaxy.system.service.ISysMenuService;
import com.galaxy.system.service.ISysPostService;
import com.galaxy.system.service.ISysRoleService;
import org.apache.shiro.SecurityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;

import java.util.List;
import java.util.Set;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/15 14:36
 */
@SpringBootTest(classes = GalaxyApplication.class)
public class GalaxyDemo extends BaseController {

    @Autowired
    private ISysMenuService sysMenuService;

    @Autowired
    private ISysPostService sysPostService;

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private ISysRoleService sysRoleService;
    @Test
    public void treeTest(){
        SysMenu sysMenu = new SysMenu();
        List<SysMenu> menuList = sysMenuService.selectMenuList(sysMenu, 1L);
        System.out.println(menuList);
    }
    @Test
    public void postTest(){
        startPage();
        SysPost sysPost = new SysPost();
        List<SysPost> list = sysPostService.selectPostList(sysPost);
        System.out.println(list);
        System.out.println(getDataTable(list));

    }
    @Test
    public void treeData(){
        List<Ztree> ztrees = sysDeptService.selectDeptTree(new SysDept());
        System.out.println(ztrees);
    }

    @Test
    public void testRoleKey(){
        Set<String> set = sysRoleService.selectRoleKeys(1l);
        System.out.println(set);
    }

}
