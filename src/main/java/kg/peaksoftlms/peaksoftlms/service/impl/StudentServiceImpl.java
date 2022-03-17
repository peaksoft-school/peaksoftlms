package kg.peaksoftlms.peaksoftlms.service.impl;

import kg.peaksoftlms.peaksoftlms.db.dto.StudentRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.StudentResponse;

import kg.peaksoftlms.peaksoftlms.db.model.Role;
import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.db.repository.RoleRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.StudentRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.UserRepository;
import kg.peaksoftlms.peaksoftlms.exeption.ResourceNotFoundException;
import kg.peaksoftlms.peaksoftlms.mapper.StudentMapper;
import kg.peaksoftlms.peaksoftlms.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@Slf4j
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final StudentMapper mapper;

    @Override
    public List<StudentResponse> findAll(int page, int size) {
        return mapper.studentListToStudentResponseList(studentRepository.findAll(PageRequest.of(page, size)).getContent());
    }

    @Override
    public StudentResponse findById(Long id) {
        return mapper.studentToStudentResponse(studentRepository.findById(id).orElseThrow(() -> {
            log.info("Not found student with id: {}", id);
            throw new ResourceNotFoundException("Not found student with id: " + id);
        }));
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentResponse saveNew(StudentRequest request) {
        User user = createUser(request);
        Student student = new Student();
        mapper.studentRequestToStudent(student, request);
        student.setId(user.getId());
        student.setUser(user);
        return mapper.studentToStudentResponse(studentRepository.save(student));
    }

    @Override
    public StudentResponse update(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id).orElseThrow(() -> {
            log.info("Not found student with id: {}", id);
            throw new ResourceNotFoundException("Not found student with id: " + id);
        });
        userRepository.save(updateUser(studentRequest, student));
        mapper.updateStudent(student, studentRequest);
        return mapper.studentToStudentResponse(studentRepository.save(student));
    }

    @Override
    public void delete(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> {
            log.info("Not found student with id: {}", id);
            throw new ResourceNotFoundException("Not found student with id: " + id);
        });
        User user = student.getUser();
        studentRepository.deleteById(id);
        if (user != null) {
            userRepository.delete(student.getUser());
        }
    }

    private User createUser(StudentRequest request) {
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.getRoleByRoleName("ROLE_STUDENT"));
        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setRole(roles);
        return userRepository.save(newUser);
    }

    private User updateUser(StudentRequest studentRequest, Student student) {
        User user = student.getUser();
        user.setEmail(studentRequest.getEmail());
        user.setPassword(passwordEncoder.encode(studentRequest.getPassword()));
        return user;
    }
}
