package Accounts;

public class SavingsAccount extends Accounts {

    public SavingsAccount() {
        this.accountType = "Savings";
    }

    @Override
    protected boolean createAccount(String name, double amount) {
        this.name = name;
        this.depositedAmount = amount;

        System.out.println("Savings account for " + name + " created; initial balance " + amount + "$");

        return true;
    }

    @Override
    protected boolean deposit(double amount) {
        this.depositedAmount += amount;
        System.out.println(amount + "$ deposited, current balance " + this.depositedAmount + "$");
        return true;
    }

    @Override
    protected boolean requestLoan(double amount) {
        if (amount <= 10000) {
            if ((amount + this.requestLoanAmount + this.loanAmount) <= 10000) {
                this.requestLoanAmount += amount;
                return true;
            } else {
                //Not allowed
                return false;
            }
        } else {
            //Not allowed
            return false;
        }
    }

    @Override
    protected boolean withdraw(double amount) {
        if (this.depositedAmount < amount) {
            //Not enough money remaining
            System.out.println("Invalid transaction; current balance " + this.depositedAmount + "$");
            return false;
        } else {
            if ((this.depositedAmount - amount) < 1000) {
                System.out.println("Invalid transaction; can not remain less than 1000; current balance " + this.depositedAmount + "$");
                return false;
            } else {
                this.depositedAmount -= amount;
                System.out.println(this.depositedAmount + "$ withdrawn successfully, current balance " + this.depositedAmount + "$");
                return true;
            }
        }
    }
}
