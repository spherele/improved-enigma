import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 0; i < 180; i++){
            company.hire(new Operator());
        }
        for (int i = 0; i < 80; i++){
            company.hire(new Manager());
        }
        for (int i = 0; i < 10; i++){
            company.hire(new TopManager(company));
        }

        company.generateIncome();

        // Вывод списка самых высоких зарплат
        System.out.println("Top salaries:");
        List<Employee> topSalaries = company.getTopSalaryStaff(15);
        for (Employee topSalary : topSalaries) {
            System.out.println(topSalary.getMonthSalary());
        }

        // Вывод списка самых низких зарплат
        System.out.println("\nLowest salaries:");
        List<Employee> lowestSalaries = company.getLowSalaryStaff(15);
        for (Employee lowestSalary : lowestSalaries) {
            System.out.println(lowestSalary.getMonthSalary());
        }
    }
}