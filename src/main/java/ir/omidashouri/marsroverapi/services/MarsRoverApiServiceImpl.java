package ir.omidashouri.marsroverapi.services;

import ir.omidashouri.marsroverapi.model.responses.MarsRoverApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class MarsRoverApiServiceImpl implements MarsRoverApiService {

    private final RestTemplate restTemplate;

    private static final String API_KEY = "SIOuN616jFA0TAhhnTyzmf1PgBVvfXZFDLeyy7Ba";

    @Override
    public MarsRoverApiResponse getRoverData(String roverType, Integer marsSol) {
        ResponseEntity<MarsRoverApiResponse> responseEntity = restTemplate
                .getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/" + roverType + "/photos?sol=" + marsSol + "&api_key=" + API_KEY, MarsRoverApiResponse.class);
        return responseEntity.getBody();
    }
}
