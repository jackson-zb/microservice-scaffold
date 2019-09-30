package ink.zhaibo.user.controller;

import ink.zhaibo.user.api.GetUserRequest;
import ink.zhaibo.user.api.GetUserResponse;
import ink.zhaibo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author zhaibo
 * @Date 2019/9/20 11:18
 **/
@RestController
@RequestMapping("/api/v1/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("getById")
    public GetUserResponse getUser(@RequestBody @Valid GetUserRequest request) {
        GetUserResponse response = userService.getUser(request);
        return response;
    }
}
