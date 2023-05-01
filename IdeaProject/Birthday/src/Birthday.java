import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthday {
    public static String collectBirthdays(int year, int month, int day){
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.getDefault());


        StringBuilder stringBuilder = new StringBuilder();
        int dateDifference = currentDate.getYear() - birthday.getYear();

        for (int i = 0; i < dateDifference; i++){
            LocalDate date = birthday.plusYears(i);
            String formattedDate = date.format(formatter);
            stringBuilder.append(i).append(" - ").append(formattedDate).append("\n");
        }
        return stringBuilder.toString();
    }
}
