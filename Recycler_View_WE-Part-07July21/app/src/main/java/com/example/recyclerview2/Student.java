package com.example.recyclerview2;

public class Student {
    private String name, rollno;
    private int age;

    public Student(String name, String rollno, int age) {
        this.name = name;
        this.rollno = rollno;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getRollno() {
        return rollno;
    }

    public int getAge() {
        return age;
    }
}
