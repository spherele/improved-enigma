import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()){
            int a = scanner.nextInt();
            if (scanner.hasNextInt()){
                int b = scanner.nextInt();
                System.out.println(sum(a, b));
                System.out.println(mul(a, b));
                System.out.println(max(a, b));
                System.out.println(min(a, b));
            }
            else System.out.println("n/a");
        }
        else System.out.println("n/a");
    }

    public static int sum(int a, int b){
        return a + b;
    }
    public static int mul(int a, int b){
        return a * b;
    }
    public static int max(int a, int b){
        return Math.max(a, b);
    }
    public static int min(int a, int b){
        return Math.min(a, b);
    }
}