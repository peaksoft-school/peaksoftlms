package kg.peaksoftlms.peaksoftlms.service.impl;

import kg.peaksoftlms.peaksoftlms.db.model.Role;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.db.repository.RoleRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.UserRepository;
import kg.peaksoftlms.peaksoftlms.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        log.info("Saving new User {} to the Database", user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Role> roleList = new ArrayList<>();
        for (Role role : user.getRole()) {
            roleList.add(roleRepository.getRoleByRoleName(role.getRoleName()));
        }
        user.setRole(roleList);
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new {} Role to the Database", role.getRoleName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        log.info("Adding role {} to User {}", roleName, email);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));
        Role role = roleRepository.getRoleByRoleName(roleName);
        user.getRole().add(role);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        log.info("Fetching user {}", email);
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
