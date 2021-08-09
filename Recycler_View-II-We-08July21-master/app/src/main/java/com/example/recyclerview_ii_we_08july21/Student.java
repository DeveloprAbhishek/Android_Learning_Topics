package com.example.recyclerview_ii_we_08july21;

public class Student {
    String name, address, dob;
    int imageId, age;

    public Student(String name, String address, String dob, int imageId, int age) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.imageId = imageId;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public int getImageId() {
        return imageId;
    }

    public int getAge() {
        return age;
    }
}
