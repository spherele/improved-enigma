import java.util.Scanner;

public class BankAccount {
    protected double amount = new Scanner(System.in).nextDouble();

    public  double getAmount(){
        return amount;
    }
    public void put(double amountToPut){
        if (amountToPut > 0) amount += amountToPut;
    }

    public void take(double amountToTake){
        if (amountToTake <= amount) amount -= amountToTake;
    }
}
