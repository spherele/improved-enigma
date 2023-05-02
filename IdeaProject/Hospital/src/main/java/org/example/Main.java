package org.example;

public class Main {
    public static void main(String[] args) {
        int patientsCount = (int) (Math.random() * 10) + 1;
        System.out.println(Hospital.getReport(Hospital.generatePatientsTemperatures(patientsCount)));
    }
}