package kg.peaksoftlms.peaksoftlms.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoftlms.peaksoftlms.db.dto.StudentRequest;
import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.service.StudentService;
import kg.peaksoftlms.peaksoftlms.service.impl.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
@Tag(name = "Контроллер для управления студентами", description = "Позволяет получить, удалить, добaвить или обновить всех студентов")
@RequiredArgsConstructor
public class StudentApi {

        private final StudentService studentService;

        @GetMapping("")
        @Operation(summary = "Все студенты", description = "Позволяет получить всех студентов из базы данных")
        public ResponseEntity<List<Student>> getAllStudents() {
            try {
                return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/{id}")
        @Operation(summary = "Студент(id)", description = "Позволяет получить студента по 'id'")
        public ResponseEntity<Student> getById(@PathVariable Long id) {
            try {
                return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }



        @PostMapping("")
        @Operation(summary = "Добавление ", description = "Позволяет добавить нового студента")
        public ResponseEntity<?> saveUser(@RequestBody StudentRequest student) {
            try {
                studentService.addStudent(student);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @DeleteMapping("/{id}")
        @Operation(summary = "Удаление студента", description = "Позволяет удалить студента")
        public ResponseEntity<?> deleteById(@PathVariable Long id) {
            try {
              studentService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/me")
        @Operation(summary = "Получения студента", description = "Позволяет получить студента")
        public ResponseEntity<Student> getCurrentStudent(@AuthenticationPrincipal UserDetailsImpl userDetails) {
            try {
                return new ResponseEntity<>(studentService.findById(userDetails.getId()), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @PutMapping("")
        @Operation(summary = "Обновление студента", description = "Позволяет обновить студента")
        public ResponseEntity<?> editStudent(@RequestBody Student student) {
            try {
                studentService.update(student);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
}


