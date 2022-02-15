package kg.peaksoftlms.peaksoftlms.db.repository;

import kg.peaksoftlms.peaksoftlms.db.model.Admin;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
    Optional<Admin> findUserByName(String name);
}
