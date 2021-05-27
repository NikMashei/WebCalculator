package dev.mashei.webcalculator.service;

import org.springframework.stereotype.Service;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;

@FunctionalInterface
public interface FuncCalculationService {
    Integer calculate(Integer a, Integer b);
}
