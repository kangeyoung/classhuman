package mar7.school;

import lombok.Getter;

@Getter
public class TeacherDTO extends PeopleS {
    private String tSubject;
    private String tPosition;

    public TeacherDTO(String id, String pass, String name, boolean gender, String className, String subject, String position) {
       super.id = id;
       super.pass = pass;
       super.name = name;
       super.gender = gender;
       super.className = className;
       tSubject = subject;
       tPosition = position;
    }

    public String getGender(){
        if(gender){
            return "남";
        }
        return "여";
    }

}
