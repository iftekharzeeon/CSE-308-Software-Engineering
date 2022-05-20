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
                    Accounts studentAccount = new StudentAccount();
                    if (studentAccount.createAccount(accountName, amount)) {
                        Bank.personList.put(accountName, studentAccount);
                        this.activeUser = accountName;
                        Bank.getInstance().increaseInternalFund(amount);
                    } else {
                        System.out.println("Error creating the account.");
                    }
                    break;

                case "Loan":
                    Accounts loanAccount = new LoanAccount();
                    if (loanAccount.createAccount(accountName, amount)) {
                        Bank.personList.put(accountName, loanAccount);
                        this.activeUser = accountName;
                        Bank.getInstance().decreaseInternalFund(amount);
                    } else {
                        System.out.println("Error creating the account.");
                    }
                    break;

                case "Fixed Deposit":
                    Accounts fixedDepAccount = new FixedDeposit();
                    if (fixedDepAccount.createAccount(accountName, amount)) {
                        Bank.personList.put(accountName, fixedDepAccount);
                        this.activeUser = accountName;
                        Bank.getInstance().increaseInternalFund(amount);
                    } else {
                        System.out.println("Error creating the account.");
                    }

                    break;

                case "Savings":
                    Accounts savingAccount = new SavingsAccount();
                    if (savingAccount.createAccount(accountName, amount)) {
                        Bank.personList.put(accountName, savingAccount);
                        this.activeUser = accountName;
                        Bank.getInstance().increaseInternalFund(amount);
                    } else {
                        System.out.println("Error creating the account.");
                    }
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
                Double interestRate = Bank.accountsInterest.get(account.accountType);
                double changedAmount = account.depositedAmount * interestRate - (account.loanAmount * Bank.loanInterestRate + Bank.serviceCharge);
                account.depositedAmount += changedAmount;
                Bank.getInstance().increaseInternalFund(changedAmount);
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
    }

    public boolean isLoanRequestActive() {
        return loanRequestActive;
    }

    public void approveLoan() {
        StringBuilder accountsName = new StringBuilder();
        for (Object object : Bank.personList.values()) {
            if (object instanceof Accounts) {
                Accounts account = (Accounts) object;
                if (account.requestLoanAmount > 0) {
                    account.loanAmount += account.requestLoanAmount;
                    account.depositedAmount += account.loanAmount;
                    Bank.getInstance().decreaseInternalFund(account.requestLoanAmount);
                    account.requestLoanAmount = 0;
                    accountsName.append(account.getName()).append(" ");
                }
            }
        }
        System.out.println("Loan for " + accountsName + " approved");
    }

}
