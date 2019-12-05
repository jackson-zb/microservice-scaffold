package ink.zhaibo.ms.web.app.service;

import ink.zhaibo.ms.web.app.api.GetUserRequest;
import ink.zhaibo.ms.web.app.api.GetUserResponse;

import javax.validation.Valid; /**
 * @author zhaibo
 * @date 2019/12/3
 */
public interface UserService {
    GetUserResponse getUserById(@Valid GetUserRequest request);
}
