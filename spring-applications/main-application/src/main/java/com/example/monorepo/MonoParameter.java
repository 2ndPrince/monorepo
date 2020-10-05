package com.example.monorepo;

public enum MonoParameter {

    VEHICLE("car");

    private final String defaultValue;

    MonoParameter(String defaultValue) { this.defaultValue = defaultValue; }

    public String getDefaultValue(){ return defaultValue; }
}
