package ir.omidashouri.marsroverapi.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mars_api_preferences", schema = "marsrover_sc")
public class HomeDto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "mars_api_rover_data")
    private String marsApiRoverData;

    @Column(name = "mars_sol")
    private Integer marsSol;

    @Column(name = "camera_fhaz")
    private Boolean cameraFhaz;

    @Column(name = "camera_rhaz")
    private Boolean cameraRhaz;

    @Column(name = "camera_mast")
    private Boolean cameraMast;

    @Column(name="camera_chemcam")
    private Boolean cameraChemcam;

    @Column(name="camera_mahli")
    private Boolean cameraMahli;

    @Column(name = "camera_mardi")
    private Boolean cameraMardi;

    @Column(name = "camera_navcam")
    private Boolean cameraNavcam;

    @Column(name = "camera_pancam")
    private Boolean cameraPancam;

    @Column(name = "camera_minites")
    private Boolean cameraMinites;

    @Column(name = "remember_preferences")
    private Boolean rememberPreferences;

}
