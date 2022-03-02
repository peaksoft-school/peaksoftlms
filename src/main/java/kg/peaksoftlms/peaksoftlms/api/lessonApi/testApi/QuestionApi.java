package kg.peaksoftlms.peaksoftlms.api.lessonApi.testApi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoftlms.peaksoftlms.db.dto.lesson.test.OptionRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.lesson.test.QuestionRequest;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Option;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Question;
import kg.peaksoftlms.peaksoftlms.service.lesson.test.OptionService;
import kg.peaksoftlms.peaksoftlms.service.lesson.test.QuestionService;
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
@Tag(name = "Контроллер для управления вопросами",
        description = "Позволяет получить, удалить, добaвить или обновить все вопросы")
public class QuestionApi {
    private final QuestionService questionService;
    private final OptionService optionService;

    @PostMapping("/{testId}/questions")
    @Operation(summary = "Добавление нового вопроса", description = "Позволяет добавить новый вопрос к тесту")
    public ResponseEntity<Question> saveQuestion(@PathVariable Long testId,
                                                 @RequestBody QuestionRequest questionRequest) {
        return new ResponseEntity<>(questionService.saveQuestion(testId, questionRequest), OK);
    }


    @GetMapping("/{testId}/questions")
    @Operation(summary = "Для получения всех вопросов",
            description = "Позволяет получить все вопросы по TEST ID")
    public ResponseEntity<List<Question>> getAllQuestions(@PathVariable("testId") Long testId) {
        return new ResponseEntity<>(questionService.getAllByTestId(testId), HttpStatus.OK);
    }

    @GetMapping("/questions/{id}")
    @Operation(summary = "Для получения вопроса по ID", description = "Позволяет получить вопрос по ID")
    public ResponseEntity<Question> getTest(@PathVariable("id") Long id) {
        return new ResponseEntity<>(questionService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{testId}/questions/{id}")
    @Operation(summary = "Для обновления вопроса",
            description = "Позволяет обновить вопрос по ID и TEST ID")
    public ResponseEntity<Question> updateQuestion(@PathVariable("testId") Long testId,
                                                   @PathVariable("id") Long id,
                                                   @RequestBody QuestionRequest questionRequest) {
        return new ResponseEntity<>(questionService.update(id, questionRequest, testId), HttpStatus.OK);
    }

    @DeleteMapping("/questions/{id}")
    @Operation(summary = "Для удаления вопроса", description = "Позволяет удалить вопрос по ID")
    public ResponseEntity<Question> delete(@PathVariable("id") Long id) {
        questionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/{questionId}/options")
//    @Operation(summary = "Добавление нового варианта", description = "Позволяет добавить новый вариант к воапросу")
//    public ResponseEntity<Option> saveOption(@PathVariable Long questionId,
//                                             @RequestBody OptionRequest optionRequest) {
//        return new ResponseEntity<>(optionService.saveOption(questionId, optionRequest), OK);
//    }
}
