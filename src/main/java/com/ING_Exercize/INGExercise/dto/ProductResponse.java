package com.ING_Exercize.INGExercise.dto;

import java.math.BigDecimal;

public record ProductResponse(String name, BigDecimal price, BigDecimal quantity) {
}
