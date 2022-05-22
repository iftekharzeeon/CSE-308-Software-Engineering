package Accounts;

abstract class Accounts {
    private String name;
    private double depositedAmount;
    private double loanAmount;
    private double requestLoanAmount;
    private String accountType;
    private int maturityYear;

    private final double maximumLoanRequest;

    public Accounts(String name, double depositedAmount, double loanAmount, double requestLoanAmount, String accountType, double maximumLoanRequest) {
        this.name = name;
        this.depositedAmount = depositedAmount;
        this.loanAmount = loanAmount;
        this.requestLoanAmount = requestLoanAmount;
        this.accountType = accountType;
        this.maximumLoanRequest = maximumLoanRequest;
        this.maturityYear = 0;
    }

    protected abstract boolean createAccount(String name, double amount);
    protected abstract boolean deposit(double amount);

    protected boolean requestLoan(double amount) {
        if (amount <= this.maximumLoanRequest) {
            if (this.getRequestLoanAmount() == 0) {
                if (amount + this.getLoanAmount() <= this.maximumLoanRequest) {
                    this.setRequestLoanAmount(amount);
                    return true;
                }
            }
        }
        //Not allowed
        return false;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public double getDepositedAmount() {
        return depositedAmount;
    }

    public void setDepositedAmount(double depositedAmount) {
        this.depositedAmount = depositedAmount;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getRequestLoanAmount() {
        return requestLoanAmount;
    }

    public void setRequestLoanAmount(double requestLoanAmount) {
        this.requestLoanAmount = requestLoanAmount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getMaturityYear() {
        return maturityYear;
    }

    public void increaseMaturityYear() {
        this.maturityYear++;
    }

    public double getMaximumLoanRequest() {
        return maximumLoanRequest;
    }
}
