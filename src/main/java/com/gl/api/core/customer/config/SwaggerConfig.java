package com.gl.api.core.customer.config;

import com.gl.api.core.customer.controller.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Swagger specific configuration. Enables Swagger for your application and
 * configures your API Docket. In addition, a default HomeController is defined
 * to redirect requests from the "root" directory to Swagger.</p>
 *
 * See the properties exposed in {@link SwaggerProperties}
 * to configure individual settings.
 */
@Configuration
@ConditionalOnProperty(value = "javelin.common.web.config.swagger.enabled", matchIfMissing = true)
@EnableSwagger2
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfig {
    @Autowired
    private SwaggerProperties properties;

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(properties.getControllerPackage()))
                .build().apiInfo(new ApiInfo(
                        properties.getApiName(), properties.getApiDescription()
                        , properties.getApiVersion(), null, properties.getAuthor(), null, null)
                );
    }

    @Bean
    public HomeController homeController() {
        return new HomeController();
    }

}
