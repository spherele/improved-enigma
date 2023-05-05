import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> coolNumbers = CoolNumbers.generationCoolNumbers();
        Collections.sort(coolNumbers);
        System.out.println(coolNumbers.size());
        String number = "А777СУ01";

        CoolNumbers.BruteSearch(coolNumbers, number);
        CoolNumbers.BinarySearch(coolNumbers, number);
        CoolNumbers.HashSetSearch(new HashSet<>(coolNumbers), number);
        CoolNumbers.TreeSetSearch(new TreeSet<>(coolNumbers), number);
    }
}