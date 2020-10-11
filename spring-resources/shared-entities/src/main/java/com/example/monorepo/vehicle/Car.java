package com.example.monorepo.vehicle;

import lombok.Data;

@Data
public class Car implements Vehicle {
    private final int passengerCapacityLimit = 4; // person
    private final int goodsCapacityLimit = 100; // kg
    int passengerCapacityCurrent = 0;
    int goodsCapacityCurrent = 0;

    @Override
    public boolean canLoadPassenger(int passengerConsumption) {
        if (passengerCapacityCurrent + passengerConsumption > passengerCapacityLimit) return false;
        passengerCapacityCurrent += passengerConsumption;
        return true;
    }

    @Override
    public boolean canLoadGoods(int goodsConsumption) {
        if (goodsCapacityCurrent + goodsConsumption > goodsCapacityLimit) return false;
        goodsCapacityCurrent += goodsConsumption;
        return true;
    }

    @Override
    public boolean canDrive() {
        return (passengerCapacityCurrent * goodsCapacityCurrent > 250) ? false : true;
    }

    public static Car create(){
        return new Car();
    }
}
