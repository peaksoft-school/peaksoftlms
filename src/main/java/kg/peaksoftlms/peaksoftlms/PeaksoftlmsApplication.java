package kg.peaksoftlms.peaksoftlms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
