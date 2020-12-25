package me.shengeNo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author LYS liuyua776@gmail.com
 * @version 1.0.0
 * @ClassName Swagger2Config.java
 * @Description TODO
 * @createTime 2020年12月24日 21:00:00
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("me.shengeNo1"))
                .build().apiInfo(new ApiInfoBuilder().description("微信小程序Api和安卓Api")
                .title("HZ ADMIN").build());
    }
}
