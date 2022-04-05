package kg.peaksoftlms.peaksoftlms.testPackage;//package kg.peaksoftlms.peaksoftlms.config;

import kg.peaksoftlms.peaksoftlms.db.model.*;
//import kg.peaksoftlms.peaksoftlms.db.model.lesson.*;
import kg.peaksoftlms.peaksoftlms.db.repository.*;
import kg.peaksoftlms.peaksoftlms.service.StudentService;
import kg.peaksoftlms.peaksoftlms.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@Transactional
@AllArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final TeacherService teacherService;
    private final StudentService studentService;


//    @PostConstruct
    public void userAndRoleInit() {
        Role studentRole = new Role("STUDENT");
        Role teacherRole = new Role("TEACHER");
        List<Role> roleList = List.of(studentRole, teacherRole);
        roleRepository.saveAll(roleList);

        User userTeacher = new User();
        userTeacher.setEmail("teacher@gmail.com");
        userTeacher.setRole(roleRepository.getRoleByRoleName("TEACHER"));
        userTeacher.setPassword(passwordEncoder.encode("1"));
        userRepository.save(userTeacher);

        Teacher teacher = new Teacher(
                userTeacher.getId(),
                "Fatih",
                "Baskapan",
                "image/url",
                "+996707231088",
                "teacher", new Date(), userTeacher);
        teacherService.save(teacher);

        User studentUser = new User();
        studentUser.setEmail("samjer@gmail.com");
        studentUser.setPassword(passwordEncoder.encode("2"));
        studentUser.setRole(roleRepository.getRoleByRoleName("STUDENT"));
        userRepository.save(studentUser);

        Student student = new Student(studentUser.getId(), "Sanjar", "Baktalbekov", "+996707231088", "image/url", new Date(), studentUser);
        studentService.save(student);


    }
}


