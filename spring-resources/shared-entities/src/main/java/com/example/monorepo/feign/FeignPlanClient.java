package com.example.monorepo.feign;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface FeignPlanProvider {

    @GetMapping(value ="/weather/forecast")
    List<Double> forecast(int days);
}
