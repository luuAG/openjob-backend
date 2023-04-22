package com.openjob.util;

import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class NullAwareBeanUtils extends BeanUtilsBean {
    private static final NullAwareBeanUtils _this = new NullAwareBeanUtils();
    public static NullAwareBeanUtils getInstance(){
        return _this;
    }
    @Override
    public void copyProperty(Object dest, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {
        if(Objects.isNull(value))
            return;
        super.copyProperty(dest, name, value);
    }
}
