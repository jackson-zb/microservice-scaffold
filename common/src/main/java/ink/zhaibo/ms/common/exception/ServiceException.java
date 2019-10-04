package ink.zhaibo.ms.common.exception;

import ink.zhaibo.ms.common.api.ResultCode;
import lombok.Getter;

/**
 * Business Service Exception
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 2359767895161832954L;

    @Getter
    private final ResultCode resultCode;

    public ServiceException(String message) {
        super(message);
        this.resultCode = ResultCode.FAILURE;
    }

    public ServiceException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }

    public ServiceException(ResultCode resultCode, String msg) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ServiceException(ResultCode resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
        this.resultCode = ResultCode.FAILURE;
    }

    /**
     * for better performance
     *
     * @return Throwable
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }
}
