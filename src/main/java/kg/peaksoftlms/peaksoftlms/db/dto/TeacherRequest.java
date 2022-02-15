package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String img;
}
