package com.example.monorepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/weather")
public class ForecastController {

    @Autowired
    ForecastService forecastService;

    @GetMapping(value = "/forecast/{days}")
    public List<Double> forecast(@PathVariable int days) {
        return forecastService.predict(days);
    }
}
