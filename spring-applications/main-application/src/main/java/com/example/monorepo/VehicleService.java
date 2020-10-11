package com.example.monorepo;

import com.example.monorepo.model.client.Client;
import com.example.monorepo.vehicle.Vehicle;
import com.example.monorepo.vehicle.VehicleSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleSelector vehicleSelector;

    public void getMeDatabaseValue(){
        String value = "car"; // replace this by database
        System.out.println(value);
    }

    public Vehicle getMyVehicle(Client client){
        return vehicleSelector.determineVehicleForClient(client).getVehicle();
    }
}
