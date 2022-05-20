package Accounts;

public class LoanAccount extends Accounts {

    public LoanAccount() {
        this.accountType = "Loan";
    }

    @Override
    protected boolean createAccount(String name, double amount) {
        this.name = name;
        this.loanAmount = amount;

        System.out.println("Student account for " + name + " created; initial loan " + amount + "$");

        return true;
    }

    @Override
    protected boolean deposit(double amount) {
        if (this.depositedAmount < amount) {
            //Loan amount is lesser
            return false;
        } else {
            this.depositedAmount -= amount;
            return true;
        }
    }

    @Override
    protected boolean requestLoan(double amount) {
        if (this.loanAmount * 0.05 >= (amount + this.requestLoanAmount)) {
            this.requestLoanAmount += amount;
            System.out.println("Loan request successful, sent for approval.");
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected boolean withdraw(double amount) {
        System.out.println("Invalid transaction. This is a loan account.");
        return false;
    }
}
