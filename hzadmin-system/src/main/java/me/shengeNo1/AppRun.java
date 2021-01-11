package me.shengeNo1;

import me.shengeNo1.utils.SpringContextHolder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName AppRun.java
 * @Description TODO
 * @createTime 2021年01月02日 16:14:00
 */
@SpringBootApplication(scanBasePackages = "me.shengeNo1")
@MapperScan("me.shengeNo1")
public class AppRun {

    public static void main(String[] args) {
        SpringApplication.run(AppRun.class,args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }


}
