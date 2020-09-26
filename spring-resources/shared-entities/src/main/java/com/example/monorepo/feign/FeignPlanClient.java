package com.example.monorepo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "weather-application")
public interface FeignPlanClient extends FeignPlanProvider {

}
