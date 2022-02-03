package kg.peaksoftlms.peaksoftlms.service.courseService;

import kg.peaksoftlms.peaksoftlms.db.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course getCourseByName(String name);

    Course saveCourse(Course course);

    void updateCourse(Long id, Course course);

    void deleteCourse(Long id);
}
