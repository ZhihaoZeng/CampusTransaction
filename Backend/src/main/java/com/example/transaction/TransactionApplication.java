package com.example.transaction;

import com.example.transaction.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
        scanBasePackages = {
                "com.example.transaction.pojo",
                "com.example.transaction.dao",
                "com.example.transaction.controller",
                "com.example.transaction.config",
                "com.example.transaction.service"
        })
public class TransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }

}