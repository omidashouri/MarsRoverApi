package ir.omidashouri.marsroverapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MarsCamera {

    private Long id;
    private String name;
    private Long roverId;
    private String fullName;
}
