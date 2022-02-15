package kg.peaksoftlms.peaksoftlms.db.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student extends User {

//    TODO: set a validation for the number insert
    private String number;

    @NotNull(message = "date of create is required!")
    private LocalDate dateOfCreate;

    /*
     *   If it is true student studying format is offline, otherwise studying format is online
     * */
    @Column(name = "format")
    private boolean studyFormat;

    @ManyToMany(mappedBy = "students", cascade = {DETACH, MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY)
    private List<Group> groupList;

    @ManyToMany(cascade = {REFRESH, MERGE, DETACH, PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "student_teacher", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teacherList;

    @ManyToMany(cascade = {REFRESH, DETACH, PERSIST, MERGE}, fetch = FetchType.LAZY)
    private List<Role> roleList;

    public Student(String studentEmail, String password) {
        super(studentEmail, password);
    }

}
