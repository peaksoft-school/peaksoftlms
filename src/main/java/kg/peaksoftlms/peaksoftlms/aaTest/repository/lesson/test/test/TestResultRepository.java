package kg.peaksoftlms.peaksoftlms.aaTest.repository.lesson.test.test;

import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {
}
