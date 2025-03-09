package school;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class StudentDTO extends PeopleDTO {
    private String sNum;
    private String sScore;
    private ArrayList<ScoreDTO> sList = new ArrayList<>();

    public StudentDTO(String id, String pass, String name, boolean gender, String classNum, String sNum) {
        super.setId(id);
        super.setPass(pass);
        super.setName(name);
        super.setGender(gender);
        super.setClassNum(classNum);
        this.sNum = sNum;
    }

    public void prt() {
    }
}
