package com.example.transaction.config;

import com.example.transaction.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
        scanBasePackages = {
                "com.example.transaction.pojo",
                "com.example.transaction.dao",
                "com.example.transaction.controller",
                "com.example.transaction.config",
                "com.example.transaction.service",
                "com.example.transaction.interceptor",
                "com.example.transaction.util"
        })
public class TransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }

}