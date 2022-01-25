package kg.peaksoftlms.peaksoftlms.service.impl;

import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.db.repository.StudentRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.UserRepository;
import kg.peaksoftlms.peaksoftlms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
     @Autowired
     private StudentRepository studentRepository;
     @Autowired
     private UserRepository userRepository;

     @Override
     public List<Student> findAll() {
          return studentRepository.findAll();
     }
     @Override
     public Student findById(Long id) {
          return studentRepository.findById(id).get();
     }
     @Override
     public Student findByMssv(int mssv) {
          return studentRepository.findByMssv(mssv);
     }
     @Override
     public void create(User user, int mssv) {
          Student student = new Student(user);
          if (mssv <= 0) {
               student.setMssv(getMaxMssv() + 1);
          } else {
               student.setMssv(mssv);
          }
          studentRepository.save(student);
     }
     @Override
     public void addStudent(Student student){
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

     @Override
     public Student getByName(String name) {
          return studentRepository.getByName(name);
     }

     @Override
     public Student findByUser(User user) {
          return studentRepository.findByUser(user);
     }
//     @Override
//     public List<Student> findAllByNameContaining(String name) {
//          List<User> users = userRepository.findAllByNameContainingAndRole(name, "STUDENT");
//          List<Student> students = new ArrayList<>();
//          for (User user : users) {
//               Student student = new Student(user);
//               students.add(student);
//          }
//          return students;
//     }
     @Override
     public int getMaxMssv() {
          List<Student> students = studentRepository.findAll();
          int maxMssv = 0;
          for (Student student : students) {
               if (maxMssv < student.getMssv()) {
                    maxMssv = student.getMssv();
               }
          }
          return maxMssv;
     }
}
