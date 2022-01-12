package kg.peaksoftlms.peaksoftlms.db.repository;

import kg.peaksoftlms.peaksoftlms.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
