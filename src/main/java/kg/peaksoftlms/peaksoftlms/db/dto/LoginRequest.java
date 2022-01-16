package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class LoginRequest {
    private String email;
    private String password;
}
