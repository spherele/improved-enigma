import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main{
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("LIST")) {
                System.out.println(phoneBook.listContacts());
            }

            else {
                Pattern phonePattern = Pattern.compile("^((\\+7|7|8)\\d{10})$");
                Matcher phoneMatcher = phonePattern.matcher(input);

                if (phoneMatcher.matches()) {
                    String name = phoneBook.getNameByPhone(input);

                    if (name != null) {
                        System.out.println(name);
                    }

                    else {
                        System.out.println("Такого номера нет в телефонной книге.");
                        System.out.println("Введите имя абонента для номера \"" + input + "\":");
                        String nameInput = scanner.nextLine().trim();
                        phoneBook.addContact(nameInput, input);
                        System.out.println("Контакт сохранен!");
                    }
                }

                else {
                    Pattern namePattern = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]+(\\s[а-яА-ЯёЁa-zA-Z]+)*$");
                    Matcher nameMatcher = namePattern.matcher(input);

                    if (nameMatcher.matches()) {
                        ArrayList<String> phones = phoneBook.getPhonesByName(input);

                        if (phones != null) {
                            System.out.println(String.join(", ", phones));
                        }
                        else {
                            System.out.println("Такого имени в телефонной книге нет.");
                            System.out.println("Введите номер телефона для абонента \"" + input + "\":");
                            String phoneInput = scanner.nextLine().trim();

                            if (phoneBook.isPhoneExists(phoneInput)) {
                                System.out.println("Контакт с таким номером уже существует.");
                            }
                            else {
                                phoneBook.addContact(input, phoneInput);
                                System.out.println("Контакт сохранен!");
                            }
                        }
                    }

                    else {
                        System.out.println("Неверный формат ввода.");
                    }
                }
            }
        }
    }
}