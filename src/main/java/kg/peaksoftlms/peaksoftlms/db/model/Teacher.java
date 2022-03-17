package kg.peaksoftlms.peaksoftlms.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "teachers")
public class Teacher {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotBlank(message = "Have to create new responsible person")
    private String firstName;
//    @NotBlank(message = "Have to write last name")
    private String LastName;
//    @Email(message = "wrong E-mail address, please check it again")
//    private String email;
//    @JsonProperty
//    private String password;
    @Column(name = "image_url")
    private String img;

    private String phoneNumber;
    private String specialization;

    @Column(name = "date_of_creation")
    @DateTimeFormat(pattern = "dd.mm.yyyy hh.mm")
    private Date dateOfCreate;

    @ManyToMany(mappedBy = "teacher", cascade = {DETACH, MERGE, PERSIST, REFRESH})
    @JsonIgnore
    private List<Course> courses;

    @OneToOne(cascade = ALL)
    private User user;

    public Teacher(long id, String firstName, String lastName,String img,
                   String phoneNumber, String specialization, Date dateOfCreate, User user) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
//        this.email = email;
//        this.password = password;
        this.img = img;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
        this.dateOfCreate = dateOfCreate;
        this.user = user;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", img='" + img + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", specialization='" + specialization + '\'' +
                ", dateOfCreate=" + dateOfCreate +
                '}';
    }
}
