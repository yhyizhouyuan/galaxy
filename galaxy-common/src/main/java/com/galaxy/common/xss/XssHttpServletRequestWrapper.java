package com.galaxy.common.xss;

import com.galaxy.common.utils.html.EscapeUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/19 8:33
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    /**
     * @param request
     */
    public XssHttpServletRequestWrapper(HttpServletRequest request)
    {
        super(request);
    }

    @Override
    public String[] getParameterValues(String name)
    {
        String[] values = super.getParameterValues(name);
        if (values != null)
        {
            int length = values.length;
            String[] escapseValues = new String[length];
            for (int i = 0; i < length; i++)
            {
                // 防xss攻击和过滤前后空格
                escapseValues[i] = EscapeUtil.clean(values[i]).trim();
            }
            return escapseValues;
        }
        return super.getParameterValues(name);
    }
}
