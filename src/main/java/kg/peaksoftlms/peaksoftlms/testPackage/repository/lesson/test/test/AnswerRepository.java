package kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.test.test;

import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
