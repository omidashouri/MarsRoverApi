package ir.omidashouri.marsroverapi.services;

import ir.omidashouri.marsroverapi.dto.HomeDto;
import ir.omidashouri.marsroverapi.model.responses.MarsRoverApiResponse;

public interface MarsRoverApiService {

    MarsRoverApiResponse getRoverData(HomeDto homeDto);

    MarsRoverApiResponse getRoverData(String roverType, Integer marsSol);
}
