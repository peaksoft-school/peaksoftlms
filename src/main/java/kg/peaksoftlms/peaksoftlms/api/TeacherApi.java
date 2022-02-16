package kg.peaksoftlms.peaksoftlms.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.service.TeacherService;
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
@RequestMapping("/api/teachers")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Контроллер для управления учителей", description = "Позволяет получить, удалить, добaвить или обновить всех учителей")
public class TeacherApi {
    private final TeacherService teacherService;

        @GetMapping()
        @Operation(summary = "Все учителя", description = "Позволяет получить всех учителей из базы данных")
        public ResponseEntity<List<Teacher>> getAllTeachers() {
            try {
                return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/{id}")
        @Operation(summary = "teacher(id)", description = "Позволяет получить учителя по 'id'")
        public ResponseEntity<Teacher> getById(@PathVariable Long id) {
            try {
                return new ResponseEntity<>(teacherService.findById(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }


        @PostMapping("")
        @Operation(summary = "Добавление учителя", description = "Позволяет добавить нового учителя")
        public ResponseEntity<?> saveTeacher(@RequestBody Teacher teacher) {
            try {
//                teacherService.create(teacher);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @DeleteMapping("/{id}")
        @Operation(summary = "Удаление учителя", description = "Позволяет удалить учителя")
        public ResponseEntity<?> deleteById(@PathVariable Long id) {
            try {
                teacherService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/me")
        @Operation(summary = "Получения учителя", description = "Позволяет получить учителя")
        public ResponseEntity<Teacher> getTeacher(@AuthenticationPrincipal UserDetailsImpl userDetails) {
            try {
                return new ResponseEntity<>(teacherService.findById(userDetails.getId()), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @PutMapping("")
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