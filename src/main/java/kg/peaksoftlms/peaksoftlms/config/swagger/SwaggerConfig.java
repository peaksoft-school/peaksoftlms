package kg.peaksoftlms.peaksoftlms.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI peaksoftlms() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("PeaksoftLMS Application Swagger for Front-End Team")
                                .version("3.0.2")
                                .contact(
                                        new Contact()
                                                .name("Max from Java-3")
                                                .name("Team: Max, Aida, Beksultan, Atabek")
                                )
                );
    }
}




