package org.example;

public class ReverseArray {
    public static String[] reverseArray(String[] words){
        String[] reverseArray = new String[words.length];
        for (int i = 0; i < words.length; i++){
            reverseArray[i] = words[words.length - 1 - i];
        }
        return new String[]{String.join(" ", reverseArray)};
    }
}
