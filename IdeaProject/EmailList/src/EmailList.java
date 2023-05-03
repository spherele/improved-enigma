import java.util.TreeSet;
public class EmailList {
    TreeSet<String> emails = new TreeSet<>();
    public void listEmails(){
        for (String email : emails){
            System.out.println(email);
        }
    }

    public void addEmails(String email){
        emails.add(email);
        System.out.println("Добавлена почта " + email);
    }
}
