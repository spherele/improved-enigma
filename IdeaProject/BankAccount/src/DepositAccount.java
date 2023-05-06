import java.time.LocalDate;

public class DepositAccount extends BankAccount{
    private LocalDate lastIncome;

    @Override
    public void put(double amountToPut) {
        if (amountToPut > 0) {
            amount = amount + amountToPut;
            lastIncome = LocalDate.now();
        }
    }

    @Override
    public void take(double amountToTake) {
        LocalDate oneMonthAfterLastIncome = lastIncome.plusMonths(1);
        if (amountToTake <= amount && LocalDate.now().isAfter(oneMonthAfterLastIncome)) {
            amount = amount - amountToTake;
            lastIncome = oneMonthAfterLastIncome;
        }
    }
}
