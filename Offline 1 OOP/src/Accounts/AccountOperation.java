package Accounts;

import Bank.Bank;

public class AccountOperation {

    public String activeUser = "";
    private boolean loanRequestActive;

    public AccountOperation() {

        this.loanRequestActive = false;
    }

    public void createAccount(String accountName, double amount, String accountType) {
        if (Bank.personList.containsKey(accountName)) {
            System.out.println("Account already exists.");
        } else {
            switch (accountType) {
                case "Student":
                    Accounts studentAccount = new StudentAccount(accountName, amount, accountType, Bank.maximumAllowableLoanRequest.get(accountType));
                    if (studentAccount.createAccount(accountName, amount)) {
                        Bank.personList.put(accountName, studentAccount);
                        this.activeUser = accountName;
                        Bank.getInstance().increaseInternalFund(amount);
                    } else {
                        System.out.println("Error creating the account.");
                    }
                    break;

                case "Loan":
                    Accounts loanAccount = new LoanAccount(accountName, amount, accountType, Bank.maximumAllowableLoanRequest.get(accountType));
                    if (loanAccount.createAccount(accountName, amount)) {
                        Bank.personList.put(accountName, loanAccount);
                        this.activeUser = accountName;
                        Bank.getInstance().decreaseInternalFund(amount);
                    } else {
                        System.out.println("Error creating the account.");
                    }
                    break;

                case "Fixed-Deposit":
                    Accounts fixedDepAccount = new FixedDeposit(accountName, amount, accountType, Bank.maximumAllowableLoanRequest.get(accountType));
                    if (fixedDepAccount.createAccount(accountName, amount)) {
                        Bank.personList.put(accountName, fixedDepAccount);
                        this.activeUser = accountName;
                        Bank.getInstance().increaseInternalFund(amount);
                    } else {
                        System.out.println("Error creating the account.");
                    }

                    break;

                case "Savings":
                    Accounts savingAccount = new SavingsAccount(accountName, amount, accountType, Bank.maximumAllowableLoanRequest.get(accountType));
                    if (savingAccount.createAccount(accountName, amount)) {
                        Bank.personList.put(accountName, savingAccount);
                        this.activeUser = accountName;
                        Bank.getInstance().increaseInternalFund(amount);
                    } else {
                        System.out.println("Error creating the account.");
                    }
                default:
                    System.out.println("Invalid account type.");
            }
        }
    }

    public void deposit(double amount) {
        Accounts account = (Accounts) Bank.personList.get(activeUser);
        if (account.deposit(amount)) {
            Bank.getInstance().increaseInternalFund(amount);
        }
    }

    public void withdraw(double amount) {
        Accounts account = (Accounts) Bank.personList.get(activeUser);
        if (account.withdraw(amount)) {
            Bank.getInstance().decreaseInternalFund(amount);
        }
    }

    public void requestLoan(double amount) {
        Accounts account = (Accounts) Bank.personList.get(activeUser);
        if (account.requestLoan(amount)) {
            this.loanRequestActive = true;
            System.out.println("Loan request successful, sent for approval.");
        } else {
            System.out.println("Loan request unsuccessful.");
        }
    }

    public void query() {
        Accounts account = (Accounts) Bank.personList.get(activeUser);
        account.query();
    }

    public void transactionClose() {
        if (this.activeUser != null) {
            System.out.println("Transaction Closed for " + this.activeUser);
            this.activeUser = null;
        }
    }

    public void transactionOpen(String name) {
        activeUser = name;
        System.out.println("Welcome back, " + name);
    }

    public void increaseYear() {
        for (Object object :  Bank.personList.values()) {
            if (object instanceof Accounts) {
                Accounts account = (Accounts) object;
                if (object instanceof LoanAccount) {
                    double changedAmount = account.getLoanAmount() * Bank.loanInterestRate;
                    account.setLoanAmount(account.getLoanAmount() + changedAmount);
                    Bank.getInstance().increaseInternalFund(changedAmount);
                } else {
                    Double interestRate = Bank.accountsInterest.get(account.getAccountType());
                    double changedAmount = account.getDepositedAmount() * interestRate - (account.getLoanAmount() * Bank.loanInterestRate + Bank.serviceCharge);
                    account.setDepositedAmount(account.getDepositedAmount() + changedAmount);
                    Bank.getInstance().increaseInternalFund(changedAmount);
                }
                account.increaseMaturityYear();
            }
        }
        System.out.println("1 year passed");
    }

    public void lookup(String accountName) {
        Accounts account = (Accounts) Bank.personList.get(accountName);
        account.getDepositedBalance();
    }

    public void changeRate(String accountType, double newRate) {
        Bank.accountsInterest.put(accountType, newRate);
        System.out.println("Interest rate changed for " + accountType + ". New rate " + newRate + "%");
    }

    public boolean isLoanRequestActive() {
        return loanRequestActive;
    }

    public void approveLoan() {
        StringBuilder accountsName = new StringBuilder();
        for (Object object : Bank.personList.values()) {
            if (object instanceof Accounts) {
                Accounts account = (Accounts) object;
                if (account.getRequestLoanAmount() > 0) {
                    account.setLoanAmount(account.getLoanAmount() + account.getRequestLoanAmount());
                    account.setDepositedAmount(account.getDepositedAmount() + account.getLoanAmount());
                    Bank.getInstance().decreaseInternalFund(account.getRequestLoanAmount());
                    account.setRequestLoanAmount(0);
                    accountsName.append(account.getName()).append(" ");
                }
            }
        }
        System.out.println("Loan for " + accountsName + "approved");
    }

}
