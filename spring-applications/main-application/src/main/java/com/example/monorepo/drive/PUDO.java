package com.example.monorepo.drive;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class PUDO {

    @NotNull
    @Min(value = 0)
    private double x_start;

    @NotNull
    @Max(value = 10)
    private double y_start;

    @NotNull
    @Min(value = 0)
    private double x_finish;

    @NotNull
    @Max(value = 10)
    private double y_finish;
}
