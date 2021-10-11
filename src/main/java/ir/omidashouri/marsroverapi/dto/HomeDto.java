package ir.omidashouri.marsroverapi.dto;

import lombok.Data;

@Data
public class HomeDto {

    private Long userId;
    private String marsApiRoverData;
    private Integer marsSol;
    private Boolean cameraFhaz;
    private Boolean cameraRhaz;
    private Boolean cameraMast;
    private Boolean cameraChemcam;
    private Boolean cameraMahli;
    private Boolean cameraMardi;
    private Boolean cameraNavcam;
    private Boolean cameraPancam;
    private Boolean cameraMinites;
    private Boolean rememberPreferences;

}
