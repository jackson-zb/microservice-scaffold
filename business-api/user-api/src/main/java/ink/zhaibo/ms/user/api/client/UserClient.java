package ink.zhaibo.ms.user.api.client;

import ink.zhaibo.ms.user.api.dto.GetUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @Author zhaibo
 * @Date 2019/10/17 14:24
 */
@FeignClient(name = "user-svc", path = "/user/", fallback = UserClientFallback.class)
public interface UserClient {

    @PostMapping("getById")
    GetUserDto getUser(Long userId);
}
