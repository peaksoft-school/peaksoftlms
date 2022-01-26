//package kg.peaksoftlms.peaksoftlms.mapper;
//
//import kg.peaksoftlms.peaksoftlms.db.dto.CourseRequest;
//import kg.peaksoftlms.peaksoftlms.db.dto.CourseResponse;
//import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequest;
//import kg.peaksoftlms.peaksoftlms.db.model.Course;
//import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
//import kg.peaksoftlms.peaksoftlms.db.repository.TeacherRepository;
//import lombok.AllArgsConstructor;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@AllArgsConstructor
//@Mapper(componentModel = "spring")
//public class CourseRequestMapper {
//    private final TeacherRepository teacherRepository;
//
//    @Mappings({@Mapping(target = "Courseid", source = "id")})
//    public CourseRequest courseRequestFromCourse(Course course) {
//        if (course == null) {
//            return null;
//        }
//        CourseRequest courseRequest = new CourseRequest();
//        //course.setId(courseDTO.getId());
//        courseRequest.setName(course.getName());
//        courseRequest.setDescription(course.getDescription());
//        courseRequest.setImg(course.getImg());
//        courseRequest.setDateOfCreate(course.getDateOfCreate());
//        List<Teacher> teacherList = new ArrayList<>();
//        for (TeacherRequest t : courseRequest.getTeacher()) {
//            teacherList.add(teacherRepository.getById(t.getId()));
//        }
//        course.setTeacher(teacherList);
//        return courseRequest;
//    }
//}
