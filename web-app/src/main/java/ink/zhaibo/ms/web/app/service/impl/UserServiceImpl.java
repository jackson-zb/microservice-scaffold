package ink.zhaibo.ms.web.app.service.impl;

import ink.zhaibo.ms.common.exception.ResultCode;
import ink.zhaibo.ms.common.exception.ServiceException;
import ink.zhaibo.ms.web.app.api.GetUserRequest;
import ink.zhaibo.ms.web.app.api.GetUserResponse;
import ink.zhaibo.ms.web.app.client.UserClient;
import ink.zhaibo.ms.web.app.client.dto.GetUserDto;
import ink.zhaibo.ms.web.app.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * @author zhaibo
 * @date 2019/12/3
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserClient userClient;

    @Override
    public GetUserResponse getUserById(@Valid GetUserRequest request) {
        GetUserDto getUserDto = userClient.getUser(request.getUserId());
        GetUserResponse response = new GetUserResponse();
        BeanUtils.copyProperties(getUserDto, response);
        return response;
    }
}
