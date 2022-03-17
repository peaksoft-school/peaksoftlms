package kg.peaksoftlms.peaksoftlms.mapper;

import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TeacherMapper {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public TeacherResponse teacherToTeacherResponse(Teacher teacher) {
        return modelMapper.map(teacher, TeacherResponse.class);
    }

    public Teacher teacherRequestToTeacher(TeacherRequest teacherRequest, Teacher teacher) {
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.getUser().setEmail(teacherRequest.getEmail());
        teacher.getUser().setPassword(passwordEncoder.encode(teacherRequest.getPassword()));
        teacher.setPhoneNumber(teacherRequest.getPhoneNumber());
        teacher.setImg(teacherRequest.getImg());
        teacher.setSpecialization(teacherRequest.getSpecialization());
        return teacher;
    }

    public Teacher teacherUpdate(TeacherRequest teacherRequest, Teacher teacher) {
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.getUser().setEmail(teacherRequest.getEmail());
        teacher.setPhoneNumber(teacherRequest.getPhoneNumber());
        teacher.setImg(teacherRequest.getImg());
        teacher.setSpecialization(teacherRequest.getSpecialization());
        return teacher;
    }

    public List<TeacherResponse> teacherListTeacherResponseList(List<Teacher> teacherList) {
        return teacherList.stream().map(this::teacherToTeacherResponse).collect(Collectors.toList());
    }
}
