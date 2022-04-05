package com.example.android1.classes;

public class BmiFormData {
    int age;
    int feet;
    int inches;
    int weight;
    double bmi;

    public BmiFormData(int age, int feet, int inches, int weight) {
        this.age = age;
        this.feet = feet;
        this.inches = inches;
        this.weight = weight;
        int totalInches = feet * 12 + inches;
        double heightInMeters = totalInches * 0.0254;
        this.bmi = weight / (heightInMeters * heightInMeters);
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

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}
