package org.sitenv.directtransportmessagesender.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Brian on 8/18/2016.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${version:none}")
    private String applicationPomVersion;

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Direct Transport Message Sender")
                .description("Send a message from the sandbox to your system.")
                .version(applicationPomVersion)
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
}
