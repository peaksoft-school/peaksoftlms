package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class GroupRequest {
    // TODO: 3/2/22 add image
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfCreate;
    private String description;
}
