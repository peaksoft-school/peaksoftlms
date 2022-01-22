package kg.peaksoftlms.peaksoftlms.api;

import kg.peaksoftlms.peaksoftlms.db.dto.CourseDTO;
import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.mapper.CourseMapper;
import kg.peaksoftlms.peaksoftlms.service.courseService.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/admin/course")
@AllArgsConstructor
@Slf4j
public class CourseApi {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @PostMapping(value = "")
    public ResponseEntity<Course> addNewCourse(@Valid @RequestBody CourseDTO courseDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().
                path("/api/admin/course").toUriString());
        Course registeredNewCourse = courseService
                .saveCourse(courseMapper.courseFromCourseRequestDTO(courseDTO));
        log.info("Save course: {}", registeredNewCourse);
        return ResponseEntity.created(uri).body(registeredNewCourse);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courseList = courseService.getAllCourses();
        log.info("All courses: {}", courseList);
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().
                path("/api/admin/course/{id}").toUriString());
        Course course = courseService.getCourseById(id);
        log.info("Get course by id: {}", course);
        return ResponseEntity.created(uri).body(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long id) {
        courseService.updateCourse(id, course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
