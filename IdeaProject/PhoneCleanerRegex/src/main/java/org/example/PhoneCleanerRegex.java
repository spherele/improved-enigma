package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneCleanerRegex {
    public static void phoneNumber(String phone){
        String clearedPhone = phone.replaceAll("[^0-9]+", "");
        String pattern = "^[+?7-8]\\d{10}$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(clearedPhone);

        if (m.find()){
            if (clearedPhone.length() == 11 && clearedPhone.charAt(0) == '8'){
                clearedPhone = '7' + clearedPhone.substring(1);
            }
            System.out.println(clearedPhone);
        }
        else System.out.println("Неверный формат номера");
    }
}
