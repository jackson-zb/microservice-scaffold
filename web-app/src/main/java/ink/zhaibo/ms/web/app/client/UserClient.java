package ink.zhaibo.ms.web.app.client;

import ink.zhaibo.ms.web.app.client.dto.GetUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhaibo
 * @date 2019/12/2
 */
@FeignClient(name = "user-svc", path = "/user/", fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("{id}")
    GetUserDto getUser(@PathVariable(value = "id") Long id);
}
