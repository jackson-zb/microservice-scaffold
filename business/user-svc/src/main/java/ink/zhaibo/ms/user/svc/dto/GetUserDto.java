package ink.zhaibo.ms.user.svc.dto;

import ink.zhaibo.ms.common.api.BaseResponse;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GetUserDto extends BaseResponse {
    private static final long serialVersionUID = -3480857767475234603L;
    private String userName;
    private String password;
    private String cellphone;
}
