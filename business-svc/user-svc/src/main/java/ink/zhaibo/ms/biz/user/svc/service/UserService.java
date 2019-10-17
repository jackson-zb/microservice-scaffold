package ink.zhaibo.ms.biz.user.svc.service;

import ink.zhaibo.ms.biz.user.svc.entity.User;
import ink.zhaibo.ms.biz.user.svc.repository.UserRepository;
import ink.zhaibo.ms.user.api.dto.GetUserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public GetUserDto getUser(Long userId) {
        User user = userRepository.getOne(userId);
        GetUserDto response = new GetUserDto();
        if (user != null) {
            BeanUtils.copyProperties(user, response);
        }
        return response;
    }
}
