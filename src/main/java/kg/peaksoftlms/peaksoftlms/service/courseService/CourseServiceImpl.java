package kg.peaksoftlms.peaksoftlms.service.courseService;

import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.db.repository.CourseRepository;
import kg.peaksoftlms.peaksoftlms.mapper.CourseMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
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
    public Optional<Course> getCourseByName(String name) {
        log.info("get course by name: {}", name);
        return courseRepository.getCourseByName(name);
    }

    @Override
    public Course saveCourse(Course course) {
        log.info("Save course");
        return courseRepository.save(course);

    }

    @Override
    public void updateCourse(Long id, Course course) {
        if (courseRepository.existsById(id)) {
            log.info("course from db: {}", course.getName());
            try {
                courseRepository.save(courseMapper.courseToNewCourse(course));
                log.info("updated course: {}", course.getName());
            } catch (Exception ex) {
                log.error("Exception {}", ex.getMessage());
            }
        }
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
