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

    @Override
    public MarsRoverApiResponse getRoverData() {
        ResponseEntity<MarsRoverApiResponse> responseEntity = restTemplate
                .getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=2&api_key=DEMO_KEY", MarsRoverApiResponse.class);
        return responseEntity.getBody();
    }
}