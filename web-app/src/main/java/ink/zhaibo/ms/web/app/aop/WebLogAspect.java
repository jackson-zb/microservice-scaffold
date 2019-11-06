package ink.zhaibo.ms.web.app.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(* ink..*zhaibo..*web.app.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void webLog() {
    }

    @Around("webLog()")
    public Object doAroud(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("========================================== Start ==========================================");
        log.info("URL :{}", request.getRequestURI());
        log.info("HTTP Method :{}", request.getMethod());
        log.info("Class Method:{}.{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
        log.info("IP :{}", request.getRemoteAddr());
        Object[] obj = proceedingJoinPoint.getArgs();
        Map<String, Object> map = new HashMap<>();
        if (obj != null && obj.length > 0) {
            Object o = obj[0];
            map = getKeyAndValue(o);
            for (Map.Entry<String, Object> m : map.entrySet()) {
                String s = String.valueOf(m.getValue());
                if (s.length() >= 1000) {
                    s = s.substring(0, 1000) + "....";
                    map.put(m.getKey(), s);
                }
            }
        }
        log.info("Request Args :{}", JSON.toJSONString(map));
        Object result = proceedingJoinPoint.proceed();
        log.info("Response Args : {}", JSON.toJSONString(result));
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        log.info("========================================== end ==========================================");
        return result;
    }

    public static Map<String, Object> getKeyAndValue(Object obj) {
        Map<String, Object> map = new HashMap<>();
        Class userCla = (Class) obj.getClass();
        for (int a = 0; a < 3; a++) {
            Field[] fs = userCla.getDeclaredFields();
            for (int i = 0; i < fs.length; i++) {
                Field f = fs[i];
                f.setAccessible(true);
                Object val = new Object();
                try {
                    val = f.get(obj);
                    map.put(f.getName(), val);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            userCla = userCla.getSuperclass();
        }
        return map;
    }
}