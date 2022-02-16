package com.book.design.one.calculator.service;

import java.math.BigDecimal;

/**
 * @author by ZhaoDong
 * @Classname add
 * @Description 加法
 * @Date 2022/2/16 23:41
 */
public class Increase implements Calculation {

    @Override
    public BigDecimal execute(BigDecimal num1, BigDecimal num2) {
        return num1.add(num2);
    }
}
