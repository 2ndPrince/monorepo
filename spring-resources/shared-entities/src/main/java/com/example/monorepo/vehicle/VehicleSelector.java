package com.example.monorepo.vehicle;

import com.example.monorepo.MonoParameter;
import com.example.monorepo.model.client.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class VehicleSelector {

    private final ApplicationContext applicationContext;

    public VehicleSelector(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public VehicleManagerConfiguration determineVehicleForClient(Client client) {
        Optional<String> vehicleBeanName = Optional.ofNullable(client.getMonoParameters().get(MonoParameter.VEHICLE));
        Map<String, VehicleManagerConfiguration> beansOfType = applicationContext.getBeansOfType(VehicleManagerConfiguration.class);
        return vehicleBeanName.map(x -> beansOfType.getOrDefault(x, applicationContext.getBean(VehicleManagerConfiguration.class)))
                .orElse(applicationContext.getBean(VehicleManagerConfiguration.class));
    }
}
