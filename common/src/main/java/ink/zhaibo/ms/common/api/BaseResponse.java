package ink.zhaibo.ms.common.api;

import ink.zhaibo.ms.common.consts.GlobalConstants;
import ink.zhaibo.ms.common.exception.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhaibo
 * @date 2019/12/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 4851720251615536689L;
    public static final String CODE = "code";
    public static final String MESSAGE = "message";
    public static final String DATA = "data";
    public static final String TIMESTAMP = "timeStamp";

    private Integer code = ResultCode.SUCCESS.getCode();
    private String message = ResultCode.SUCCESS.getMsg();
    private Object data;
    private String timeStamp = "";

    public BaseResponse(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.data = new JSONObject();
        this.timeStamp = LocalDateTime.now().format(GlobalConstants.DATE_TIME_FORMATTER);
    }

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = new JSONObject();
        this.timeStamp = LocalDateTime.now().format(GlobalConstants.DATE_TIME_FORMATTER);
    }

    public BaseResponse(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.data = data;
        this.timeStamp = LocalDateTime.now().format(GlobalConstants.DATE_TIME_FORMATTER);
    }

    public void setErrResponse(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.data = new JSONObject();
        this.timeStamp = LocalDateTime.now().format(GlobalConstants.DATE_TIME_FORMATTER);
    }

    public void setErrResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = new JSONObject();
        this.timeStamp = LocalDateTime.now().format(GlobalConstants.DATE_TIME_FORMATTER);
    }
}
