package kg.peaksoftlms.peaksoftlms.service.impl;

import kg.peaksoftlms.peaksoftlms.db.dto.StudentRequest;
import kg.peaksoftlms.peaksoftlms.db.model.Role;
import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.db.repository.RoleRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.StudentRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.UserRepository;
import kg.peaksoftlms.peaksoftlms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
     private final StudentRepository studentRepository;
     private final UserRepository userRepository;
     private final PasswordEncoder passwordEncoder;
     private final RoleRepository roleRepository;

     @Override
     public List<Student> findAll() {
          return studentRepository.findAll();
     }
     @Override
     public Student findById(Long id) {
          return studentRepository.findById(id).get();
     }

     @Override
     public void create(User user) {

     }

     @Override
     public void addStudent(StudentRequest request){

          Role role = roleRepository.getRoleByRoleName("ROLE_STUDENT");
          List<Role> roles = new ArrayList<>();
          roles.add(role);

          Student student = Student.builder()
                  .email(request.getEmail())
                  .lastName(request.getLastName())
                  .firstName(request.getFirstName())
                  .password(passwordEncoder.encode(request.getPassword()))
                  .studentImg(request.getStudentImg())
                  .build();

          User user = User.builder()
                  .email(request.getEmail())
                  .password(passwordEncoder.encode(request.getPassword()))
                  .build();

          user.setRole(roles);
          User resultUser = userRepository.save(user);
          student.setId(resultUser.getId());
          student.setUser(user);
          System.out.println(student);
          studentRepository.save(student);
     }
     @Override
     public void update(Student student) {
          studentRepository.save(student);
     }
     @Override
     public void delete(Long id) {
          Student student = studentRepository.findById(id).get();
          User user = student.getUser();
          studentRepository.deleteById(id);
          if (user != null) {
               userRepository.delete(student.getUser());
          }
     }


}
