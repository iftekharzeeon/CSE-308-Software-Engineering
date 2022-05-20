package Accounts;

import Bank.Bank;

public class FixedDeposit extends Accounts {


    public FixedDeposit() {
        this.accountType = "Fixed Deposit";
    }

    @Override
    protected boolean createAccount(String name, double amount) {

        if (amount >= 100000) {
            this.name = name;
            this.depositedAmount = amount;

            System.out.println("Fixed Deposit account for " + name + " created; initial balance " + amount + "$");

            return true;
        } else {
            return false;
        }
    }

    @Override
    protected boolean deposit(double amount) {
        if (amount >= 50000) {
            this.name += amount;
            System.out.println(amount + "$ deposited, current balance " + this.depositedAmount + "$");

            return true;
        }
        return false;
    }

    @Override
    protected boolean requestLoan(double amount) {
        if (amount <= 100000) {
            if ((amount + this.requestLoanAmount + this.loanAmount) <= 100000) {
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
        if (Bank.clockYear >= 1) {
            if (this.depositedAmount < amount) {
                //Not enough money remaining
                System.out.println("Invalid transaction; current balance " + this.depositedAmount + "$");
                return false;
            } else {
                this.depositedAmount -= amount;
                System.out.println(this.depositedAmount + "$ withdrawn successfully, current balance " + this.depositedAmount + "$");
                return true;
            }
        } else {
            System.out.println("Invalid transaction. The account is not matured yet.");
            return false;
        }
    }
}
