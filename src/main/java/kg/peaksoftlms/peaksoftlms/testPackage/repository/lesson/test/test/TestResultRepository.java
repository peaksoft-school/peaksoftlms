package kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.test.test;

import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {
}
