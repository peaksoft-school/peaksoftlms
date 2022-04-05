package kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.test;

import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByTestId(Long testId);
}
