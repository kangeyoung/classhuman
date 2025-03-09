package school;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleDTO {
    private String id;
    private String pass;
    private String name;
    private boolean gender;
    private String classNum;

    public int getGenderNum(){
        if (gender){
            return 0;
        }else{
            return 1;
        }
    }

}
