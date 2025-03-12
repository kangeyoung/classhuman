package javaProject.amusementPark.facility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttractionDTO {
    private String atId;
    private String atName;
    private String atUrl;
    private int atMax;
    private int atOnoff;
}
