package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.model.Role;
import kg.peaksoftlms.peaksoftlms.db.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    Optional<User> getUserByEmail(String email);

    List<User> getUsers();
}
