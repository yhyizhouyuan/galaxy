package com.galaxy.common.utils;

import com.galaxy.common.utils.spring.SpringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * <p>获取i18n资源文件</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/14 12:18
 */
public class MessageUtils {
    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return 获取国际化翻译值
     */
    public static String message(String code, Object... args)
    {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
