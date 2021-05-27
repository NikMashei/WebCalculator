package dev.mashei.webcalculator.service;

import dev.mashei.webcalculator.dao.AuditDao;
import dev.mashei.webcalculator.service.impl.ClassicCalculationServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClassicCalculationServiceTest {

    AuditDao auditDao;
    ClassicCalculationService service;

    @BeforeEach
    void setUp() {
        auditDao = Mockito.mock(AuditDao.class);
        service = new ClassicCalculationServiceImpl(auditDao);
    }

    @Test
    void sum() {
        //given
        var a = 5;
        var b = 3;

        //when
        var result = service.sum(a, b);

        //then
        assertThat(result).isEqualTo(8);
    }

    @Test
    void multiplicative() {
        //given
        var a = 5;
        var b = 3;

        //when
        var result = service.multiplicative(a, b);

        //then
        assertThat(result).isEqualTo(15);
    }
}