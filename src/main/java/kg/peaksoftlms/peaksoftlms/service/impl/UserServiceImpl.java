package kg.peaksoftlms.peaksoftlms.service.impl;

import kg.peaksoftlms.peaksoftlms.db.model.Admin;
import kg.peaksoftlms.peaksoftlms.db.model.Role;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.db.repository.RoleRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.UserRepository;
import kg.peaksoftlms.peaksoftlms.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
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
    public Optional<Admin> getUserByEmail(String email) {
        log.info("Fetching user {}", email);
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Admin> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<Admin> getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

//    @Override
//    public List<Teacher> findAllByNameContaining(String name) {
//        List<User> users = userRepository.findAllByNameContainingAndRole(name, "STUDENT_ROLE");
//        List<Teacher> teachers = new ArrayList<>();
//        for (User user : users) {
//            Teacher teacher = new Teacher(user);
//            teachers.add(teacher);
//        }
//        return teachers;
    }

