package com.example.terminaloop;

import java.util.List;

public class Util {
    public static <T extends Person> double calculateAverage(List<T> list) {
        double sum = 0;
        for (T t : list) {
            sum += t.calculateBMI();
        }
        return sum / list.size();
    }
}
