package ink.zhaibo.ms.web.app.api;

import ink.zhaibo.ms.common.api.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserRequest extends BaseRequest {
    private static final long serialVersionUID = 4583025754112659044L;
    @NotNull
    private Long userId;
}
