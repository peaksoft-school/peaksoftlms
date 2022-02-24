package kg.peaksoftlms.peaksoftlms.db.dto.lesson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Choice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"isCorrectAnswer"}, allowSetters = true)
public class ChoiceDto {
    private String label;
    @JsonProperty("isCorrectAnswer")
    private Boolean isCorrectAnswer;

    public static ChoiceDto fromEntity(Choice choice) {
        return new ChoiceDto(choice.getLabel(), choice.isCorrectAnswer());
    }
}
