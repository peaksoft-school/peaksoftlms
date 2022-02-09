package kg.peaksoftlms.peaksoftlms.service.courseService;

import kg.peaksoftlms.peaksoftlms.db.dto.CourseRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.CourseResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.db.repository.CourseRepository;
import kg.peaksoftlms.peaksoftlms.mapper.CourseMapper;
import kg.peaksoftlms.peaksoftlms.mapper.CourseUpdateMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseUpdateMapper courseUpdateMapper;
    private final CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        log.info("Get course by id: {}", id);
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course getCourseByName(String name) {
        log.info("get course by name: {}", name);
        if (name == null) {
            return null;
        }
        return courseRepository.findByName(name).orElse(null);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRepository.getById(id);
        courseUpdateMapper.update(course, courseRequest);
        CourseResponse courseResponse =
                courseMapper.courseToCourseResponse(courseRepository.save(course));
        log.info("updated course: {}", course.getName());


//        if (courseRepository.existsById(id)) {
//            log.info("course from db: {}", course.getName());
//            try {
//                courseRepository.save(courseUpdateMapper.courseToNewCourse(course));
//                log.info("updated course: {}", course.getName());
//            } catch (Exception ex) {
//                log.error("Exception {}", ex.getMessage());
//            }
//        }
        return courseResponse;
    }

    @Override
    public void deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            log.info("Delete course by id: {}", id);
        }
        log.info(" Do not exist course by id: {}", id);
    }
}
