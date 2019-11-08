package ink.zhaibo.ms.common.api;

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
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 4851720251615536689L;
    @Builder.Default
    private String message = ResultCode.SUCCESS.getMsg();

    @Builder.Default
    private Integer code = ResultCode.SUCCESS.getCode();

    @Builder.Default
    private ResultCode result = ResultCode.SUCCESS;

    /**
     * 业务数据
     */
    private Object data;

    public boolean isSuccess() {
        return code == ResultCode.SUCCESS.code;
    }

    public BaseResponse(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    public BaseResponse setFail() {
        return new BaseResponse(ResultCode.FAILURE);
    }

}
