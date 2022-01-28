package kg.peaksoftlms.peaksoftlms;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
@RequiredArgsConstructor
@OpenAPIDefinition
public class PeaksoftlmsApplication {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User("admin@gmail.com", passwordEncoder.encode("qwerty"))
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }


    public static void main(String[] args) {
        SpringApplication.run(PeaksoftlmsApplication.class, args);
    }

}
