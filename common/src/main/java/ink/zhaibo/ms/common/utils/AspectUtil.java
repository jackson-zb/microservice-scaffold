package ink.zhaibo.ms.common.utils;

import ink.zhaibo.ms.common.exception.ResultCode;

import java.lang.reflect.Method;

/**
 * @author zhaibo
 * @date 2019/12/7
 */
public class AspectUtil {

    public static Object setErrorResult(Class<?> clazz, ResultCode resultCode) {
        Object response = null;
        try {
            response = clazz.newInstance();
            Method setErrResponse = clazz.getMethod("setErrResponse", ResultCode.class);
            setErrResponse.invoke(response, resultCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static Object setErrorResult(Class<?> clazz, Integer code, String message) {
        Object response = null;
        try {
            response = clazz.newInstance();
            Method setErrResponse = clazz.getMethod("setErrResponse", Integer.class, String.class);
            setErrResponse.invoke(response, code, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
