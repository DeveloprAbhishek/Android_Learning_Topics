package com.example.callerapp09july21;

public class ContactModel {
    private String name, number;

    public ContactModel(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
