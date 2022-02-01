package kg.peaksoftlms.peaksoftlms.db.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema (description = "DTO for registering User")
public class SignupRequest {
    @Schema (description = "Enter an E-mail", example = "user@user.com")
    private String email;
    @Schema (description = "Enter a 6 digit password", example = "123456qwery")
    private String password;
    @Schema (description = "default user", example = "User")
    private List<String> roles;
}
