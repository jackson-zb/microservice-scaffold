package ink.zhaibo.ms.common.consts;

import java.time.format.DateTimeFormatter;

/**
 * @author zhaibo
 * @date 2019/12/2
 */
public class GlobalConstants {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");

    public static final String JWT_SIGN_KEY = "min";
}
