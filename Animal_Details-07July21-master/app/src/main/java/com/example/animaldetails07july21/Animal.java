package com.example.animaldetails07july21;

public class Animal {
    private int image;
    private String type, sound;

    public Animal(int image, String type, String sound) {
        this.image = image;
        this.type = type;
        this.sound = sound;
    }

    public int getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }
}
