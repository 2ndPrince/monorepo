package com.example.monorepo.vehicle;

import lombok.Data;

@Data
public class Bicycle implements Vehicle {
    private final int passengerCapacityLimit = 1; // person
    private final int goodsCapacityLimit = 20; // kg
    int passengerCapacityCurrent = 0;
    int goodsCapacityCurrent = 0;

    public boolean canLoadPassenger(int passengerConsumption) {
        if (passengerCapacityCurrent + passengerConsumption > passengerCapacityLimit) return false;
        passengerCapacityCurrent += passengerConsumption;
        return true;
    }

    public boolean canLoadGoods(int goodsConsumption) {
        if (goodsCapacityCurrent + goodsConsumption > goodsCapacityLimit) return false;
        goodsCapacityCurrent += goodsConsumption;
        return true;
    }

    public boolean canDrive() {
        return (passengerCapacityCurrent * goodsCapacityCurrent > 20) ? false : true;
    }

    public static Bicycle create(){
        return new Bicycle();
    }
}
