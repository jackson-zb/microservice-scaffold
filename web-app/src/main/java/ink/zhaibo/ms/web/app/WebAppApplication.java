package ink.zhaibo.ms.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author zhaibo
 * @Date 2019/10/16 18:04
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {
        "ink.zhaibo.ms.user.api.client"
})
@ComponentScan(basePackages = {
        "ink.zhaibo.ms.web.app",
        "ink.zhaibo.ms.user.svc",
})
public class WebAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAppApplication.class, args);
    }
}
