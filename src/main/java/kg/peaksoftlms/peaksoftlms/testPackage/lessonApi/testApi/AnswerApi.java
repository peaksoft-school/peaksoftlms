package kg.peaksoftlms.peaksoftlms.testPackage.lessonApi.testApi;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.test.AnswerRequest;
import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.test.TestResultResponse;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test.Answer;
import kg.peaksoftlms.peaksoftlms.testPackage.service.lesson.test.AnswerService;
import kg.peaksoftlms.peaksoftlms.db.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/test/answer")
@AllArgsConstructor
@Tag(name = "Контроллер для управления ответами",
        description = "Позволяет получить, удалить, добaвить или обновить все ответы")
public class AnswerApi {

    private final AnswerService answerService;
    private final UserRepository userRepository;

    @PostMapping("/save/{id}")
    public ResponseEntity<TestResultResponse> saveUserAnswers(@RequestBody List<AnswerRequest> answerRequestList, @PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(answerService.saveAnswers(answerRequestList, userRepository.findByEmail(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()).get(), id), OK);
        }catch (Exception e) {
            return new ResponseEntity<>(BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Answer> findAnswerById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(answerService.findAnswerById(id), OK);
        }catch (Exception e) {
            return new ResponseEntity<>(BAD_REQUEST);
        }
    }

}
