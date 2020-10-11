package com.example.monorepo.vehicle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class VehicleManagerBeanConfig {

    @Primary
    @Bean("car")
    VehicleManagerConfiguration carManager() {
        return Car::create;
    }

    @Bean("truck")
    VehicleManagerConfiguration truckManager() {
        return Truck::create;
    }

    @Bean("bicycle")
    VehicleManagerConfiguration bicycleManager() {
        return Bicycle::create;
    }
}
