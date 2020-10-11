package com.example.monorepo.vehicle;

import java.util.HashMap;
import java.util.Map;

public class LoadConfiguration extends HashMap<String, Number> {

    public LoadConfiguration() { this(new HashMap<>());}

    public LoadConfiguration(Map<String, Double> map) {
        super(map);
    }

    @Override
    public Number get(Object key) { return super.getOrDefault(key, 0d); }

    public double getWeight(String key) { return get(key).doubleValue(); }
}
