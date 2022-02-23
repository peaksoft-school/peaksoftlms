package kg.peaksoftlms.peaksoftlms.service.impl;

import kg.peaksoftlms.peaksoftlms.db.dto.StudentRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Role;
import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.db.repository.RoleRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.TeacherRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.UserRepository;
import kg.peaksoftlms.peaksoftlms.exeption.ResourceNotFoundException;
import kg.peaksoftlms.peaksoftlms.mapper.TeacherMapper;
import kg.peaksoftlms.peaksoftlms.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;
    private final TeacherMapper mapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<TeacherResponse> findAll() {
        return mapper.teacherListTeacherResponseList(teacherRepository.findAll());
    }

    @Override
    public TeacherResponse findById(Long id) {
        return mapper.teacherToTeacherResponse(teacherRepository.findById(id).orElseThrow(() -> {
            log.info("Not found teacher with this id: {}", id);
            throw new ResourceNotFoundException("Not found teacher with this id: " + id);
        }));
    }

    private User createUser(TeacherRequest request) {
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.getRoleByRoleName("ROLE_TEACHER"));
        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setRole(roles);
        return userRepository.save(newUser);
    }

    @Override
    public TeacherResponse save(TeacherRequest teacherRequest) {
        Teacher teacher = new Teacher();
        User user = createUser(teacherRequest);
        mapper.teacherRequestToTeacher(teacherRequest, teacher);
        teacher.setId(user.getId());
        teacher.setUser(user);
        return mapper.teacherToTeacherResponse(teacherRepository.save(teacher));
    }

    @Override
    public TeacherResponse update(TeacherRequest teacherRequest, Long id) {
        Teacher teacher = (teacherRepository.findById(id).orElseThrow(() -> {
            log.info("Not found teacher with this id: {}", id);
            throw new ResourceNotFoundException("Not found teacher with this id: " + id);
        }));

        mapper.teacherUpdate(teacherRequest, teacher);
        userRepository.save(updateUser(teacherRequest, teacher));
        teacherRepository.save(teacher);
        return mapper.teacherToTeacherResponse(teacher);
    }

    private User updateUser(TeacherRequest teacherRequest, Teacher teacher) {
        User user = teacher.getUser();
        user.setEmail(teacherRequest.getEmail());
        user.setPassword(passwordEncoder.encode(teacherRequest.getPassword()));
        return user;
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
