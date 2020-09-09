package cn.lcd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WfyEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(WfyEurekaApplication.class, args);
    }
}
