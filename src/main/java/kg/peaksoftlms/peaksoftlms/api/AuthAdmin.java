package kg.peaksoftlms.peaksoftlms.api;

import kg.peaksoftlms.peaksoftlms.db.dto.SignupRequest;
import kg.peaksoftlms.peaksoftlms.db.model.Role;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.service.RoleService;
import kg.peaksoftlms.peaksoftlms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AuthAdmin {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @PostMapping("")
    public ResponseEntity<?> saveUser(@RequestBody SignupRequest signupRequest) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().
                path("/api/admin").toUriString());

        User user = new User(
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()));

        List<Role> roleList = new ArrayList<>();
        for (String role : signupRequest.getRoles()) {
            roleList.add(roleService.getByRoleName(role));
        }
        user.setRole(roleList);
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
}
