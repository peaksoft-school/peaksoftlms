package kg.peaksoftlms.peaksoftlms.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoftlms.peaksoftlms.db.dto.CourseRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.CourseResponse;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherIdForCourseRequest;
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
@Tag(name = "Контроллер для управления курсами",
        description = "Позволяет получить, удалить, добaвить или обновить всех курсов")
public class CourseApi {

    private final CourseService courseService;

    @PostMapping("")
    @Operation(summary = "Для добавления курсов", description = "Позволяет добавить новый курс")
    public ResponseEntity<CourseResponse> addNewCourse(@Valid @RequestBody CourseRequest courseRequest) {
        log.info("Save api course: {}", courseRequest);
        return new ResponseEntity<>(courseService.saveCourse(courseRequest), HttpStatus.CREATED);
    }

    @GetMapping("")
    @Operation(summary = "Для получения всех курсов", description = "Позволяет получить все курсы")
    public ResponseEntity<List<CourseResponse>> getAllCourses() {

        log.info("All courses: {}", courseService.getAllCourses());
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Для получения курсов по ID", description = "Позволяет получить курс по ID")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable Long id) {
        return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Для получения курсов по имени", description = "Позволяет получить курс по имени")
    public ResponseEntity<CourseResponse> getCourseByName(@PathVariable String name) {
        return new ResponseEntity<>(courseService.getCourseByName(name), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Для редактирования курсов", description = "Позволяет редактировать курс по ID")
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

    @PostMapping("/{courseId}/teachers")
    @Operation(summary = "Для добавления учителей в курс",
            description = "Позволяет добавить учителей в курс с помощью ID учителей")
    public ResponseEntity<CourseResponse> addTeacherForCourse(@PathVariable("courseId") Long courseId,
                                                              @RequestBody TeacherIdForCourseRequest request) {
        return new ResponseEntity<>(courseService.addTeacherToCourse(courseId, request), HttpStatus.OK);
    }
}
