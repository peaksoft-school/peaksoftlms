package kg.peaksoftlms.peaksoftlms.db.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.peaksoftlms.peaksoftlms.db.enums.LearningFormat;
import kg.peaksoftlms.peaksoftlms.db.model.Group;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Slf4j
@Getter
@Setter
@NoArgsConstructor

@Component
public class StudentRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private LearningFormat learningFormat;
    //private List<Group> groups;
}
