package kg.peaksoftlms.peaksoftlms.db.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ApiModel(description =  "DTO для построения ответов REST контроллеров")
public class ResponseDto<T> {
    private Boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String error;

    public ResponseDto(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public ResponseDto(Boolean success, String error) {
        this.success = success;
        this.error = error;
    }
}
