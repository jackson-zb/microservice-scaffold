package ink.zhaibo.ms.web.app.service;

import ink.zhaibo.ms.user.api.client.UserClient;
import ink.zhaibo.ms.user.api.dto.GetUserDto;
import ink.zhaibo.ms.web.app.api.GetUserRequest;
import ink.zhaibo.ms.web.app.api.GetUserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service("userService")
public class UserService {
    @Autowired
    UserClient userClient;

    public GetUserResponse getUser(@Valid GetUserRequest request) {
        GetUserDto getUserDto = userClient.getUser(request.getUserId());
        GetUserResponse response = new GetUserResponse();
        BeanUtils.copyProperties(getUserDto, response);
        return response;
    }
}
