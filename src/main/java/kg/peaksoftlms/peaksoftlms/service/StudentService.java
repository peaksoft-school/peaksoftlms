package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.User;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    Student findByMssv(int mssv);

    void create(User user, int mssv);

    void addStudent(Student student);

    void update(Student student);

    void delete(Long id);
    Student getByName(String name);

    Student findByUser(User user);

//    List<Student> findAllByNameContaining(String name);

    int getMaxMssv();
}
