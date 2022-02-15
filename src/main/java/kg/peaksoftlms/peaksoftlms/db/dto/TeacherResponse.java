package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
//@Builder
public class TeacherResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String img;
}
