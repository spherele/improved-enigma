package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] words = new Scanner(System.in).nextLine().split(" ");
        System.out.println(Arrays.toString(ReverseArray.reverseArray(words))
                .replaceAll("[\\[\\],]+", ""));
    }
}