package Accounts;

public class StudentAccount extends Accounts {

    private final double maximumWithdrawAmount;

    public StudentAccount(String accountName, double amount, String accountType, Double maximumLoanRequest) {
        super(accountName, amount, 0, 0, accountType, maximumLoanRequest);
        maximumWithdrawAmount = 10000;
    }

    @Override
    protected boolean createAccount(String name, double amount) {

        System.out.println("Student account for " + name + " created; initial balance " + amount + "$");
        return true;
    }

    @Override
    protected boolean deposit(double amount) {
        double newAmount = this.getDepositedAmount() + amount;
        this.setDepositedAmount(newAmount);
        System.out.println(amount + "$ deposited, current balance " + this.getDepositedAmount() + "$");
        return true;
    }

    @Override
    protected boolean withdraw(double amount) {
        if (amount > maximumWithdrawAmount) {
            System.out.println("Invalid transaction; current balance " + this.getDepositedAmount() + "$");
            return false;
        } else {
            if (this.getDepositedAmount() < amount) {
                //Not enough money remaining
                System.out.println("Invalid transaction; current balance " + this.getDepositedAmount() + "$");
                return false;
            } else {
                this.setDepositedAmount(this.getDepositedAmount() - amount);
                System.out.println(amount + "$ withdrawn successfully, current balance " + this.getDepositedAmount() + "$");
                return true;
            }
        }
    }
}
