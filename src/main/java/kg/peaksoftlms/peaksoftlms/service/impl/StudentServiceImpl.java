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
public class StudentServiceImpl implements StudentService {


     private final StudentRepository studentRepository;
     private final UserRepository userRepository;

     public StudentServiceImpl(StudentRepository studentRepository, UserRepository userRepository) {
          this.studentRepository = studentRepository;
          this.userRepository = userRepository;
     }

     @Override
     public List<Student> findAll() {
          return studentRepository.findAll();
     }
     @Override
     public Student findById(Long id) {
          return studentRepository.findById(id).get();
     }

     @Override
     public Student saveStudent(Student student){
          return studentRepository.save(student);
     }
     @Override
     public Student delete(Long id) {
          studentRepository.deleteById(id);
          return studentRepository.findById(id).get();
     }

     @Override
     public Student getByName(String name) {
          return studentRepository.getByName(name);
     }

     @Override
     public Student findByUser(User user) {
          return studentRepository.findByUser(user);
     }

}
