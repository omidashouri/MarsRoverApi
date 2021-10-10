package ir.omidashouri.marsroverapi.services;

import ir.omidashouri.marsroverapi.dto.HomeDto;
import ir.omidashouri.marsroverapi.model.responses.MarsRoverApiResponse;

import java.lang.reflect.InvocationTargetException;

public interface MarsRoverApiService {

    MarsRoverApiResponse getRoverData(HomeDto homeDto) throws InvocationTargetException, IllegalAccessException;

    MarsRoverApiResponse getRoverData(String roverType, Integer marsSol);
}
