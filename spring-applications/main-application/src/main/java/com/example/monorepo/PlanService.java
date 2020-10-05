package com.example.monorepo;


import com.example.monorepo.drive.PUDO;
import com.example.monorepo.model.client.Client;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

@Service
public class PlanService {

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

    public Double estimate(PUDO pudo, Client clientId){
        Double x_distance = pudo.getX_finish() - pudo.getX_start();
        Double y_distance = pudo.getY_finish() - pudo.getY_start();
        Double total_distance = sqrt(pow(x_distance,2) - pow(y_distance,2));

        double vehicleSpeed = getVehicleSpeed(clientId);
        return total_distance/vehicleSpeed;
    }

    private double getVehicleSpeed(Client client) {
        String vehicleType = client.getMonoParameters().getOrDefault(
                MonoParameter.VEHICLE,
                MonoParameter.VEHICLE.getDefaultValue()
        );

        double speed = 0;

        switch(vehicleType){
            case "car":
                speed = 50;
                break;
            case "truck":
                speed = 30;
                break;
            case "bicycle":
                speed = 10;
                break;
            default:
                speed = 5;
        }

        return speed;
    }
}
