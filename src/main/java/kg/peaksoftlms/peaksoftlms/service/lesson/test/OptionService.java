package kg.peaksoftlms.peaksoftlms.service.lesson.test;

import kg.peaksoftlms.peaksoftlms.db.dto.lesson.test.OptionRequest;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Option;

import java.util.List;

public interface OptionService {
    Option saveOption(Long questionId, OptionRequest optionRequest);

    Option getById(Long id);

    List<Option> getAllByQuestionId(Long questionId);

    void deleteById(Long id);

    Option update(Long id, OptionRequest optionRequest, Long testId);
}
