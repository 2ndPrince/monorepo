package com.example.monorepo;

import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    public void getMeDatabaseValue(){
        String value = "car"; // replace this by database
        System.out.println(value);
    }
}
