package kg.peaksoftlms.peaksoftlms.testPackage.service.lesson.test;

import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.test.AnswerRequest;
import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.test.TestResultResponse;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test.Answer;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test.Option;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test.TestResult;
import kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.TestRepository;
import kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.test.QuestionRepository;
import kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.test.test.AnswerRepository;
import kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.test.test.TestResultRepository;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.db.repository.StudentRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.*;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final TestResultRepository testResultRepository;
    private final StudentRepository studentRepository;
    private final TestRepository testRepository;

    private static final DecimalFormat df = new DecimalFormat("#.#");

    Answer answerRequestToAnswer(AnswerRequest answerRequest) {
        Answer answer = new Answer();
        answer.setEQuestionType(answerRequest.getEQuestionType());
        answer.setAnswers(answerRequest.getCorrectAnswerList());
        return answer;
    }

    TestResultResponse testToTestResultResponse(TestResult testResult) {
        TestResultResponse testResultResponse = new TestResultResponse();
        testResultResponse.setId(testResultResponse.getId());
        testResultResponse.setCorrectAnswers(testResult.getCorrectAnswers());
        testResultResponse.setIncorrectAnswers(testResult.getIncorrectAnswers());
        testResultResponse.setResultInPercent(testResult.getResultInPercent());

        testResultResponse.setStudent(testResult.getStudent());

        return testResultResponse;
    }
    @Override
    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public TestResultResponse saveAnswers(List<AnswerRequest> answerRequestList, User user, Long id) {

        /* Logic has to be completed */

        List<Answer> answerList = new ArrayList<>();
        TestResult testResult = new TestResult();

        log.error("{}",studentRepository.findById(user.getId()).orElseThrow(() -> new NullPointerException("Student with id: " + user.getId() + " is not found")));
        testResult.setTest(testRepository.findById(id).orElseThrow(() -> new NullPointerException("Test with id: " + id + " is not found")));
        testResult.setStudent(studentRepository.findById(user.getId()).orElseThrow(() -> new NullPointerException("Student with id: " + user.getId() + " is not found")));

        int questionQuantity = testRepository.findById(id).get().getQuestionList().size();
        double usersCorrectAnswer = 0;

        for (AnswerRequest answer : answerRequestList) {
            Answer answer1 = answerRequestToAnswer(answer);
            answer1.setQuestion(questionRepository.findById(answer.getQuestionId()).get());
            testResult.setAnswerList(answer1);
            usersCorrectAnswer = usersCorrectAnswer + resultPoints(answer.getCorrectAnswerList(), answer1.getQuestion().getOptionList());
            answerList.add(answer1);
        }
        testResult.setCorrectAnswers(usersCorrectAnswer);
        testResult.setIncorrectAnswers(Double.parseDouble(df.format(questionQuantity - usersCorrectAnswer)));
        testResult.setResultInPercent(toStringInPercent((int) (usersCorrectAnswer * 100) / questionQuantity));

        testResultRepository.save(testResult);
        return testToTestResultResponse(testResult);
    }

    @Override
    public Answer findAnswerById(Long id) {
        return answerRepository.findById(id).orElseThrow(() -> new NullPointerException("User with id: " + id + " is not found"));
    }

    private String toStringInPercent(int number) {
        return number + "%";
    }

    public static double resultPoints(List<String> userCorrectAnswerList, List<Option> optionList) {

        /*
         * Here logic has to be completed!
         * 1 - if user didn't choose enough options then subtract 0.5
         * 2 - if user did choose more than enough options then subtract 1
         * 3 - logic has to be continued
         * */

        double correctAnswers = 0d;
        double userCorrectAnswers = 0d;

        int userAnswers = userCorrectAnswerList.size();

        for (Option option : optionList) {
            if (option.getIsCorrect()) {
                correctAnswers++;
                if (userCorrectAnswerList.contains(option.getOptionContent())){
                    userCorrectAnswers++;
                }
            }
        }
        if (userCorrectAnswers == 0) {
            return 0;
        }


        double percentage = (userCorrectAnswers * 100) / correctAnswers;

        return Double.parseDouble(df.format(percentage / (double) 100));
    }
}