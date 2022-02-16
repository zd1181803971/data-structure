package com.book.design.one.calculator.service;

import java.math.BigDecimal;

/**
 * @author by ZhaoDong
 * @Classname Calculation
 * @Description 计算
 * @Date 2022/2/16 23:42
 */
public interface Calculation {

    /**
     * 计算并返回结果
     * @param num1
     * @param num2
     */
    BigDecimal execute(BigDecimal num1, BigDecimal num2);
}
