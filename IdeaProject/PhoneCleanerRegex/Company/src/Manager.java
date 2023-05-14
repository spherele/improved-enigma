class Manager implements Employee{
    private static final int FIXED_SALARY = 50000;
    private static final double BONUS_PERCENTAGE = 0.5;
    private final double income;

    public Manager(){
        this.income = Math.random() * (140000 - 115000) + 115000;
    }
    public int getMonthSalary(){
        return (int) (FIXED_SALARY + income * BONUS_PERCENTAGE);
    }
}
