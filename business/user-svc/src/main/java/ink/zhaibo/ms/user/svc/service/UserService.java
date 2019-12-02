package ink.zhaibo.ms.user.svc.service;

import ink.zhaibo.ms.user.svc.dto.GetUserDto;
import ink.zhaibo.ms.user.svc.entity.User;
import ink.zhaibo.ms.user.svc.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public GetUserDto getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        GetUserDto response = new GetUserDto();
        if (user.isPresent()) {
            BeanUtils.copyProperties(user.get(), response);
        }
        return response;
    }
}
