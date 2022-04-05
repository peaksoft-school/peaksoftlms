package kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.peaksoftlms.peaksoftlms.db.enums.EQuestionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String question;

    @Enumerated(EnumType.STRING)
    private EQuestionType eQuestionType;

    @OneToMany(cascade = {MERGE, REFRESH, PERSIST, DETACH}, fetch = FetchType.EAGER, mappedBy = "question")
    @Fetch(FetchMode.SUBSELECT)
    private List<Option> optionList;

    @ManyToOne(cascade = {MERGE, REFRESH, PERSIST, DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    @JsonIgnore
    private Test test;

    public void setOption(Option option) {
        if (optionList == null) {
            optionList = new ArrayList<>();
        }
        optionList.add(option);
        option.setQuestion(this);
    }
}
