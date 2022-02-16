package com.book.design.one.calculator;

import com.book.design.one.calculator.factory.CalculationFactory;
import com.book.design.one.calculator.service.Calculation;

import java.math.BigDecimal;

/**
 * @author by ZhaoDong
 * @Classname CalculationApp
 * @Description 界面
 * @Date 2022/2/16 23:49
 */
public class CalculationApp {
    public static void main(String[] args) {

        Calculation calculation = CalculationFactory.getCalculationBean("+");
        BigDecimal result = calculation.execute(BigDecimal.ONE, BigDecimal.TEN);
        System.out.println(result);
    }
}
