package org.example;

import java.util.Arrays;

public class SplitText {
    public static String splitText (String text) {
        String clearedText = text.strip().replaceAll("\\s+", " ");
        if (clearedText.isEmpty() || clearedText.equals(" ")) return "";

        String[] words = clearedText.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words){
            sb.append(String.join(" ", word.split("\\s+"))).append("\n");
        }
        return sb.toString();
    }
}
