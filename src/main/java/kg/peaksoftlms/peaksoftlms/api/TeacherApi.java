package kg.peaksoftlms.peaksoftlms.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherResponse;
import kg.peaksoftlms.peaksoftlms.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/teachers")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Контроллер для управления учителей", description = "Позволяет найти, удалить, добaвить или редактировать всех учителей")
public class TeacherApi {
    private final TeacherService teacherService;

    @GetMapping("")
    @Operation(summary = "Все учителя", description = "Позволяет найти всех учителей из базы данных")
    public ResponseEntity<List<TeacherResponse>> getAllTeachers() {
        List<TeacherResponse> teacherResponseList = teacherService.getAllTeachers();
        log.info("All teachers: {}", teacherResponseList);
        return new ResponseEntity<>(teacherResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "teacher(id)", description = "Позволяет найти учителя по 'id'")
    public ResponseEntity<TeacherResponse> getTeacherById(@PathVariable Long id) {
        return new ResponseEntity<>(teacherService.getTeacherById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "teacher(name)", description = "Позволяет найти учителя по имени")
    public ResponseEntity<TeacherResponse> getByName(@PathVariable("name") String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacherService.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "teacher(email)", description = "Позволяет получить учителя по электронному адресу")
    public ResponseEntity<TeacherResponse> getByEmail(@PathVariable("email") String email) {
        TeacherResponse teacher = teacherService.getByEmail(email);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PostMapping("")
    @Operation(summary = "Добавление учителя", description = "Позволяет добавить нового учителя")
    public ResponseEntity<TeacherResponse> saveTeacher(@RequestBody TeacherRequest teacherRequest) {
//        try {

            teacherService.create(teacherRequest);
            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление учителя", description = "Позволяет удалить учителя")
    public ResponseEntity<TeacherResponse> deleteById(@PathVariable Long id) {
        try {
            teacherService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Редактированя учителя", description = "Позволяет редактировать учителя")
    public ResponseEntity<TeacherResponse> editTeacherPage(@RequestBody TeacherRequest teacherRequest,
                                                           @PathVariable Long id) {
        try {
            teacherService.updateById(teacherRequest, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}