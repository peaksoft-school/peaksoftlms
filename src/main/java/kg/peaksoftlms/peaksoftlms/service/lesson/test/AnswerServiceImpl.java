//package kg.peaksoftlms.peaksoftlms.service.lesson.test;
//
//import kg.peaksoftlms.peaksoftlms.db.model.Student;
//import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Answer;
//import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Option;
//import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Question;
//import kg.peaksoftlms.peaksoftlms.db.repository.StudentRepository;
//import kg.peaksoftlms.peaksoftlms.db.repository.lesson.TestRepository;
//import kg.peaksoftlms.peaksoftlms.db.repository.lesson.test.AnswerRepository;
//import kg.peaksoftlms.peaksoftlms.db.repository.lesson.test.OptionRepository;
//import kg.peaksoftlms.peaksoftlms.db.repository.lesson.test.QuestionRepository;
//import kg.peaksoftlms.peaksoftlms.db.repository.lesson.test.TestingResultRepository;
//import kg.peaksoftlms.peaksoftlms.exeption.ResourceNotFoundException;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import javax.swing.JFrame;
//
//@Service
//@AllArgsConstructor
//@Slf4j
//public class AnswerServiceImpl implements AnswerService {
//    private final StudentRepository studentRepository;
//    private final TestingResultRepository testingResultRepository;
//    private final QuestionRepository questionRepository;
//    private final AnswerRepository answerRepository;
//    private final OptionRepository optionRepository;
//    private final TestRepository testRepository;
//
//    //@Override
//    public List<Answer> findByStudent(Long studentId, Long testId) {
//        Student student = getExistedStudentFromDataBase(studentId);
//        return answerRepository.findByStudent(student);
//    }
//
////    public void saveUserAnswer(User user, AnswerRequest answerRequest) {
////        Student student = getExistedStudentFromDataBase(user.getId());
////        //List<Test> tests = testRepository.findAll();
////        Answer answer = new Answer();
////        Test test = testRepository.findById(answerRequest.getTestId()).get();
////        answer.setTest(test);
////        List<Question> questions = new ArrayList<>();
////        for (Long aLong : answerRequest.getQuestionId()) {
////            questions.add(questionRepository.getById(aLong));
////        }
////        List<Option> options = new ArrayList<>();
////        for (Question question : questions) {
////            answer.setQuestion(question);
////            for (Long aLong : answerRequest.getOptionId()) {
////                options.add(optionRepository.getById(aLong));
////            }
////        }
////
////        //answer.setOptionList(answerRequest.setOptionId();
////    }
//
//    // @Override
//    public void saveUserAnswer(Long studentId, Long testId, Long questionId, Long optionId) {
//        Student student = getExistedStudentFromDataBase(studentId);
//        Question question = questionRepository.findById(questionId).orElseThrow(() -> {
//            log.error("question with id = {} does not exists in database", questionId);
//            throw new ResourceNotFoundException("Not found question with this id: " + questionId);
//        });
//        TestingResult localTestingResult = testingResultRepository.findByTestAndStudent(testId, studentId)
//                .orElseThrow(() -> {
//                    log.error("testingResult with id = {} and email = {} does not exists in database", testId, studentId);
//                    throw new ResourceNotFoundException("Not found testingResult with this id: " + testId + "email: " + studentId);
//                });
//        Option option = optionRepository.findById(optionId).orElseThrow(() -> {
//            log.error("option with id = {} does not exists in database", optionId);
//            throw new ResourceNotFoundException("Not found option with this id: " + optionId);
//        });
//
//        Answer answer = new Answer();
//        answer.setQuestion(question);
//        answer.setTestingResult(localTestingResult);
//        //answer.setOptionList();
//        if (option.isCorrectAnswer()) {
//            answer.setCorrectAnswers(1);
//        } else {
//            answer.setIncorrectAnswers(0);
//        }
//        LocalDateTime currentTime = LocalDateTime.now();
//        LocalDateTime finishTime = localTestingResult.getFinishTime();
//        if (currentTime.isBefore(finishTime)) {
//            answer.setChosenTime(currentTime);
//            answerRepository.save(answer);
//        } else {
//            throw new RuntimeException("Time out");
//        }
//        answerRepository.save(answer);
//    }
//
//    private Answer getExistedAnswerFromDataBase(Long testResultId, Long questionId) {
//        return answerRepository.findByTestingResultIdAndAndQuestionId(testResultId, questionId)
//                .orElseThrow(() -> {
//                    log.error("answer with testResultId = {} and questionId = {} does not exists in database", testResultId, questionId);
//                    throw new ResourceNotFoundException("Not found answer with this testResultId: " + testResultId + "questionId: " + questionId);
//                });
//    }
//
//    private Student getExistedStudentFromDataBase(Long studentId) {
//        return studentRepository.findById(studentId).orElseThrow(() -> {
//            log.info("Not found student with id: {}", studentId);
//            throw new ResourceNotFoundException("Not found student with id: " + studentId);
//        });
//    }
//}
