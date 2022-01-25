package kg.peaksoftlms.peaksoftlms.controller.rest;

import com.wordnik.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.service.TeacherService;
import kg.peaksoftlms.peaksoftlms.service.UserService;
import kg.peaksoftlms.peaksoftlms.service.impl.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
@RequestMapping("/teachers")
@AllArgsConstructor
@CrossOrigin
@Api("Rest controller for teachers")
public class TeacherRestController {
    private final UserService userService;
    private final TeacherService teacherService;

        @GetMapping("getAll")
        @Operation(summary = "Все учители", description = "Позволяет получить всех учителей из базы данных")
        public ResponseEntity<List<Teacher>> getAllTeachers() {
            try {
                return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("getById/{id}")
        @Operation(summary = "teacher(id)", description = "Позволяет получить учителя по 'id'")
        public ResponseEntity<Teacher> getById(@PathVariable Long id) {
            try {
                return new ResponseEntity<>(teacherService.findById(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/getByUsername/{name}")
        @Operation(summary = "teacher(name)", description = "Позволяет получить учителя по имени")
        public ResponseEntity<Teacher> getByUsername(@PathVariable String name) {
            try {
                return new ResponseEntity<>(teacherService.getByName(name), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
//
//        @GetMapping("/getByEmail/{email}")
//        @Operation(summary = "teacher(email)", description = "Позволяет получить учителя по электронному адресу")
//        public ResponseEntity<Optional<Teacher>> getByEmail(@PathVariable String email) {
//            try {
//                return new ResponseEntity<>(teacherService.getByEmail(email), HttpStatus.OK);
//            } catch (Exception e) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//        }

        @PostMapping("addTeacher")
        @Operation(summary = "Добавление учителя", description = "Позволяет добавить нового учителя")
        public ResponseEntity<?> saveTeacher(@RequestBody Teacher teacher) {
            try {
                teacherService.create(teacher);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @DeleteMapping("deleteBy/{id}")
        @Operation(summary = "Удаление учителя", description = "Позволяет удалить учителя")
        public ResponseEntity<?> deleteById(@PathVariable Long id) {
            try {
                teacherService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/getTeacher")
        @Operation(summary = "Получения учителя", description = "Позволяет получить учителя")
        public ResponseEntity<Teacher> getTeacher(@AuthenticationPrincipal UserDetailsImpl userDetails) {
            try {
                return new ResponseEntity<>(teacherService.findById(userDetails.getId()), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @PutMapping("updateTeacher")
        @Operation(summary = "Обновление учителя", description = "Позволяет обновить учителя")
        public ResponseEntity<?> editTeacherPage(@RequestBody Teacher teacher) {
            try {
                teacherService.update(teacher);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

}