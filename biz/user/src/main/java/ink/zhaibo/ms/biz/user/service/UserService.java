package ink.zhaibo.ms.biz.user.service;

import ink.zhaibo.ms.biz.user.api.GetUserResponse;
import ink.zhaibo.ms.biz.user.api.GetUserRequest;
import ink.zhaibo.ms.biz.user.entity.User;
import ink.zhaibo.ms.biz.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public GetUserResponse getUser(GetUserRequest request) {
        User user = userRepository.getOne(request.getUserId());
        GetUserResponse response = new GetUserResponse();
        if (user != null) {
            BeanUtils.copyProperties(user, response);
        }
        return response;
    }
}
