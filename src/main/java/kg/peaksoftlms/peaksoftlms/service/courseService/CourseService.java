package kg.peaksoftlms.peaksoftlms.service.courseService;

import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Optional<Course> getCourseByName(String name);

    Course saveCourse(Course course);

    void updateCourse(Long id, Course course);

    void assignTeacherToTheCourse(Course course, Long idTeacher);

    void deleteCourse(Long id);
}
