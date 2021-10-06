package ir.omidashouri.marsroverapi.model.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.omidashouri.marsroverapi.model.responses.MarsCamera;
import lombok.Data;

@Data
public class MarsPhoto {

    private Long id;
    private Integer sol;
    private MarsCamera camera;

    @JsonProperty("img_src")
    private String imgSrc;

    @JsonProperty("earth_date")
    private String earthDate;

    private MarsRover rover;


}
