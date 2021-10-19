package com.galaxy.common.utils.poi;

/**
 * <p> Excel数据格式处理适配器</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/14 10:40
 */
public interface ExcelHandlerAdapter {
    /**
     * 格式化
     *
     * @param value 单元格数据值
     * @param args excel注解args参数组
     *
     * @return 处理后的值
     */
    Object format(Object value,String[] args);
}
