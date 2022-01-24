package kg.peaksoftlms.peaksoftlms.config;

import kg.peaksoftlms.peaksoftlms.db.model.*;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.*;
import kg.peaksoftlms.peaksoftlms.db.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
@AllArgsConstructor
public class DataInitializer {

    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @PostConstruct
    public void DBinit() {
        for (int i = 0; i < 1; i++) {
            userAndRoleInit();
            courseAndLessonInit();
        }
    }

    public void courseAndLessonInit() {
        Presentation presentation = new Presentation();
        presentation.setPresentationName("Java get started");
        presentation.setDescription("Java introduction");
        presentation.setPresentation("Java");
//        presentation.setLesson();

        Task task = new Task();
        task.setTaskName("Hello world");
        task.setTask("Write a correct syntax to output \"Hello World\"");
        task.setImg("https://www.codewithc.com/wp-content/uploads/2015/05/java-projects-source-code.jpg");
//       task.setLesson();

        Test test = new Test();
        test.setTestName("Java Core");
        test.setQuestion("How do you insert COMMENTS in Java code?");
        test.setAnswer("//This is comment");
//        test.setLesson();

        Video video = new Video();
        video.setVideoName("Java for beginners");
        video.setVideo("https://www.youtube.com/watch?v=ziOQ8wkmnSE&t=70s");
        // video.setLesson();

        Lesson lesson1 = new Lesson();
        lesson1.setLessonName("Java Introduction");
        lesson1.setLink("https://www.w3schools.com/java/java_intro.asp");

        presentation.setLesson(lesson1);
        task.setLesson(lesson1);
        test.setLesson(lesson1);
        video.setLesson(lesson1);

        lesson1.setPresentations(List.of(presentation));
        lesson1.setTasks(List.of(task));
        lesson1.setTests(List.of(test));
        lesson1.setVideos(List.of(video));

        Course course = new Course();
        course.setName("Java");
        course.setDescription("From 0 to java developer in 9 mounth");
        course.setImg("https://www.google.com/search?q=java&rlz=1C1GCEA_enKG962KG963&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjH57iG7av1AhXksIsKHcdPBIUQ_AUoAXoECAIQAw&biw=1536&bih=722&dpr=1.25#imgrc=Rnyd8T8FYQqEgM");
        course.setPrice(12000);
        course.setDateOfCreate(LocalDate.of(2022, 01, 12));
        course.setLesson(List.of(lesson1));

        lesson1.setCourse(course);//add

        Group group = new Group();
        group.setName("Java batch-5");
        group.setDescription("Learn Java in best way");
        group.setDateOfCreate(LocalDate.of(2022, 01, 04));
        group.setCourses(List.of(course));

        Student student = new Student();
        student.setStudentName("Dwayne");
        student.setStudentLastName("Jhonson");
        student.setStudentEmail("Jhon@gmail.com");
        student.setStudentImg("http://www.supercoloring.com/ru/raskraski/bokser-wwe-dueyn-skala-dzhonson?version=print");
        student.setPassword("$2a$10$UB2icSS/ElHIPrYgPPFCDOYrl2PcUyM..VN76U9/9zsZwhj8LCK3m");
        student.setDateOfCreate(LocalDate.of(2022, 01, 03));

        group.setStudents(List.of(student));

        groupRepository.save(group);

        Teacher teacher = new Teacher();
        teacher.setTeacherName("Jessica");
        teacher.setTeacherEmail("pots@gmail.com");
        teacher.setTeacherImg("https://www.istockphoto.com/photo/female-teacher-pointing-with-finger-at-mathematical-equation-on-chalkboard-in-class-gm1080232656-289543884");
        teacher.setTeacherLastName("Pots");
        teacher.setPassword("$2a$10$kVr1tfyNWUqI3nyc3CUJreOhNhbp54p83OE8lWI5iuOxYU6uClYkm");
        teacher.setDateOfCreate(LocalDate.of(2022, 01, 02));
        course.setTeacher(List.of(teacher));
        teacher.setCourse(List.of(course));
        courseRepository.save(course);
    }

    public void userAndRoleInit() {
        User user = new User();
        user.setEmail("student@gmail.com");
        user.setPassword("$2a$10$Wf1jDaf3lsEvAhXr//F25OdykEVUa66/fUlUTPdQ0iebvIzMd6iZC");

        Role role = new Role();
        role.setRoleName("ROLE_STUDENT");
        List<Role> roleListStudent = new ArrayList<>();
        roleListStudent.add(role);

        user.setRole(roleListStudent);
        roleRepository.save(role);
        userRepository.save(user);

        Role role1 = new Role();
        role1.setRoleName("ROLE_TEACHER");
        List<Role> roleListTeacher = new ArrayList<>();
        roleListTeacher.add(role1);

        User user1 = new User();
        user1.setEmail("teacher@gmail.com");
        user1.setPassword("$2a$10$XCrC9jOvm0nVt412ZP0s2ebGtNpMhoBwWGz49Qcr0WDzud8nhKhRC");
        user1.setRole(roleListTeacher);
        roleRepository.save(role1);
        userRepository.save(user1);

        Role role2 = new Role();
        role2.setRoleName("ROLE_ADMIN");
        List<Role> roleListAdmin = new ArrayList<>();
        roleListAdmin.add(role2);

        User user2 = new User();
        user2.setEmail("admin@gmail.com");
        user2.setPassword("$2a$10$iRo/ASHisFqVd2ImPypXR.o9hjxH6cc0uVmR77XZ6FAPppI78pEhG");
        user2.setRole(roleListAdmin);
        roleRepository.save(role2);
        userRepository.save(user2);
    }
}


