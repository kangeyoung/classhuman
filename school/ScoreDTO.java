package school;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreDTO {
    private String name;
    private int score;
    private String matter;
    private int rank;

    public ScoreDTO(String name, int score, String matter, int rank) {
        this.name = name;
        this.score = score;
        this.matter = matter;
        this.rank = rank;
    }
}
