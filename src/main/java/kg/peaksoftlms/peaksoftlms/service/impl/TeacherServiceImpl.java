package kg.peaksoftlms.peaksoftlms.service.impl;

import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.db.repository.TeacherRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.UserRepository;
import kg.peaksoftlms.peaksoftlms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public void create(User user) {
        Teacher teacher =
                new Teacher();
        teacherRepository.save(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();
        User user = teacher.getUser();
        teacherRepository.deleteById(id);
        if (user != null) {
            userRepository.delete(user);
        }
    }


}
