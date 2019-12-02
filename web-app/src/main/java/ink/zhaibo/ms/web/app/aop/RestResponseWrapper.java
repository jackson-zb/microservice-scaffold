package ink.zhaibo.ms.web.app.aop;

import ink.zhaibo.ms.common.api.BaseResponse;
import ink.zhaibo.ms.common.api.ResultCode;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * @author zhaibo
 * @description 返回实体包装类
 * @date 2019/12/2
 */
@RestControllerAdvice
public class RestResponseWrapper implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
       /* Method returnTypeMethod = methodParameter.getMethod();
        if (returnTypeMethod != null) {
            return !returnTypeMethod.isAnnotationPresent(RestSkip.class);
        }*/
        return true;
    }

    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (MediaType.IMAGE_JPEG.getType().equalsIgnoreCase(mediaType.getType())) {
            return body;
        }
        if (body instanceof BaseResponse) {
            return body;
        }
        return new BaseResponse(ResultCode.SUCCESS, body);
    }
}
