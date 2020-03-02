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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(* ink..*zhaibo..*web.app.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void webLog() {
    }

    @Around("webLog()")
    public Object doAroud(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("========================================== Start ==========================================");
        log.info("URL :{}", request.getRequestURI());
        log.info("HTTP Method :{}", request.getMethod());
        log.info("Class Method:{}.{}", methodSignature, methodName);
        log.info("IP :{}", request.getRemoteAddr());

        Object[] args = joinPoint.getArgs();
        log.info("Request Args :{}", JSON.toJSONString(args));

        Object result = null;
        Class<?> returnType = method.getReturnType();
        try {
            result = joinPoint.proceed(joinPoint.getArgs());
            if (result instanceof BaseResponse) {
                BaseResponse response = (BaseResponse) result;
                if (response.getCode() != HttpStatus.OK.value()) {
                    result = AspectUtil.setErrorResult(returnType, response.getCode(),response.getMessage());
                }
            }
        } catch (ServiceException e) {
            if (BaseResponse.class.isAssignableFrom(returnType)) {
                result = AspectUtil.setErrorResult(returnType, e.getResultCode());
            }
        } catch (Exception e) {
            result = AspectUtil.setErrorResult(returnType, ResultCode.FAILURE);
        }
        log.info("Response Args : {}", JSON.toJSONString(result));
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        log.info("========================================== end ==========================================");
        return result;
    }
}