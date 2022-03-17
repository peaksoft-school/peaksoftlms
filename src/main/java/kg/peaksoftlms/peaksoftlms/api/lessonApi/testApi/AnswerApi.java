//package kg.peaksoftlms.peaksoftlms.api.lessonApi.testApi;
//
//import io.swagger.v3.oas.annotations.tags.Tag;
//import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.Answer;
//import kg.peaksoftlms.peaksoftlms.db.model.User;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.*;
//
//import static org.springframework.http.HttpStatus.OK;
//
//@CrossOrigin("/**")
//@RestController
//@AllArgsConstructor
//@RequestMapping("/api/instructor/lessons/tests/answers")
//@Tag(name = "Контроллер для управления ответами",
//        description = "Позволяет получить, удалить, добавить или обновить все ответы")
//public class AnswerApi {
////    private final AnswerServiceImpl answerService;
//
//    @PostMapping("/{testId}/answers")
//    public ResponseEntity<Answer> saveAnswer(@AuthenticationPrincipal User user,
//                                             @PathVariable Long testId,
//                                             @RequestParam Long optionId,
//                                             @RequestParam Long questionId) {
//      //  answerService.saveUserAnswer(user.getId(), testId, questionId, optionId);
//        return new ResponseEntity<>(OK);
//    }
//}
