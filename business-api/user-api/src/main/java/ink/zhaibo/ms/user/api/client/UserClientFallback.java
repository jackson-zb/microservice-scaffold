package ink.zhaibo.ms.user.api.client;

import ink.zhaibo.ms.common.api.ResultCode;
import ink.zhaibo.ms.user.api.dto.GetUserDto;
import org.springframework.stereotype.Component;

/**
 * @Author zhaibo
 * @Date 2019/10/17 14:26
 **/
@Component
public class UserClientFallback implements UserClient {

    @Override
    public GetUserDto getUser(Long userId) {
        GetUserDto dto = new GetUserDto();
        dto.setMessage("请求失败");
        dto.setCode(ResultCode.FAILURE);
        return dto;
    }
}
