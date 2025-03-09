package school;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO extends PeopleDTO {
    private String tSubject;
    private String tPosition;

    public TeacherDTO(String id, String pass, String name, boolean gender, String classNum, String tSubject, String tPosition) {
        super.setId(id);
        super.setPass(pass);
        super.setName(name);
        super.setGender(gender);
        super.setClassNum(classNum);
        this.tSubject = tSubject;
        this.tPosition = tPosition;
    }
}
