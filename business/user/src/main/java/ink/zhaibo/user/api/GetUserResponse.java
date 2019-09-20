package ink.zhaibo.user.api;

import ink.zhaibo.api.BaseResponse;
import ink.zhaibo.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GetUserResponse extends BaseResponse {
    private static final long serialVersionUID = -3480857767475234603L;
    private User user;
}
