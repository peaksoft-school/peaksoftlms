package kg.peaksoftlms.peaksoftlms.mapper;

import kg.peaksoftlms.peaksoftlms.db.dto.CourseRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.CourseResponse;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequest;
import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapperForCourse {

    Course courseRequestToCourse(CourseRequest courseRequest);

    CourseRequest courseToCourseRequest(Course course);

    Course courseResponseToCourse(CourseResponse courseResponse);

    CourseResponse courseToCourseResponse(Course course);

    List<CourseResponse> courseListToCourseResponseList(List<Course> courseList);

    TeacherRequest teacherToTeacherRequest(Teacher teacher);

    Teacher teacherRequestToTeacher(TeacherRequest teacherRequest);
}
