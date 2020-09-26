package com.example.monorepo;


import com.example.monorepo.feign.FeignPlanClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlanService {
    
    private final FeignPlanClient feignPlanClient;

    public PlanService(FeignPlanClient feignPlanClient) {
        this.feignPlanClient = feignPlanClient;
    }

    public List<Boolean> canGoOutsideForWeek(double threshold) {
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // send POST request
        String url = "http://localhost:8081/weather/forecast/7";

        //Try ParameterizedTypeReference instead of Object[].class
        ResponseEntity<Object[]> response = restTemplate.getForEntity(url, Object[].class);

        ArrayList<Double> body = new ArrayList(Arrays.asList(response.getBody()));
        ArrayList<Boolean> yesno = new ArrayList<>();
        for (Double d : body) {
            if (d < threshold) {
                yesno.add(true);
            } else {
                yesno.add(false);
            }
        }
        return yesno;
    }

    public List<Boolean> canGoOutsideForWeekUsingFeign(double threshold){
        List<Double> forecast = feignPlanClient.forecast(7);
        ArrayList<Boolean> yesno = new ArrayList<>();
        for (Double d : forecast) {
            if (d < threshold) {
                yesno.add(true);
            } else {
                yesno.add(false);
            }
        }
        return yesno;
    }
}
