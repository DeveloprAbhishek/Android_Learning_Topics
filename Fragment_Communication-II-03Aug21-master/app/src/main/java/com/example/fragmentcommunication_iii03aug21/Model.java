package com.example.fragmentcommunication_iii03aug21;

import java.io.Serializable;

public class Model implements Serializable {
    private String name, grade, percentage;
    private int age;

    public Model(String name, String grade, String percentage, int age) {
        this.name = name;
        this.grade = grade;
        this.percentage = percentage;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getPercentage() {
        return percentage;
    }

    public int getAge() {
        return age;
    }
}
