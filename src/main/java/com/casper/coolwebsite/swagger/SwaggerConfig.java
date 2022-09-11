package com.casper.coolwebsite.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //啟動swagger2
public class SwaggerConfig {
    //設定Swagger的Docket的bean範例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                //.apiInfo(apiInfo())//設定Swagger資訊
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.casper.coolwebsite"))
                .paths(PathSelectors.any())
                .build();
    }

}
