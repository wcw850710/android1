package com.example.android1.classes;

public class BmiFormData {
    int age;
    int feet;
    int inches;
    int weight;

    public BmiFormData(int age, int feet, int inches, int weight) {
        this.age = age;
        this.feet = feet;
        this.inches = inches;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFeet() {
        return feet;
    }

    public void setFeet(int feet) {
        this.feet = feet;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
