package me.shengeNo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "me.shengeNo1")
@EnableTransactionManagement
@EnableAsync
public class AppRun {

    public static void main(String[] args) {
        SpringApplication.run(AppRun.class,args);
    }
}
