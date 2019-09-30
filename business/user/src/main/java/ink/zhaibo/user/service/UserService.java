package ink.zhaibo.user.service;

import ink.zhaibo.user.api.GetUserRequest;
import ink.zhaibo.user.api.GetUserResponse;
import ink.zhaibo.user.entity.User;
import ink.zhaibo.user.repository.UserRepository;
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
        if (user == null) {
            BeanUtils.copyProperties(user, response);
        }
        return response;
    }
}
