package com.example.monorepo.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class User {

    @NotNull
    String id;

    String name;

    @Min(value = 0)
    int age;
}
