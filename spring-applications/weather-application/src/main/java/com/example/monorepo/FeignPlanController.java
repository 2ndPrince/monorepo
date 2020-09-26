package com.example.monorepo;

import com.example.monorepo.feign.FeignPlanProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class FeignPlanController implements FeignPlanProvider {

    @Autowired
    ForecastService forecastService;

    @Override
    public List<Double> forecast(int days) {
        log.info("feign call works");
        return forecastService.predict(days);
    }
}
