package ir.omidashouri.marsroverapi.model;

import lombok.Data;

@Data
public class MarsPhoto {

    private Long id;
    private Integer sol;
    private MarsCamera camera;
    private String imgSrc;


}
