package kg.peaksoftlms.peaksoftlms.db.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import kg.peaksoftlms.peaksoftlms.db.model.Role;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@ApiModel(description = "DTO для данных юзера")
public class UserResponse {

        private Long id;
        private String email;
        private String password;
        private List<Role> roles;


        public UserResponse fromUser(User user) {
            UserResponse userDto = new UserResponse();
            userDto.setId(user.getId());
            userDto.setRoles(user.getRole());
            return userDto;
        }
}
