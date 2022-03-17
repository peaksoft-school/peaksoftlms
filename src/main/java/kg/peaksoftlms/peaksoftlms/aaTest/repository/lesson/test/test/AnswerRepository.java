package kg.peaksoftlms.peaksoftlms.aaTest.repository.lesson.test.test;

import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
