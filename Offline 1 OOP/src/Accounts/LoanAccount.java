package Accounts;

public class LoanAccount extends Accounts {

    public LoanAccount(String accountName, double loanAmount, String accountType, Double maximumLoanRequest) {
        super(accountName, 0, loanAmount, 0, accountType, maximumLoanRequest);
    }

    @Override
    protected boolean createAccount(String name, double amount) {

        System.out.println("Loan account for " + name + " created; initial loan " + amount + "$");

        return true;
    }

    @Override
    protected boolean deposit(double amount) {
        if (this.getLoanAmount() < amount) {
            //Loan amount is lesser
            double returnAmount = amount - this.getLoanAmount();
            this.setLoanAmount(0);
            System.out.println("Your loan fully repaid. Current loan amount " + this.getLoanAmount() + "$. " + returnAmount + "$ is returned.");
            return true;
        } else {
            double newAmount = this.getLoanAmount() - amount;
            this.setDepositedAmount(newAmount);
            System.out.println("You have repaid " + amount + "$. Current loan amount " + this.getLoanAmount());
            return true;
        }
    }

    @Override
    protected boolean requestLoan(double amount) {
        if (this.getRequestLoanAmount() == 0) {
            if (this.getLoanAmount() * this.getMaximumLoanRequest() >= amount) {
                this.setRequestLoanAmount(amount);
                return true;
            }
        }
        //Not allowed
        return false;
    }

    @Override
    protected boolean withdraw(double amount) {
        System.out.println("Invalid transaction. This is a loan account.");
        return false;
    }

    @Override
    protected void query() {
        System.out.println("Current loan amount " + this.getLoanAmount() + "$");
    }
}
