package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class GroupRequest {
    private long id;
    private String name;
    private LocalDate dateOfCreate;
    private String description;
}
