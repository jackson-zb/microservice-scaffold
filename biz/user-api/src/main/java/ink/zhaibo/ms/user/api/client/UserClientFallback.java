package ink.zhaibo.ms.user.api.client;

import ink.zhaibo.ms.user.api.dto.GetUserDto;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * @Author zhaibo
 * @Date 2019/10/17 14:26
 **/
@Component
public class UserClientFallback implements UserClient {

    @Override
    public GetUserDto getUser(Long userId) {
        return null;
    }
}
