import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Введите команду : ");
            String[] command = scanner.nextLine().split(" ");

            if (command[0].equals("q")) break;

            else if (command[0].equals("LIST")){
                toDoList.listToDoList();
            }

            else if (command[0].equals("ADD")) {
                if (command.length < 2) {
                    System.out.println("Введите название дела");
                } else if (command.length == 2) {
                    toDoList.addToDoList(command[1]);
                } else {
                    try {
                        int index = Integer.parseInt(command[1]);
                        String todo = command[2];
                        toDoList.addToDoListByIndex(index, todo);
                    } catch (NumberFormatException e) {
                        System.out.println("Указан некорректный номер индекса");
                    }
                }
            }

            else if (command[0].equals("EDIT")) {
                if (command.length < 3) {
                    System.out.println("Введите индекс дела и новое название");
                }
                else {
                    try {
                        int index = Integer.parseInt(command[1]);
                        String todo = command[2];
                        toDoList.editToDoListByIndex(index, todo);
                    } catch (NumberFormatException e) {
                        System.out.println("Указан некорректный номер индекса");
                    }
                }
            }

            else if (command[0].equals("DELETE")) {
                if (command.length < 2) {
                    System.out.println("Введите номер дела");
                } else {
                    try {
                        int index = Integer.parseInt(command[1]);
                        toDoList.deleteToDoList(index);
                    } catch (NumberFormatException e) {
                        System.out.println("Указан некорректный номер индекса");
                    }
                }
            }
        }
    }
}