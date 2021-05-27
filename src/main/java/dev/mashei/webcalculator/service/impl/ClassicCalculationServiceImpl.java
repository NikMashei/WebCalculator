package dev.mashei.webcalculator.service.impl;

import dev.mashei.webcalculator.dao.AuditDao;
import dev.mashei.webcalculator.service.ClassicCalculationService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassicCalculationServiceImpl implements ClassicCalculationService {

    private final AuditDao auditDao;

    @SneakyThrows
    @Override
    public Integer sum(Integer a, Integer b) {
        auditDao.audit("sum");
        return a + b;
    }

    @Override
    @SneakyThrows
    public Integer subtract(Integer a, Integer b) {
        auditDao.audit("sum");
        return a - b;
    }

    @SneakyThrows
    @Override
    public Integer multiplicative(Integer a, Integer b) {
        auditDao.audit("sum");
        return a * b;
    }

    @SneakyThrows
    @Override
    public Integer divide(Integer a, Integer b) {
        auditDao.audit("sum");
        return a / b;
    }
}
