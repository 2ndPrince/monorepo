package com.example.monorepo.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FeignPlanProvider {

    @GetMapping(value ="/weather/forecast")
    List<Double> forecast(@RequestParam("days") int days);
}
