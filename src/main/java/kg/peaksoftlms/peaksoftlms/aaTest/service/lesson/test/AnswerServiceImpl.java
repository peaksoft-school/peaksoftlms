package kg.peaksoftlms.peaksoftlms.aaTest.service.lesson.test;

import kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.test.AnswerRequest;
import kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.test.TestResultResponse;
import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.Answer;
import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.Option;
import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.TestResult;
import kg.peaksoftlms.peaksoftlms.aaTest.repository.lesson.TestRepository;
import kg.peaksoftlms.peaksoftlms.aaTest.repository.lesson.test.QuestionRepository;
import kg.peaksoftlms.peaksoftlms.aaTest.repository.lesson.test.test.AnswerRepository;
import kg.peaksoftlms.peaksoftlms.aaTest.repository.lesson.test.test.TestResultRepository;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.db.repository.StudentRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final TestResultRepository testResultRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
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
        List<Answer> answerList = new ArrayList<>();
        TestResult testResult = new TestResult();

        testResult.setStudent(studentRepository.findById(user.getId()).orElseThrow(() -> new NullPointerException("Student with id: " + user.getId() + " is not found")));
        testResult.setTest(testRepository.findById(id).orElseThrow(() -> new NullPointerException("Test with id: " + id + " is not found")));

//        double u = questionRepository.getById(id).getOptionList().stream().filter(o -> o.getIsCorrect().equals(true)).count();
        int questionQuantity = testRepository.findById(id).get().getQuestionList().size();
        double usersCorrectAnswer = 0;

        for (AnswerRequest answer : answerRequestList) {
            Answer answer1 = answerRequestToAnswer(answer);
            answer1.setQuestion(questionRepository.findById(answer.getQuestionId()).get());
            testResult.setAnswerList(answer1);
            double checkpoint3 = resultPoints(answer.getCorrectAnswerList(), answer1.getQuestion().getOptionList());
            usersCorrectAnswer = usersCorrectAnswer + resultPoints(answer.getCorrectAnswerList(), answer1.getQuestion().getOptionList());
            answerList.add(answer1);
        }

//        int userCorrectAnswerInInteger = (int) usersCorrectAnswer;
//        int number = (int) Math.round(usersCorrectAnswer);
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
        double a = userAnswers - userCorrectAnswers;

        int checkpoint1 = (int) correctAnswers;
        int checkpoint2 = (int) userCorrectAnswers;

        double percentage = (userCorrectAnswers * 100) / correctAnswers;

        double finalRequest = Double.parseDouble(df.format(percentage / (double) 100));

        return finalRequest;
    }
}