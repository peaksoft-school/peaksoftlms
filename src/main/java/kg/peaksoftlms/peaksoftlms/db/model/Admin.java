package kg.peaksoftlms.peaksoftlms.db.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User {

    @ManyToMany(cascade = {REFRESH, MERGE, DETACH, PERSIST}, fetch = FetchType.EAGER)
    private List<Role> roleList;

    public Admin(String email, String password, List<Role> roleList) {
        super(email, password);
        this.roleList = roleList;
    }

    public Admin(String email, String password) {
        super(email, password);
    }
}
