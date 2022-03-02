package kg.peaksoftlms.peaksoftlms.service.lesson.test;

import kg.peaksoftlms.peaksoftlms.db.dto.lesson.test.OptionRequest;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Option;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Question;
import kg.peaksoftlms.peaksoftlms.db.repository.lesson.test.OptionRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.lesson.test.QuestionRepository;
import kg.peaksoftlms.peaksoftlms.exeption.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OptionServiceImpl implements OptionService {
    private final OptionRepository optionRepository;
    private final QuestionRepository questionRepository;

    @Override
    public Option saveOption(Long questionId, OptionRequest optionRequest) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> {
            log.error("question with id = {} does not exists in database", questionId);
            throw new ResourceNotFoundException("Not found question with this id: " + questionId);
        });
        Option option = new Option();
        option.setOptionContent(optionRequest.getOptionContent());
        option.setCorrectAnswer(optionRequest.isCorrectAnswer());
        option.setQuestion(question);
        return optionRepository.save(option);
    }

    @Override
    public Option getById(Long id) {
        return optionRepository.findById(id).orElseThrow(() -> {
            log.error("option with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found option with this id: " + id);
        });
    }

    @Override
    public List<Option> getAllByQuestionId(Long questionId) {
        if (!questionRepository.existsById(questionId)) {
            log.error("question with id = {} does not exists in database", questionId);
            throw new ResourceNotFoundException("Not found question with id: " + questionId);
        }
        return optionRepository.findAllByQuestionId(questionId);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Option update(Long id, OptionRequest optionRequest, Long testId) {
        return null;
    }
}
