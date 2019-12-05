package ink.zhaibo.ms.common.api;

import ink.zhaibo.ms.common.consts.GlobalConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhaibo
 * @date 2019/12/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 4851720251615536689L;
    @Builder.Default
    private Integer code = ResultCode.SUCCESS.getCode();
    @Builder.Default
    private String message = ResultCode.SUCCESS.getMsg();
    private Object data;
    @Builder.Default
    private String timeStamp = LocalDateTime.now().format(GlobalConstants.DATE_TIME_FORMATTER);

    public boolean isSuccess() {
        return code == ResultCode.SUCCESS.code;
    }

    public BaseResponse(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    public BaseResponse(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.data = data;
        this.timeStamp = LocalDateTime.now().format(GlobalConstants.DATE_TIME_FORMATTER);
    }

    public BaseResponse setFail() {
        return new BaseResponse(ResultCode.FAILURE);
    }

}
