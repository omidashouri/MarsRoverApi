package ir.omidashouri.marsroverapi.model.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MarsRover {

    private Long id;
    private String name;

    @JsonProperty("landing_date")
    private String landingDate;

    @JsonProperty("launch_date")
    private String launchDate;

    private String status;
}
