package ink.zhaibo.ms.user.svc.dto;

import ink.zhaibo.ms.common.api.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GetUserDto extends BaseResponse implements Serializable{
    private static final long serialVersionUID = -3480857767475234603L;
    private String userName;
    private String password;
    private String cellphone;
}
