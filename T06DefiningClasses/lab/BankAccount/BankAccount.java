package T06DefiningClasses.lab.BankAccount;

public class BankAccount {
    private static int accountNextId = 1;
    private static double interestRate = 0.02;
    private int id;
    private double balance;


    public BankAccount() {
        this.id = accountNextId;
        accountNextId++;
    }

    public int getId() {
        return id;
    }
    // this could be called from the class itself, not the instance
    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;//for not static methods we cannot use this
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
