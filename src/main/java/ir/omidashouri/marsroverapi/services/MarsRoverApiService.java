package ir.omidashouri.marsroverapi.services;

import ir.omidashouri.marsroverapi.dto.HomeDto;
import ir.omidashouri.marsroverapi.model.responses.MarsRoverApiResponse;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface MarsRoverApiService {

    MarsRoverApiResponse getRoverData(HomeDto homeDto) throws InvocationTargetException, IllegalAccessException;

    MarsRoverApiResponse getRoverData(String roverType, Integer marsSol);

    Map<String, List<String>> getValidCameras();

    HomeDto save(HomeDto homeDto);

    HomeDto findByUserId(Long userId);
}
