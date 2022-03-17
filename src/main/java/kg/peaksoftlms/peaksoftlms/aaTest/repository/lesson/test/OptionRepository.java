package kg.peaksoftlms.peaksoftlms.aaTest.repository.lesson.test;

import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findAllByQuestionId(Long questionId);
}
