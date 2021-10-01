package com.dzu.sparsearray;

/**
 * @author by ZhaoDong
 * @Classname TempArray
 * @Description TODO
 * @Date 2021/8/30 23:32
 */
public class TempArray {

    private Integer a;
    private Integer b;
    private Integer value;

    public TempArray(Integer a, Integer b, Integer value) {
        this.a = a;
        this.b = b;
        this.value = value;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
