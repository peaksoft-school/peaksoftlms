package kg.peaksoftlms.peaksoftlms;

import kg.peaksoftlms.peaksoftlms.model.Role;
import kg.peaksoftlms.peaksoftlms.model.User;
import kg.peaksoftlms.peaksoftlms.temp.RoleRepository;
import kg.peaksoftlms.peaksoftlms.temp.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class PeaksoftlmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeaksoftlmsApplication.class, args);
		System.out.println("Hey, Aza, Maks, Nurperi, Aida, the project name is Peaksoftlms");
	}

//	@Bean
//	CommandLineRunner commandLineRunner(UserRepository repository, RoleRepository roleRepository) {
//		return args -> {
//			Role role = new Role(null, "ROLE_ADMIN");
//			Role role2 = new Role(null, "ROLE_STUDENT");
//////
//////			User user = new User(null, "max@gmail.com", "123", "Max", "Akyl",
//////					null, null, null, null, null, Arrays.asList(role));
//////			User user2 = new User(null, "nurperi@gmail.com", "123", "Nurperi", "Arzykulova",
//////					null, null, null, null, null, Arrays.asList(role2));
////
////			repository.save(user);
////			repository.save(user2);
//		};

}
