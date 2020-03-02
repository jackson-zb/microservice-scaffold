package ink.zhaibo.ms.web.app;

import ink.zhaibo.ms.web.app.client.UserClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhaibo
 * @date 2019/12/2
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(clients = {
        UserClient.class
})
@ComponentScan(basePackages = {
        "ink.zhaibo.ms.web.app",
        "ink.zhaibo.ms.common.exception",
        "ink.zhaibo.ms.common.aop",
})
public class WebAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAppApplication.class, args);
    }
}
