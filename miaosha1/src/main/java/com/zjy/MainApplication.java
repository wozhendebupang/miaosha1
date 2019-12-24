package com.zjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主类放在主包下面，然后其他的类放在子包下面，方便扫描
 */
@SpringBootApplication
public class MainApplication {


    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
