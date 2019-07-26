package com.ywy.mybatisdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ve
 * @date 2019/7/27 0:25
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket customDocket() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2);

        ParameterBuilder userTokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        userTokenPar.name("User-Token").description("user token")
                .modelRef(new ModelRef("string"))
                .parameterType("header").defaultValue("86ca3056-38b1-4a7c-a128-951df2261edd")
                .required(false).build();
        pars.add(userTokenPar.build());
        docket=docket.apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ywy.mybatisdemo.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)

        ;
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("mybatis-demo")
                .description("ssm mvc lombok")
                .contact(new Contact("ve", "https://github.com/834250018/mybatis-demo", "834250018@qq.com"))
                .version("1.0")
                .build();
    }
}
