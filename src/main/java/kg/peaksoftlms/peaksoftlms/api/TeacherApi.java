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
@Tag(name = "Контроллер для управления учителей", description = "Позволяет получить, удалить, добaвить или обновить всех учителей")
public class TeacherApi {
    private final TeacherService teacherService;

    @GetMapping()
    @Operation(summary = "Все учителя", description = "Позволяет получить всех учителей из базы данных")
    public ResponseEntity<List<TeacherResponse>> getAllTeachers() {
        return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "teacher(id)", description = "Позволяет получить учителя по 'id'")
    public ResponseEntity<TeacherResponse> getById(@PathVariable Long id) {
        return new ResponseEntity<>(teacherService.findById(id), HttpStatus.OK);
    }


    @PostMapping("")
    @Operation(summary = "Добавление учителя", description = "Позволяет добавить нового учителя")
    public ResponseEntity<?> saveTeacher(@RequestBody TeacherRequest teacherRequest) {
        return new ResponseEntity<>(teacherService.save(teacherRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление учителя", description = "Позволяет удалить учителя")
    public ResponseEntity<TeacherResponse> deleteById(@PathVariable Long id) {
        teacherService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//        @GetMapping("/me")
//        @Operation(summary = "Получения учителя", description = "Позволяет получить учителя")
//        public ResponseEntity<TeacherResponse> getTeacher(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//                return new ResponseEntity<>(teacherService.findById(userDetails.getId()), HttpStatus.OK);
//        }

    @PutMapping("/{id}")
    @Operation(summary = "Обновление учителя", description = "Позволяет обновить учителя")
    public ResponseEntity<TeacherResponse> editTeacherPage(@RequestBody TeacherRequest teacherRequest,
                                                           @PathVariable Long id) {
        return new ResponseEntity<>(teacherService.update(teacherRequest, id), HttpStatus.OK);
    }

}