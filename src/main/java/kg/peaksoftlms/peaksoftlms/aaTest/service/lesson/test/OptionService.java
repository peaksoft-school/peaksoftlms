package kg.peaksoftlms.peaksoftlms.aaTest.service.lesson.test;

import kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.test.OptionRequest;
import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.Option;

import java.util.List;

public interface OptionService {
    Option saveOption(Long questionId, OptionRequest optionRequest);

    Option getById(Long id);

    List<Option> getAllByQuestionId(Long questionId);

    void deleteById(Long id);

    Option update(Long id, OptionRequest optionRequest, Long testId);
}
