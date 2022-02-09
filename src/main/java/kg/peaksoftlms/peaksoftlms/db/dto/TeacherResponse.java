package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter@Setter
public class TeacherResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
