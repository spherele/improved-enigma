import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmailList emailList = new EmailList();

        while (true){
            String input = new Scanner(System.in).nextLine();

            if (input.equals("q")) break;

            if (input.equals("LIST")){
                emailList.listEmails();
            }
            else if (input.startsWith("ADD")) {
                String[] parts = input.split(" ");
                if (parts.length < 2){
                    System.out.println("Не указан адрес почты");
                } else {
                    String email = parts[1];
                    if (email.matches(
                            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*" +
                            "@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*" +
                            "(\\.[A-Za-z]{2,6})$")) {
                        emailList.addEmails(email);
                    } else {
                        System.out.println("Адрес электронной почты некорректен.");
                    }
                }

            }
            else System.out.println("Команда не распознана");
        }
    }
}