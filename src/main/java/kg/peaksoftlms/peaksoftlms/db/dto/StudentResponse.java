package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
//    private LearningFormat learningFormat;

    //private List<Group> groups;
}
