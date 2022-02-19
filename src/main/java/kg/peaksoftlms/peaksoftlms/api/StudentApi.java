package kg.peaksoftlms.peaksoftlms.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoftlms.peaksoftlms.db.dto.StudentRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.StudentResponse;
import kg.peaksoftlms.peaksoftlms.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/students")
@CrossOrigin
@Tag(name = "Контроллер для управления студентами", description = "Позволяет получить, удалить, добaвить или обновить всех студентов")
@AllArgsConstructor
public class StudentApi {

    private final StudentService studentService;

    @GetMapping("")
    @Operation(summary = "Для получения всех студентов", description = "Позволяет получить всех студентов из базы данных")
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Для получения студента по ID", description = "Позволяет получить студента по ID")
    public ResponseEntity<StudentResponse> getById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    @Operation(summary = "Добавление нового студента", description = "Позволяет добавить нового студента")
    public ResponseEntity<StudentResponse> saveUser(@Valid @RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.saveNew(studentRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Для удаление студента", description = "Позволяет удалить студента по ID")
    public ResponseEntity<ResponseEntity> deleteById(@PathVariable Long id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Для обновление студента", description = "Позволяет обновить студента")
    public ResponseEntity<StudentResponse> editStudent(@PathVariable Long id,
                                                       @RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.update(id, studentRequest), HttpStatus.OK);
    }

//    @GetMapping("/me")
//    @Operation(summary = "Получения студента", description = "Позволяет получить студента")
//    public ResponseEntity<StudentResponse> getCurrentStudent(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        try {
//            return new ResponseEntity<>(studentService.findById(userDetails.getId()), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}


