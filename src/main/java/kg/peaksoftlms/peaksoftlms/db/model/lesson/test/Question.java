package kg.peaksoftlms.peaksoftlms.db.model.lesson.test;

import kg.peaksoftlms.peaksoftlms.db.enums.EQuestionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    @Enumerated(EnumType.STRING)
    private EQuestionType eQuestionType;
    @OneToMany
    private List<Option> optionList;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public void setOption(Option option) {
        if (optionList == null) {
            optionList = new ArrayList<>();
        }
        optionList.add(option);
        option.setQuestion(this);
    }

//    @ManyToOne
//    private Answer answer;
}
