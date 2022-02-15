package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.User;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    Student saveStudent(Student student);

    Student delete(Long id);

    Student getByName(String name);

    Student findByUser(User user);

}
