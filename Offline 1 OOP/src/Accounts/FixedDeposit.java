package Accounts;

public class FixedDeposit extends Accounts {

    private final double minimumDepositAmount;
    private final double minimumCreatingAmount;

    public FixedDeposit(String accountName, double amount, String accountType, Double maximumLoanRequest) {
        super(accountName, amount, 0, 0, accountType, maximumLoanRequest);

        minimumCreatingAmount = 100000;
        minimumDepositAmount = 50000;
    }

    @Override
    protected boolean createAccount(String name, double amount) {

        if (amount >= minimumCreatingAmount) {

            System.out.println("Fixed Deposit account for " + name + " created; initial balance " + amount + "$");

            return true;
        } else {
            return false;
        }
    }

    @Override
    protected boolean deposit(double amount) {
        if (amount >= minimumDepositAmount) {
            double newAmount = this.getDepositedAmount() + amount;
            this.setDepositedAmount(newAmount);
            System.out.println(amount + "$ deposited, current balance " + this.getDepositedAmount() + "$");
            return true;
        }
        System.out.println("Invalid transaction. Minimum amount to deposit is " + minimumDepositAmount + "$");
        return false;
    }

    @Override
    protected boolean withdraw(double amount) {
        if (this.getMaturityYear() >= 1) {
            if (this.getDepositedAmount() < amount) {
                //Not enough money remaining
                System.out.println("Invalid transaction; current balance " + this.getDepositedAmount() + "$");
                return false;
            } else {
                this.setDepositedAmount(this.getDepositedAmount() - amount);
                System.out.println(amount + "$ withdrawn successfully, current balance " + this.getDepositedAmount() + "$");
                return true;
            }
        } else {
            System.out.println("Invalid transaction. The account is not matured yet. Current Balance " + this.getDepositedAmount());
            return false;
        }
    }
}
