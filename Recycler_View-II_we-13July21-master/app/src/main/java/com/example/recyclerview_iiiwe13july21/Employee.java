package com.example.recyclerview_iiiwe13july21;

public class Employee {
    private String name;
    private Double salary;
    private int age;

    public Employee(String name, Double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}
