package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    /**
     * 把 Map 集合中数据直接注入到 bean 对象中
     * @param bean
     * @param map
     * @param <T>
     * @return
     */
        public static <T>T copyParamToBean (T bean, Map map) {
            try {
                BeanUtils.populate(bean,map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return bean;
    }

    /**
     * 把字符串转换为Integer 类型变量
     * @param str
     * @param defaultValue
     * @return
     */
    public static Integer parseInt (String str,Integer defaultValue){
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }

}

