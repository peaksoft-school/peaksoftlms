package kg.peaksoftlms.peaksoftlms.service.lesson.test;

import kg.peaksoftlms.peaksoftlms.db.dto.lesson.test.OptionRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.lesson.test.QuestionRequest;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Option;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Question;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Test;
import kg.peaksoftlms.peaksoftlms.db.repository.lesson.TestRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.lesson.test.QuestionRepository;
import kg.peaksoftlms.peaksoftlms.exeption.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final TestRepository testRepository;

    public Question saveQuestion(Long testId, QuestionRequest questionRequest) {
        Test test = testRepository.findById(testId).orElseThrow(() -> {
            log.error("test with id = {} does not exists in database", testId);
            throw new ResourceNotFoundException("Not found test with this id: " + testId);
        });
        Question question = new Question();
        question.setTest(test);
        question.setQuestion(questionRequest.getQuestion());
        question.setEQuestionType(questionRequest.getEQuestionType());
        for (OptionRequest optionRequest : questionRequest.getOptionRequestList()) {
            question.setOption(getOption(optionRequest));
        }
        test.addQuestionForTest(question);
        return questionRepository.save(question);
    }

    @Override
    public Question getById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> {
            log.error("question with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found question with this id: " + id);
        });
    }

    @Override
    public List<Question> getAllByTestId(Long testId) {
        if (!testRepository.existsById(testId)) {
            log.error("test with id = {} does not exists in database", testId);
            throw new ResourceNotFoundException("Not found test with this id: " + testId);
        }
        return questionRepository.findByTestId(testId);
    }

    @Override
    public void deleteById(Long id) {
        if (!questionRepository.existsById(id)) {
            log.error("question with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found question with id: " + id);
        }
        log.info("Delete question with id = {} ", id);
        testRepository.deleteById(id);

    }

    @Override
    public Question update(Long id, QuestionRequest questionRequest, Long testId) {
        if (!testRepository.existsById(testId)) {
            log.error("test with id = {} does not exists in database", testId);
            throw new ResourceNotFoundException("Not found test with this id: " + testId);
        }
        Question question = questionRepository.findById(id).orElseThrow(() -> {
            log.error("question with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found question with this id: " + id);
        });
        question.setQuestion(questionRequest.getQuestion());
        question.setEQuestionType(questionRequest.getEQuestionType());
        //question.setOptionList(getOptionList(question, questionRequest.getOptionRequestList()));
        return questionRepository.save(question);
    }

    private Option getOption(OptionRequest o) {
        Option option = new Option();
        option.setOptionContent(o.getOptionContent());
        option.setCorrectAnswer(o.isCorrectAnswer());
        return option;
    }
}
