package ink.zhaibo.ms.common.aop;

import com.alibaba.fastjson.JSON;
import ink.zhaibo.ms.common.api.BaseResponse;
import ink.zhaibo.ms.common.exception.ResultCode;
import ink.zhaibo.ms.common.exception.ServiceException;
import ink.zhaibo.ms.common.utils.AspectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhaibo
 * @date 2019/12/7
 */
@Aspect
@Component
@Slf4j
public class ServiceAspect {
    @Pointcut("execution(* ink..*zhaibo..*svc.controller..*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();
        Class<?> returnType = method.getReturnType();
        log.info("Method {} begin...", methodName);
        Object result = null;
        try {
            result = joinPoint.proceed(joinPoint.getArgs());
            if (result != null) {
                log.info("Method {} result:{}", methodName, result.toString());
            }
        } catch (ServiceException e) {
            if (BaseResponse.class.isAssignableFrom(returnType)) {
                result = AspectUtil.setErrorResult(returnType, e.getResultCode());
            }
        } catch (Exception e) {
            result = AspectUtil.setErrorResult(returnType, ResultCode.FAILURE);
        }
        log.info("response:{}", JSON.toJSONString(result));
        return result;
    }

}
