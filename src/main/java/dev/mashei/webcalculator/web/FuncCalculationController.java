package dev.mashei.webcalculator.web;

import dev.mashei.webcalculator.service.FuncCalculationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;
import java.util.logging.Logger;

@RestController
public class FuncCalculationController {

    private final Logger logger = Logger.getLogger(FuncCalculationController.class.getName());

    @SneakyThrows
    @GetMapping("sum")
    ResponseEntity<Result> sumNumbers(@RequestParam Integer a, @RequestParam Integer b) {
        var provider = FuncCalculationController.class.getName();
        logger.info("request");
        Thread.sleep(1000);
        var result = new FuncCalculationService() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                var s = a.toString();
                var s1 = b.toString();
                return a + b;
            }
        }.calculate(a, b);
        return ResponseEntity.ok(new Result(result, provider));
    }

    @SneakyThrows
    @GetMapping("subtract")
    ResponseEntity<Result> subtractNumbers(@RequestParam Integer a, @RequestParam Integer b) {
        var provider = FuncCalculationController.class.getName();
        logger.info("request");
        Thread.sleep(1000);
        var result = new FuncCalculationService() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                var s = a + b.toString();
                return a - b;
            }
        }.calculate(a, b);
        return ResponseEntity.ok(new Result(result, provider));
    }

    @GetMapping("multiplicativeNumbers")
    ResponseEntity<Result> multiplicativeNumbers(@RequestParam Integer a, @RequestParam Integer b) throws InterruptedException {
        var provider = FuncCalculationController.class.getName();
        logger.info("request");
        Thread.sleep(1000);
        var result = new FuncCalculationService() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                return a * b;
            }
        }.calculate(a, b);
        return ResponseEntity.ok(new Result(result, provider));
    }

    @GetMapping("divide")
    ResponseEntity<Result> divideNumber(@RequestParam Integer a, @RequestParam Integer b) {
        var provider = FuncCalculationController.class.getName();
        logger.info("request");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var result = new FuncCalculationService() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                return a / b;
            }
        }.calculate(a, b);
        return ResponseEntity.ok(new Result(result, provider));
    }


    @RequiredArgsConstructor
    @Getter
    static class Result {
        private final Integer result;
        private final String provider;
    }
}
