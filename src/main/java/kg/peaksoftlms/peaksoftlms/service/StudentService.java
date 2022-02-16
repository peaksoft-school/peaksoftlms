package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.dto.StudentRequest;
import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.User;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    void create(User user);

    void addStudent(StudentRequest student);

    void update(Student student);

    void delete(Long id);

}
