public class CardAccount extends BankAccount {

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake * 1.01);
    }
}
