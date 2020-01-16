package com.xr.base.common.util;

import com.xr.base.common.enums.ResultCodeEnum;
import com.xr.base.common.exception.BaseException;

import java.util.Collection;
import java.util.Map;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-11 20:50:00 <br>
 * <b>description</b>: 断言工具类
 */
public final class AssertUtils {

    public static void isNull(Object object, String message) throws Exception {
        if (object != null) {
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }
    
    public static void notNull(Object object, String message) throws Exception {
        if (object == null) {
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }

    public static void notEmpty(String str, String message) throws Exception {
        if (str == null || str.trim().length() == 0) {
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) throws Exception {
        if (collection == null || collection.isEmpty()) {
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }

    public static void notEmpty(Map<?, ?> map, String message) throws Exception {
        if (map == null || map.isEmpty()) {
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }

    public static void largeThanZero(double a, String message) throws Exception {
        if( a <= 0){
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }

    public static void largeThanZero(long a, String message) throws Exception {
        if( a <= 0){
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }

    public static void isNumber(Object obj, String message) throws Exception {
        notNull(obj, "data must not be null");
        try {
            Double.valueOf(obj.toString());
        } catch (NumberFormatException nfe){
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }

    public static void isTrue(boolean isTrue, String message) throws Exception {
        if(isTrue){ return; }
        throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
    }
    
    private AssertUtils(){}
}
