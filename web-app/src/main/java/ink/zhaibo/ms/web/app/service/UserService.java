package ink.zhaibo.ms.web.app.service;

import ink.zhaibo.ms.user.api.client.UserClient;
import ink.zhaibo.ms.user.api.dto.GetUserDto;
import ink.zhaibo.ms.web.app.api.GetUserRequest;
import ink.zhaibo.ms.web.app.api.GetUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * @Author zhaibo
 * @Date 2019/10/17 18:44
 */
@Service("userService")
@Slf4j
public class UserService {
    @Autowired
    UserClient userClient;

    public GetUserResponse getUser(@Valid GetUserRequest request) {
        GetUserDto getUserDto = userClient.getUser(request.getUserId());
        log.info("用户Id:{}", request.getUserId().toString());
        GetUserResponse response = new GetUserResponse();
        BeanUtils.copyProperties(getUserDto, response);
        return response;
    }
}
