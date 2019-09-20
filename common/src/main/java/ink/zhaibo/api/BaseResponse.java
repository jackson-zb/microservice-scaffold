package ink.zhaibo.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author zhaibo
 * @Date 2019/8/7 10:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse implements Serializable{
    private static final long serialVersionUID = 4851720251615536689L;
    private String message;
    private Object data;

    @Builder.Default
    private ResultCode code = ResultCode.SUCCESS;
    public boolean isSuccess() {
        return code == ResultCode.SUCCESS;
    }
}
