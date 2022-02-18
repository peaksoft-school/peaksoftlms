package kg.peaksoftlms.peaksoftlms.service.courseService;

import kg.peaksoftlms.peaksoftlms.db.dto.CourseRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.CourseResponse;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherIdForCourseRequest;

import java.util.List;

public interface CourseService {

    List<CourseResponse> getAllCourses();

    CourseResponse getCourseById(Long id);

    CourseResponse getCourseByName(String name);

    CourseResponse saveCourse(CourseRequest courseRequest);

    CourseResponse updateCourse(Long id, CourseRequest courseRequest);

    void deleteCourse(Long id);

    CourseResponse addTeacherToCourse(Long courseId, TeacherIdForCourseRequest teacherIdList);
}
