package kg.peaksoftlms.peaksoftlms.mapper;

import kg.peaksoftlms.peaksoftlms.db.dto.CourseRequestDTO;
import kg.peaksoftlms.peaksoftlms.db.dto.CourseResponseDTO;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequestDTO;
import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@Mapper(componentModel = "spring")
public class CourseMapper {
    private final TeacherRepository teacherRepository;

    @Mappings({@Mapping(target = "Courseid", source = "id")})
    public Course courseFromCourseResponseDTO(CourseResponseDTO courseResponseDTO) {
        if (courseResponseDTO == null) {
            return null;
        }
        Course course = new Course();
        //course.setId(courseDTO.getId());
        course.setName(courseResponseDTO.getName());
        course.setDescription(courseResponseDTO.getDescription());
        course.setImg(courseResponseDTO.getImg());
        course.setDateOfCreate(courseResponseDTO.getDateOfCreate());
        List<Teacher> teacherList = new ArrayList<>();
        for (TeacherRequestDTO t : courseResponseDTO.getTeacher()) {
            teacherList.add(teacherRepository.getById(t.getId()));
        }
        course.setTeacher(teacherList);
        return course;
    }

    @Mappings({@Mapping(target = "Courseid", source = "id")})
    public Course courseToNewCourse(Course course) {
        if (course == null) {
            return null;
        }
        Course newCourse= new Course();
        newCourse.setId(course.getId());
        newCourse.setName(course.getName());
        newCourse.setDescription(course.getDescription());
        newCourse.setImg(course.getImg());
        newCourse.setDateOfCreate(course.getDateOfCreate());
        List<Teacher> teacherList = new ArrayList<>();
        for (Teacher t : course.getTeacher()) {
            teacherList.add(teacherRepository.getById(t.getId()));
        }
        newCourse.setTeacher(teacherList);
        return newCourse;
    }
}
