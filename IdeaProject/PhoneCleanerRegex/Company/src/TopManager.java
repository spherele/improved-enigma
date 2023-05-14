class TopManager implements Employee {
    private static final int FIXED_SALARY = 100_000;
    private static final double BONUS_PERCENTAGE = 1.5;
    private final Company company;

    public TopManager(Company company){
        this.company = company;
    }

    public int getMonthSalary(){
        if (company.getIncome() > 10_000_000) return (int) (FIXED_SALARY * BONUS_PERCENTAGE);
        else return FIXED_SALARY;
    }
}
