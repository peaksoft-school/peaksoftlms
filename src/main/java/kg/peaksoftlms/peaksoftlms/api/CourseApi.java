package kg.peaksoftlms.peaksoftlms.api;

import kg.peaksoftlms.peaksoftlms.db.dto.CourseRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.CourseResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.mapper.CourseMapper;
import kg.peaksoftlms.peaksoftlms.service.courseService.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/courses")
@AllArgsConstructor
@Slf4j
public class CourseApi {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @PostMapping("")
    public ResponseEntity<CourseResponse> addNewCourse(@Valid @RequestBody CourseRequest courseRequest) {
        Course registeredNewCourse = courseService
                .saveCourse(courseMapper.courseRequestToCourse(courseRequest));
        log.info("Save api course: {}", registeredNewCourse);
        return new ResponseEntity<>(courseMapper
                .courseToCourseResponse(registeredNewCourse), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        List<Course> courseList = courseService.getAllCourses();
        List<CourseResponse> courseResponseList = courseMapper
                .courseListToCourseResponseList(courseList);
        log.info("All courses: {}", courseResponseList);
        return new ResponseEntity<>(courseResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable Long id) {
        return new ResponseEntity<>(courseMapper.courseToCourseResponse(
                courseService.getCourseById(id)), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CourseResponse> getCourseByName(@PathVariable String name) {
        Course course = courseService.getCourseByName(name);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courseMapper
                .courseToCourseResponse(course), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long id) {
        courseService.updateCourse(id, course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseResponse> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
