package kg.peaksoftlms.peaksoftlms.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("All")
                .select()
                .apis(RequestHandlerSelectors.basePackage("kg.peaksodtlms.peaksoftlms.controller.rest"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(apiKey()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("PeaksoftLms")
                .description("PeaksoftLms - a place for learn programming")
                .termsOfServiceUrl("localhost")
                .version("apiVersion")
                .build();
    }


//    @Bean
//    public Docket apiTeacher() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("Teacher")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("kg.peaksoftlms.peaksoftlms.controller.rest.teacher"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo())
//                .securitySchemes(Arrays.asList(apiKey()));
//    }
//
//    @Bean
//    public Docket apiStudent() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("User")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("kg.peaksoftlms.peaksoftlms.controller.rest.student"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo())
//                .securitySchemes(Arrays.asList(apiKey())) ;
//    }
//


    private ApiKey apiKey() {
        return new ApiKey("jwtToken", "Authorization", "header");
    }}




