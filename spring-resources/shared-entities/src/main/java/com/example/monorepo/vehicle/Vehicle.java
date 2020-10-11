package com.example.monorepo.vehicle;

public interface Vehicle {

    public boolean canLoadPassenger(int passengerConsumption);

    public boolean canLoadGoods(int goodsConsumption);

    public boolean canDrive();
}
