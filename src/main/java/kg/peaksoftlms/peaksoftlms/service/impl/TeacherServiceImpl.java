package kg.peaksoftlms.peaksoftlms.service.impl;

import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.repository.TeacherRepository;
import kg.peaksoftlms.peaksoftlms.mapper.TeacherMapper;
import kg.peaksoftlms.peaksoftlms.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public List<TeacherResponse> getAllTeachers() {
        return teacherMapper.teacherListToTeacherResponseList(teacherRepository.findAll());
    }

    @Override
    public TeacherResponse getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        return teacherMapper.teacherToTeacherResponse(teacher);
    }

    @Override
    public TeacherResponse create(TeacherRequest teacherRequest) {
        Teacher teacher = teacherMapper.teacherRequestToTeacher(teacherRequest);
        return teacherMapper.teacherToTeacherResponse(teacherRepository.save(teacher));
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<TeacherResponse> findAllByNameContaining(String name) {
        if (name == null) {
            return null;
        }
        List<Teacher> teacherList = teacherRepository.findTeacherByNameContaining(name);
        return teacherMapper.teacherToTeacherResponseList(teacherList);
    }

    @Override
    public TeacherResponse getByName(String name) {
        if (name == null) {
            return null;
        }
        return teacherMapper.teacherToTeacherResponse(teacherRepository.getByName(name));
    }

    @Override
    public TeacherResponse getByEmail(String email) {
        Teacher teacher = teacherRepository.findByEmail(email).orElse(null);
        return teacherMapper.teacherToTeacherResponse(teacher);
    }

    @Override
    public TeacherResponse updateById(TeacherRequest teacherRequest, Long id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        teacherMapper.update(teacher, teacherRequest);
        return teacherMapper.teacherToTeacherResponse(teacher);
    }
}
