package ir.omidashouri.marsroverapi.services;

import ir.omidashouri.marsroverapi.dto.HomeDto;
import ir.omidashouri.marsroverapi.model.responses.MarsPhoto;
import ir.omidashouri.marsroverapi.model.responses.MarsRoverApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MarsRoverApiServiceImpl implements MarsRoverApiService {

    private final RestTemplate restTemplate;

    private Map<String, List<String>> validCameras = new HashMap<>() {
        {
            put("Opportunity", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
            put("Curiosity", Arrays.asList("FHAZ", "RHAZ", "MAST", "CHEMCAM", "MAHLI", "MARDI", "NAVCAM"));
            put("Spirit", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
        }
    };

    private static final String API_KEY = "SIOuN616jFA0TAhhnTyzmf1PgBVvfXZFDLeyy7Ba";

    @Override
    public MarsRoverApiResponse getRoverData(HomeDto homeDto) throws InvocationTargetException, IllegalAccessException {
        List<String> apiUrlEndPoints = this.getApiUrlEndPoints(homeDto);
        MarsRoverApiResponse marsRoverApiResponse = new MarsRoverApiResponse();

        List<MarsPhoto> marsPhotos = apiUrlEndPoints
                .stream()
                .map(aue -> restTemplate.getForEntity(aue, MarsRoverApiResponse.class))
                .map(ResponseEntity::getBody)
                .map(MarsRoverApiResponse::getPhotos)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        marsRoverApiResponse.setPhotos(marsPhotos);
        return marsRoverApiResponse;
    }

    @Override
    public MarsRoverApiResponse getRoverData(String roverType, Integer marsSol) {
        ResponseEntity<MarsRoverApiResponse> responseEntity = restTemplate
                .getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/" + roverType + "/photos?sol=" + marsSol + "&api_key=" + API_KEY, MarsRoverApiResponse.class);
        return responseEntity.getBody();
    }

    public List<String> getApiUrlEndPoints(HomeDto homeDto) throws InvocationTargetException, IllegalAccessException {
        List<String> urls = new ArrayList<String>();

        Method[] methods = homeDto.getClass().getMethods();

        for (Method method : methods) {
            if (method.getName().indexOf("getCamera") > -1 && Boolean.TRUE.equals(method.invoke(homeDto))) {
                String cameraName = method.getName().split("getCamera")[1].toUpperCase();
                if (validCameras.get(homeDto.getMarsApiRoverData()).contains(cameraName)) {
                    urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol=" + homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=" + cameraName);
                }
            }
        }
        return urls;
    }
}
