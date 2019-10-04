package ink.zhaibo.ms.common.aop;


import ink.zhaibo.ms.common.api.BaseResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BizAspect {
    /*@Pointcut("execution(* ink..*zhaibo..*controller..*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void controllerPointcut() {
    }

    @Around("controllerPointcut()")
    public Object interceptor(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Object proceed = joinPoint.proceed(args);
        BaseResponse response = new BaseResponse();
        response.setData(proceed);
        return response;
    }*/
}
