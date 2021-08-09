package com.example.idenditycard07july21;

public class Person {
    private int image, age;
    private String profession, designation;

    public Person(int image, int age, String profession, String designation) {
        this.image = image;
        this.age = age;
        this.profession = profession;
        this.designation = designation;
    }

    public int getImage() {
        return image;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    public String getDesignation() {
        return designation;
    }
}
