import java.util.ArrayList;
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
        System.out.println("Top salaries for employees: " + company.getEmployees().size());
        List<Employee> topSalaries = company.getTopSalaryStaff(15);
        for (Employee topSalary : topSalaries) {
            System.out.println(topSalary.getMonthSalary());
        }

        // Вывод списка самых низких зарплат
        System.out.println("\nLowest salaries for employees: " + company.getEmployees().size());
        List<Employee> lowestSalaries = company.getLowSalaryStaff(15);
        for (Employee lowestSalary : lowestSalaries) {
            System.out.println(lowestSalary.getMonthSalary());
        }



        int employeesToFire = company.getEmployees().size() / 2;
        List<Employee> currentEmployees = new ArrayList<>(company.getEmployees());
        for (int i = 0; i < employeesToFire; i++) {
            company.fire(currentEmployees.get(i));
        }

        // Вывод списка самых высоких зарплат после увольнения
        System.out.println("\nTop salaries after firing for employees: " + company.getEmployees().size());
        topSalaries = company.getTopSalaryStaff(15);
        for (Employee employee : topSalaries) {
            System.out.println(employee.getMonthSalary());
        }

        // Вывод списка самых низких зарплат после увольнения
        System.out.println("\nLowest salaries after firing for employees: " + company.getEmployees().size());
        lowestSalaries = company.getLowSalaryStaff(30);
        for (Employee employee : lowestSalaries) {
            System.out.println(employee.getMonthSalary());
        }
    }
}