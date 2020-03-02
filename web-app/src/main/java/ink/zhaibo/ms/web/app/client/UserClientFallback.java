package ink.zhaibo.ms.web.app.client;

import ink.zhaibo.ms.web.app.client.dto.GetUserDto;
import org.springframework.stereotype.Component;

/**
 * @Author zhaibo
 * @Date 2019/10/17 14:26
 **/
@Component
public class UserClientFallback implements UserClient {

    @Override
    public GetUserDto getUser(Long userId) {
        return new GetUserDto();
    }
}
