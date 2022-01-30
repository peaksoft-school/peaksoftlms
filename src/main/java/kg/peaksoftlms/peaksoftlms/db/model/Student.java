package kg.peaksoftlms.peaksoftlms.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Entity@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Student extends User{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank (message = "Have to create new student")
    private String studentName;
    @NotBlank (message = "Have to write last name")
    private String studentLastName;
    @Email (message = "wrong E-mail, please give the correct E-mail")
    private String studentEmail;
    @JsonProperty
    private String password;
    private String studentImg;
    @NotNull(message = "date of create is required!")
    private LocalDate dateOfCreate;

    @ManyToMany
    @JoinColumn(name = "id")
    private List<Group> group;
    @Column(unique = true)

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mssv = 0;

    @OneToOne
    private User user;
    public Student(String studentEmail, String password) {
        super(studentEmail, password);
    }

    public Student(User user) {
    }
}
