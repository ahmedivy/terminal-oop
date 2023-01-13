package com.example.terminaloop;


import java.time.LocalDate;

public class Male extends Person{

    LocalDate dob;

    public Male(Double weight, Double height, LocalDate dob) {
        super(weight, height);
        this.dob = dob;
    }

    @Override
    public double calculateBMI() {
        return getWeight() / (getHeight() * getHeight());
    }

    @Override
    public boolean isHealthy() {
        return (calculateBMI() > 18.5 && calculateBMI() < 24.9);
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public int getAge() {
        return LocalDate.now().getYear() - dob.getYear();
    }
}
