import java.util.ArrayList;

public class ToDoList {
    ArrayList<String> toDoList = new ArrayList<String>();
    public void listToDoList(){
        if (toDoList.isEmpty()) System.out.println("Список дел пуст");
        else {
            for (int i = 0; i < toDoList.size(); i++){
                System.out.println(i + " - " + toDoList.get(i));
            }
        }
    }
    public void addToDoList(String toDo){
        toDoList.add(toDo);
        System.out.println("Добавлено дело : " + toDo);
    }
    public void addToDoListByIndex(int index, String toDo){
        if (index < 0 || index > toDoList.size()) addToDoList(toDo);
        else {
            toDoList.add(index, toDo);
            System.out.println("Добавлено дело : " + toDo);
        }
    }
    public void editToDoListByIndex(int index, String toDo){
        if (index < 0 || index > toDoList.size())
            System.out.println("Дела с таким номером не существует");
        else {
            String oldToDo = toDoList.get(index);
            toDoList.set(index, toDo);
            System.out.println("Заменено дело : " + oldToDo + " на " + toDoList.get(index));
        }
    }
    public void deleteToDoList(int index){
        if (index < 0 || index > toDoList.size())
            System.out.println("Дела с таким номером не существует");
        else {
            String toDo = toDoList.get(index);
            toDoList.remove(index);
            System.out.println("Удалено дело : " + toDo);
        }
    }
}
