package com.dzu.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by ZhaoDong
 * @Classname Test
 * @Description TODO
 * @Date 2021/10/2 16:39
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("11111111");
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("222222222222");
        Student s1 = new Student("qwe", 99, a1);
        Student s2 = new Student("qwe2", 992, a2);
        covert(s1,s2);
        System.out.println(s1);

    }

    public static void covert(Student s1, Student s2) {
        s1=s2;
        System.out.println(s1);
    }
}
class Student{
    public String name;
    public int age;
    public List<String> list;

    public Student(String name, int age, List<String> list) {
        this.name = name;
        this.age = age;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                '}';
    }
}

