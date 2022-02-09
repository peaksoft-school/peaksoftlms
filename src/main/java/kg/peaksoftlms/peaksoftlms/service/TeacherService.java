package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.dto.TeacherResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.model.User;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    Teacher findById(Long id);

    void create(User user);

    void update(Teacher teacher);

    void delete(Long id);

    Teacher findByUser(User user);

    List<Teacher> findAllByNameContaining(String name);

    Teacher getByName(String name);

    List<Teacher> getAllTeachers();

    Teacher getTeacherById(Long id);

    TeacherResponse getByEmail(String email);
}
