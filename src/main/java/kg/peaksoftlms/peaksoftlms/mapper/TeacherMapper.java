package kg.peaksoftlms.peaksoftlms.mapper;


import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class TeacherMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public Teacher teacherRequestToTeacher(TeacherRequest teacherRequest) {
        if (teacherRequest == null) {
            return null;
        }
        log.info("mapper teacher request is working  {}", teacherRequest);
        return modelMapper.map(teacherRequest, Teacher.class);
    }


    public TeacherResponse teacherToTeacherResponse(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        log.info("mapper teacher Response is working  {}", teacher);

        return modelMapper.map(teacher, TeacherResponse.class);
    }

    public List<TeacherResponse> teacherListToTeacherResponseList(List<Teacher> teacherList) {
        if (teacherList == null) {
            return null;
        }
        List<TeacherResponse> teacherResponseList = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            teacherResponseList.add(teacherToTeacherResponse(teacher));
        }
        log.info("mapper teacherList to teacherResponseList is working  {}", teacherList);
        return teacherResponseList;
    }

    public List<TeacherResponse> teacherToTeacherResponseList(List<Teacher> teacherList) {
        if (teacherList == null) {
            return null;
        }
        List<TeacherResponse> teacherResponseList = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            teacherResponseList.add(teacherToTeacherResponse(teacher));
        }
        log.info("mapper teacher to teacherResponseList is working  {}", teacherList);
        return teacherResponseList;
    }

    public void update(Teacher teacher, TeacherRequest teacherRequest) {
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setPassword(teacherRequest.getPassword());
        teacher.setImage(teacherRequest.getImg());
    }
}