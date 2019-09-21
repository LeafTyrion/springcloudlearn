package com.leaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableAutoConfiguration
public class ZuulServerAppication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerAppication.class, args);
    }
}
