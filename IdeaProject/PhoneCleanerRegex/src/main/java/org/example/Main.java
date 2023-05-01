package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String phone = new Scanner(System.in).nextLine();
        PhoneCleanerRegex.phoneNumber(phone);
    }
}