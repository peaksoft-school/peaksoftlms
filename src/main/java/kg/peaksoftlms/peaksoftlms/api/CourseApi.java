package kg.peaksoftlms.peaksoftlms.api;

import kg.peaksoftlms.peaksoftlms.db.dto.CourseRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.CourseResponse;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequest;
import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.repository.TeacherRepository;
import kg.peaksoftlms.peaksoftlms.mapper.MapStructMapperForCourse;
import kg.peaksoftlms.peaksoftlms.service.courseService.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/courses")
@AllArgsConstructor
@Slf4j
public class CourseApi {

    private final CourseService courseService;
    private final TeacherRepository teacherRepository;
    private final MapStructMapperForCourse mapStructMapperForCourse;

    @PostMapping("")
    public ResponseEntity<Course> addNewCourse(@Valid @RequestBody CourseResponse courseResponse) {
        Course registeredNewCourse = courseService
                .saveCourse(mapStructMapperForCourse.courseResponseToCourse(courseResponse));
        log.info("Save api course: {}", registeredNewCourse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
//    @PostMapping(value = "")
//    public ResponseEntity<Course> addNewCourse(@Valid @RequestBody CourseResponse courseDTO) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().
//                path("/api/admin/courses").toUriString());
//        Course registeredNewCourse = courseService
//                .saveCourse(mapStructMapperForCourse.courseResponseToCourse(courseDTO));
//        log.info("Save course: {}", registeredNewCourse);
//        return ResponseEntity.created(uri).body(registeredNewCourse);
//    }


    @GetMapping("")
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        List<Course> courseList = courseService.getAllCourses();
        List<CourseResponse> courseResponseList = mapStructMapperForCourse
                .courseListToCourseResponseList(courseList);
        log.info("All courses: {}", courseResponseList);
        return new ResponseEntity<>(courseResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseRequest> getCourseById(@PathVariable Long id) {
        return new ResponseEntity<>(mapStructMapperForCourse.courseToCourseRequest(
                courseService.getCourseById(id)), HttpStatus.OK);
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
