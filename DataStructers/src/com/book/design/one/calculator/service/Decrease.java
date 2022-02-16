package com.book.design.one.calculator.service;

import java.math.BigDecimal;

/**
 * @author by ZhaoDong
 * @Classname Decrease
 * @Description 减法
 * @Date 2022/2/16 23:42
 */
public class Decrease implements Calculation{
    @Override
    public BigDecimal execute(BigDecimal num1, BigDecimal num2) {
        return num1.subtract(num2);
    }
}
