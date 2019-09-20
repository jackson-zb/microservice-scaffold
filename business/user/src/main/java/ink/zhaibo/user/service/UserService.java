package ink.zhaibo.user.service;

import ink.zhaibo.user.api.GetUserRequest;
import ink.zhaibo.user.api.GetUserResponse;
import ink.zhaibo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public GetUserResponse getUser(GetUserRequest request) {
        return new GetUserResponse().setUser(userRepository.getOne(request.getUserId()));
    }
}
