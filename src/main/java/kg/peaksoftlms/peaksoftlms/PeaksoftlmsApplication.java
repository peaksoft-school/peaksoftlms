package kg.peaksoftlms.peaksoftlms;

import kg.peaksoftlms.peaksoftlms.db.model.Role;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.db.repository.RoleRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
public class PeaksoftlmsApplication {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

//    @PostConstruct
    public void initUsers() {
        //admin role
        Role admin = Role.builder()
                .id(1L)
                .roleName("ROLE_ADMIN")
                .build();
        roleRepository.save(admin);

        // teacher role
        Role teacher = Role.builder()
                .id(2L)
                .roleName("ROLE_TEACHER")
                .build();
        roleRepository.save(teacher);

        // student role
        Role user = Role.builder()
                .id(3L)
                .roleName("ROLE_USER")
                .build();
        roleRepository.save(user);

        List<Role> roles = new ArrayList<>();
        roles.add(admin);

        List<User> users = Stream.of(
                new User("admin@gmail.com", passwordEncoder.encode("admin"), roles)

        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }


    public static void main(String[] args) {
        SpringApplication.run(PeaksoftlmsApplication.class, args);
    }

}
