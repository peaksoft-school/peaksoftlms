package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Data
@Slf4j
@Getter
@Setter
@NoArgsConstructor
//@ApiModel(description = "DTO для сущности Student")
@Component
public class StudentDto {
        private Long id;
        private Long userId;
        private int mssv;
}
