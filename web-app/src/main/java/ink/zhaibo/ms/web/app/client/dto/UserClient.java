package ink.zhaibo.ms.web.app.client.dto;

import ink.zhaibo.ms.user.api.dto.GetUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @Author zhaibo
 * @Date 2019/10/17 14:24
 */
@FeignClient(name = "user-svc", path = "/user/", fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("{id}")
    GetUserDto getUser(@PathVariable(value = "id") Long id);
}
