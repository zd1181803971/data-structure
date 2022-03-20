package com.dzu.hashtable;

/**
 * @author by ZhaoDong
 * @Classname Emp
 * @Description 员工信息
 * @Date 2022/3/20 9:27
 */
public class Emp {
    public String id;
    public String name;
    public Emp next;

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
