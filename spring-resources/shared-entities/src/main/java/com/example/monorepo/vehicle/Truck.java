package com.example.monorepo.vehicle;

import lombok.Data;

@Data
public class Truck implements Vehicle {
    private final int passengerCapacityLimit = 2; // person
    private final int goodsCapacityLimit = 500; // kg
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
        return (passengerCapacityCurrent * goodsCapacityCurrent > 950) ? false : true;
    }

    public static Truck create(){
        return new Truck();
    }
}
