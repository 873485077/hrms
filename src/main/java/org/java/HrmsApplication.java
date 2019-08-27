package org.java;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, MultipartAutoConfiguration.class}) //配出activiti的安全检测
public class HrmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);
    }

}
