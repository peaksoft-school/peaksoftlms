package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.model.User;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    Teacher findById(Long id);

    void create(User user);

    void update(Teacher teacher);

    void delete(Long id);

}
