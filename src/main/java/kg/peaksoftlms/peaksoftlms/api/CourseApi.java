package kg.peaksoftlms.peaksoftlms.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@CrossOrigin
@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
@Slf4j
@Tag(name = "Контроллер для управления курсами", description = "Позволяет получить, удалить, добaвить или обновить всех курсов")
public class CourseApi {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @PostMapping("")
    @Operation(summary = "Для добавления курсов", description = "Позволяет добавить курс")
    public ResponseEntity<CourseResponse> addNewCourse(@Valid @RequestBody CourseRequest courseRequest) {
        Course registeredNewCourse = courseService
                .saveCourse(courseMapper.courseRequestToCourse(courseRequest));
        log.info("Save api course: {}", registeredNewCourse);
        return new ResponseEntity<>(courseMapper
                .courseToCourseResponse(registeredNewCourse), HttpStatus.CREATED);
    }

    @GetMapping()
    @Operation(summary = "Для получения всех курсов", description = "Позволяет получить все курсы")
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        List<Course> courseList = courseService.getAllCourses();
        List<CourseResponse> courseResponseList = courseMapper
                .courseListToCourseResponseList(courseList);
        log.info("All courses: {}", courseResponseList);
        return new ResponseEntity<>(courseResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Для получения курсов по ID", description = "Позволяет получить курс по ID")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable Long id) {
        return new ResponseEntity<>(courseMapper.courseToCourseResponse(
                courseService.getCourseById(id)), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @Operation(summary = "Для получения курсов по имени", description = "Позволяет получить курс по имени")
    public ResponseEntity<CourseResponse> getCourseByName(@PathVariable String name) {
        Course course = courseService.getCourseByName(name);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courseMapper
                .courseToCourseResponse(course), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Для редактирования курсов", description = "Позволяет редактировать курс")
    public ResponseEntity<CourseResponse> updateCourse(@RequestBody CourseRequest courseRequest,
                                                       @PathVariable Long id) {
        CourseResponse courseResponse = courseService.updateCourse(id, courseRequest);
        return new ResponseEntity<>(courseResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Для удаления курсов", description = "Позволяет удалить курсы")
    public ResponseEntity<CourseResponse> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
