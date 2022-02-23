package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class TeacherResponse {
    private Long id;
    private String firstName;
    private String LastName;
    private String email;
    private String password;
    private String img;
    private int phoneNumber;
    private String specialization;
    private LocalDate dateOfCreate;
}