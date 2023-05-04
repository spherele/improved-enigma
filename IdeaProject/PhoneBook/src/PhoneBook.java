import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void addContact(String name, String phone) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new ArrayList<>());
        }
        phoneBook.get(name).add(phone);
    }

    public ArrayList<String> getPhonesByName(String name) {
        return phoneBook.get(name);
    }

    public String getNameByPhone(String phone) {
        for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phone)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String listContacts() {
        ArrayList<String> names = new ArrayList<>(phoneBook.keySet());
        StringBuilder result = new StringBuilder();
        for (String name : names) {
            result.append(name).append(" - ");
            ArrayList<String> phones = phoneBook.get(name);
            result.append(String.join(", ", phones)).append("\n");
        }
        return result.toString();
    }
    public boolean isPhoneExists(String phoneInput) {
        for (ArrayList<String> phones : phoneBook.values()) {
            if (phones.contains(phoneInput)) {
                return true;
            }
        }
        return false;
    }
}