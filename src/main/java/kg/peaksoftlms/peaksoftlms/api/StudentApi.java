package kg.peaksoftlms.peaksoftlms.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.service.StudentService;
import kg.peaksoftlms.peaksoftlms.service.UserService;
import kg.peaksoftlms.peaksoftlms.service.impl.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
@Tag(name = "Контроллер для управления студентами", description = "Позволяет получить, удалить, добaвить или обновить всех студентов")
@RequiredArgsConstructor
public class StudentApi {

        private final StudentService studentService;
        private  final UserService userService;

        @GetMapping("/getAll")
        @Operation(summary = "Все студенты", description = "Позволяет получить всех студентов из базы данных")
        public ResponseEntity<List<Student>> getAllStudents() {
            try {
                return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/getById/{id}")
        @Operation(summary = "Студент(id)", description = "Позволяет получить студента по 'id'")
        public ResponseEntity<Optional<User>> getById(@PathVariable Long id) {
            try {
                return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/getByUsername/{name}")
        @Operation(summary = "Студент(name)", description = "Позволяет получить студента по имени")
        public ResponseEntity<Student> getByName(@PathVariable String name) {
            try {
                return new ResponseEntity<>(studentService.getByName(name), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

//        @GetMapping("/getByEmail/{email}")
//        @Operation(summary = "Студент(email)", description = "Позволяет получить студента по по электронному адресу")
//        public ResponseEntity<Optional<Student >> getByEmail(@PathVariable String email) {
//            try {
//                return new ResponseEntity<>(studentService.findByEmail(email), HttpStatus.OK);
//            } catch (Exception e) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//        }

        @PostMapping("/addStudent")
        @Operation(summary = "Добавление ", description = "Позволяет добавить нового студента")
        public ResponseEntity<?> saveUser(@RequestBody Student student) {
            try {
                studentService.addStudent(student);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @DeleteMapping("/deleteBy/{id}")
        @Operation(summary = "Удаление студента", description = "Позволяет удалить студента")
        public ResponseEntity<?> deleteById(@PathVariable Long id) {
            try {
              studentService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/getStudent")
        @Operation(summary = "Получения студента", description = "Позволяет получить студента")
        public ResponseEntity<Student> getCurrentStudent(@AuthenticationPrincipal UserDetailsImpl userDetails) {
            try {
                return new ResponseEntity<>(studentService.findById(userDetails.getId()), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @PutMapping("/updateStudent")
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


