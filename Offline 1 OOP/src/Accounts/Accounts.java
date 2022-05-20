package Accounts;

abstract class Accounts {
    protected String name;
    protected double depositedAmount;
    protected double loanAmount;
    protected double requestLoanAmount;
    protected String accountType;

    protected abstract boolean createAccount(String name, double amount);
    protected abstract boolean deposit(double amount);
    protected abstract boolean requestLoan(double amount);
    protected abstract boolean withdraw(double amount);

    protected void getDepositedBalance() {
        System.out.println(name + "'s current balance " + depositedAmount + "$");
    }
    protected void query() {
        if (this.loanAmount > 0) {
            System.out.println("Current balance " + this.depositedAmount + "$, loan " + this.loanAmount + "$");
        } else {
            System.out.println("Current balance " + this.depositedAmount + "$");
        }
    }

    protected String getName() {
        return this.name;
    }
}
