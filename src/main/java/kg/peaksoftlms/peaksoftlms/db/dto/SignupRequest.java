package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignupRequest {
    private String email;
    private String password;
    private List<String> roles;
}
