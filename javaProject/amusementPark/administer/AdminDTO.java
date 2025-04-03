package javaProject.amusementPark.administer;

import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class AdminDTO {
    private String aId;
    private String aPass;
    private String aName;
    private int aGender;
    private Date aBirth;
    private String aPosition;

    public String BirthToString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(aBirth);
    }

    public void setBirth(String aBirth) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.aBirth = sdf.parse(aBirth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
