import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

class Company {
    private final List<Employee> employees;
    private int income;
    public Company(){
        employees = new ArrayList<>();
    }

    public void hire(Employee employee){
        employees.add(employee);
    }
    public void hireAll(Collection<Employee> employees){
        this.employees.addAll(employees);
    }
    public void fire(Employee employee){
        employees.remove(employee);
    }
    public double getIncome(){
        return income;
    }
    public void generateIncome(){
        this.income = (int) (Math.random() * (20_000_000 - 10_000_000) + 10_000_000);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        sortedEmployees.sort(Comparator.comparingDouble(Employee::getMonthSalary).reversed());
        return sortedEmployees.subList(0, Math.min(count, sortedEmployees.size()));
    }

    public List<Employee> getLowSalaryStaff(int count){
        if (count < 0 || count > employees.size()) count = employees.size();
        List<Employee> lowSalaryStaff = new ArrayList<>(employees);
        lowSalaryStaff.sort(Comparator.comparingInt(Employee::getMonthSalary));
        return lowSalaryStaff.subList(0, count);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
