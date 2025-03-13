package javaProject.amusementPark.reservation;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class ReservationDTO {
    private int no;
    private String mId;
    private String tPass;
    private String atId;
    private Date rTime;

    public String toString(Date rTime){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(rTime);
    }
}
