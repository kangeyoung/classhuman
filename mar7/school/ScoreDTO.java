package mar7.school;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ScoreDTO {
    private String sid;
    private String subject;
    private int score;
    private int rank;
}
