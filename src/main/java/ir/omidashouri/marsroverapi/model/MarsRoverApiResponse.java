package ir.omidashouri.marsroverapi.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MarsRoverApiResponse {

    List<MarsPhoto> photos = new ArrayList<>();
}
