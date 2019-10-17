package ink.zhaibo.ms.biz.user.svc.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "rocketmq.consumer")
@Configuration
@ToString
public class ConsumerConfig {
    private String groupName;
    private String namesrvAddr;
}
