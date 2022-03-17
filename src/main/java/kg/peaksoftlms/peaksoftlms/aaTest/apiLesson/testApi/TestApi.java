package kg.peaksoftlms.peaksoftlms.aaTest.apiLesson.testApi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.TaskResponse;
import kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.test.TestRequest;
import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.Test;
import kg.peaksoftlms.peaksoftlms.aaTest.service.lesson.test.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/instructor/lessons")
@Tag(name = "Контроллер для управления тестами",
        description = "Позволяет получить, удалить, добaвить или обновить все тесты")
public class TestApi {

    private final TestService testService;

    @GetMapping("/{lessonId}/tests")
    @Operation(summary = "Для получения всех тестов",
            description = "Позволяет получить все тесты по LESSON ID")
    public ResponseEntity<List<Test>> getAllTasksByLessonId(@PathVariable("lessonId") Long lessonId) {
        return new ResponseEntity<>(testService.getAllByLessonId(lessonId), HttpStatus.OK);
    }

    @GetMapping("/tests/{id}")
    @Operation(summary = "Для получения теста по ID", description = "Позволяет получить тест по ID")
    public ResponseEntity<Test> getTest(@PathVariable("id") Long id) {
        return new ResponseEntity<>(testService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/{lessonId}/tests")
    @Operation(summary = "Для создания нового теста", description = "Позволяет создать новый тест")
    public ResponseEntity<Test> saveTest(@PathVariable Long lessonId,
                                         @RequestBody TestRequest testRequest) {
        return new ResponseEntity<>(testService.saveTest(testRequest, lessonId), OK);
    }

    @PutMapping("/{lessonId}/tests/{id}")
    @Operation(summary = "Для обновления теста",
            description = "Позволяет обновить тест по ID и LESSON ID")
    public ResponseEntity<Test> updateTest(@PathVariable("lessonId") Long lessonId,
                                           @PathVariable("id") Long id,
                                           @RequestBody TestRequest testRequest) {
        return new ResponseEntity<>(testService.updateTest(id, testRequest, lessonId), HttpStatus.OK);
    }

    @DeleteMapping("/tests/{id}")
    @Operation(summary = "Для удаления теста", description = "Позволяет удалить тест по ID")
    public ResponseEntity<TaskResponse> deleteTask(@PathVariable("id") Long id) {
        testService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
