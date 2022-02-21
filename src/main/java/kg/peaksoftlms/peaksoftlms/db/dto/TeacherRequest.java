package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequest {

    private String firstName;
    private String LastName;
    private String email;
    private String password;
    private String img;
    private int phoneNumber;
    private String specialization;

}
