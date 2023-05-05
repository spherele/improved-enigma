import java.util.*;

public class CoolNumbers {
    private static final List<String> LETTERS = Arrays.asList(
            "А", "В", "Е", "К",
            "М", "Н", "О", "Р",
            "С", "Т", "У", "Х");
    private static final List<String> NUMBERS = Arrays.asList(
            "111", "222", "333",
            "444", "555", "666",
            "777", "888", "999");

    public static List<String> generationCoolNumbers() {
        List<String> coolNumbers = new ArrayList<>();

        for (String letter1 : LETTERS) {
            for (String letter2 : LETTERS) {
                for (String letter3 : LETTERS) {
                    for (String number : NUMBERS) {
                        for (int region = 1; region <= 199; region++) {
                            String coolNumber = String.format("%s%s%s%s%02d", letter1, number, letter2, letter3, region);
                            coolNumbers.add(coolNumber);
                        }
                    }
                }
            }
        }
        return coolNumbers;
    }

    public static void BruteSearch(List<String> list, String number){
        long startTime = System.nanoTime();
        boolean result = list.contains(number);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("Поиск перебором : номер %s, поиск составил %d нс %n",
                result ? "найден" : "не найден", duration);
    }

    public static void BinarySearch(List<String> sortedlist, String number){
        long startTime = System.nanoTime();
        int index = Collections.binarySearch(sortedlist, number);
        boolean result = index >= 0;
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("Бинарный поиск : номер %s, поиск составил %d нс %n",
                result ? "найден" : "не найден", duration);
    }

    public static void HashSetSearch(HashSet<String> hashSet, String number){
        long startTime = System.nanoTime();
        boolean result = hashSet.contains(number);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("Поиск в HashSet : номер %s, поиск составил %d нс %n",
                result ? "найден" : "не найден", duration);
    }

    public static void TreeSetSearch(TreeSet<String> treeSet, String number){
        long startTime = System.nanoTime();
        boolean result = treeSet.contains(number);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("Поиск в TreeSet : номер %s, поиск составил %d нс %n",
                result ? "найден" : "не найден", duration);
    }
}