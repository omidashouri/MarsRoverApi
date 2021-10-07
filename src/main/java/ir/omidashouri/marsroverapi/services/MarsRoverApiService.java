package ir.omidashouri.marsroverapi.services;

import ir.omidashouri.marsroverapi.model.responses.MarsRoverApiResponse;

public interface MarsRoverApiService {

    MarsRoverApiResponse getRoverData(String roverType);
}
