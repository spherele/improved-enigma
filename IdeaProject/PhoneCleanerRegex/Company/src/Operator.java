class Operator implements Employee{
    private final int salary;

    public Operator(){
        this.salary = (int) (Math.random() * (85000 - 45000) + 45000);
    }
    public int getMonthSalary(){
        return salary;
    }
}

