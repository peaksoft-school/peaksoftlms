package kg.peaksoftlms.peaksoftlms.db.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Slf4j
@Getter
@Setter
@NoArgsConstructor
//@ApiModel(description = "DTO для сущности Student")
@Component
public class StudentRequest {


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String studentImg;

}
