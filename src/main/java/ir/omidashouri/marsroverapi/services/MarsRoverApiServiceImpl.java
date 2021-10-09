package ir.omidashouri.marsroverapi.services;

import ir.omidashouri.marsroverapi.dto.HomeDto;
import ir.omidashouri.marsroverapi.model.responses.MarsPhoto;
import ir.omidashouri.marsroverapi.model.responses.MarsRoverApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MarsRoverApiServiceImpl implements MarsRoverApiService {

    private final RestTemplate restTemplate;

    private static final String API_KEY = "SIOuN616jFA0TAhhnTyzmf1PgBVvfXZFDLeyy7Ba";

    @Override
    public MarsRoverApiResponse getRoverData(HomeDto homeDto) {
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

    public List<String> getApiUrlEndPoints(HomeDto homeDto) {
        List<String> urls = new ArrayList<String>();
        if (Boolean.TRUE.equals(homeDto.getCameraFhaz())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol=" + homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=FHAZ");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraMahli()) && "curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol=" + homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=MAHLI");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraChemcam()) && "curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol=" + homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=CHEMCAM");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraMardi()) && "curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol=" + homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=MARDI");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraMast()) && "curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol=" + homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=MAST");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraMinites()) && !"curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol=" + homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=MINITES");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraNavcam())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol=" + homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=NAVCAM");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraPancam()) && !"curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol=" + homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=PANCAM");
        }
        return urls;
    }
}
