package com.book.design.one.calculator.factory;

import com.book.design.one.calculator.service.Calculation;
import com.book.design.one.calculator.service.Decrease;
import com.book.design.one.calculator.service.Increase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by ZhaoDong
 * @Classname CalculationFactory
 * @Description 计算类简单工厂
 * @Date 2022/2/16 23:47
 */
public class CalculationFactory {
    private static final Map<String, Calculation> map = new HashMap<>();

    static {
        map.put("+", new Increase());
        map.put("-", new Decrease());
    }

    public static Calculation getCalculationBean(String operation) {
        return map.get(operation);
    }

}
