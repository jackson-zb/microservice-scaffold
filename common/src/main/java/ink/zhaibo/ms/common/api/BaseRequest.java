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
public class BaseRequest implements Serializable {
    private static final long serialVersionUID = -2304155085638896178L;
    private String token;
}
