package ink.zhaibo.ms.user.svc.controller;

import ink.zhaibo.ms.common.exception.ResultCode;
import ink.zhaibo.ms.common.exception.ServiceException;
import ink.zhaibo.ms.user.svc.dto.GetUserDto;
import ink.zhaibo.ms.user.svc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @Author zhaibo
 * @Date 2019/9/20 11:18
 **/
@RestController
@Slf4j
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public GetUserDto getUser(@NotNull @PathVariable Long id) {
        return userService.getUser(id);
    }
}

