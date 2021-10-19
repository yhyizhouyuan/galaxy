import com.galaxy.common.core.domain.entity.SysUser;
import com.galaxy.common.utils.StringUtils;
import com.galaxy.common.utils.bean.BeanUtils;
import org.apache.shiro.SecurityUtils;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/15 14:36
 */
public class GalaxyDeml {
    public static void main(String[] args) {
        System.out.println(getSysUser());
    }

    public static SysUser getSysUser() {
        SysUser user = null;
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if (StringUtils.isNotNull(obj)) {
            user = new SysUser();
            BeanUtils.copyBeanProp(user, obj);
        }
        return user;
    }
}
