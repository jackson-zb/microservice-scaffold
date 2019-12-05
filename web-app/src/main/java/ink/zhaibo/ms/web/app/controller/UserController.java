package ink.zhaibo.ms.web.app.controller;

import ink.zhaibo.ms.web.app.api.GetUserRequest;
import ink.zhaibo.ms.web.app.api.GetUserResponse;
import ink.zhaibo.ms.web.app.client.dto.GetUserDto;
import ink.zhaibo.ms.web.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

/**
 * @Author zhaibo
 * @Date 2019/9/20 11:18
 **/
@RestController
@Slf4j
@RequestMapping("/api/v1/user/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("getById")
    public GetUserResponse getUserById(@RequestBody @Valid GetUserRequest request) {
        GetUserDto getUserDto = restTemplate.getForObject("http://localhost:8000/user/1", GetUserDto.class, request.getUserId());
        GetUserResponse response = new GetUserResponse();
        BeanUtils.copyProperties(getUserDto,response);
        return response;
    }
}

