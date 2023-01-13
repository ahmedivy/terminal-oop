package com.example.terminaloop;


public abstract class Person {
    private Double weight, height;

    public Person(Double weight, Double height) {
        this.weight = weight;
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public abstract double calculateBMI();

    public abstract boolean isHealthy();

    public abstract int getAge();
}
