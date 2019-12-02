package ink.zhaibo.ms.web.app.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GetUserResponse implements Serializable{
    private static final long serialVersionUID = -3480857767475234603L;
    private String userName;
    private String password;
    private String cellphone;
}
