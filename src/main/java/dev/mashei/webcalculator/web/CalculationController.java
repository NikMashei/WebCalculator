package dev.mashei.webcalculator.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.mashei.webcalculator.service.impl.ClassicCalculationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping(value = "classic")
public class CalculationController {

    @Autowired
    ClassicCalculationServiceImpl service;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("sum")
    public String sumNumbers(@RequestParam String a, @RequestParam String b) throws JsonProcessingException {
        var provider = CalculationController.class.getName();
        var result = service.sum(Integer.parseInt(a), Integer.parseInt(b));
        return objectMapper.writeValueAsString(new Result(result, provider));
    }

    class Result {
        private Integer result;
        private String provider;

        public Result(Integer result, String provider) {
            this.result = result;
            this.provider = provider;
        }

        public Integer getResult() {
            return result;
        }

        public String getProvider() {
            return provider;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result1 = (Result) o;
            return Objects.equals(result, result1.result) && Objects.equals(provider, result1.provider);
        }

        @Override
        public int hashCode() {
            return new Object().hashCode();
        }
    }
}
