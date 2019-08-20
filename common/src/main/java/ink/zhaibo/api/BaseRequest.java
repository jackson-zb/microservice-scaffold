package ink.zhaibo.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhaibo
 * @Date 2019/8/7 10:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseRequest {
    private String userId;
}
