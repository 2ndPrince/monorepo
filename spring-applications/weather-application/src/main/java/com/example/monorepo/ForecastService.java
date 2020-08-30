package com.example.monorepo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForecastService {

    public List<Double> predict(int days) {
        List<Double> rainProbabilityList = new ArrayList<>();
        for (int i = 1; i <= days; i++) {
            if (i == 5) {
                rainProbabilityList.add(1.0);
            } else if (i % 2 == 0) {
                rainProbabilityList.add(0.5);
            } else{
                rainProbabilityList.add(0.1);
            }
        }
        return rainProbabilityList;
    }
}
