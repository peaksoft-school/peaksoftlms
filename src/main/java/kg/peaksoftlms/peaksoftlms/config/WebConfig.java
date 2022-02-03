package kg.peaksoftlms.peaksoftlms.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableTransactionManagement
@Configuration
public class WebConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
