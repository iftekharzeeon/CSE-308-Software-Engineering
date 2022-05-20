package Employees;

import Accounts.AccountOperation;

public class Cashier implements Employees{

    @Override
    public void lookUp(String name, AccountOperation accountOperation) {
        accountOperation.lookup(name);
    }

    @Override
    public void approveLoan(AccountOperation accountOperation) {
        System.out.println("You don’t have permission for this operation");
    }

    @Override
    public void changeInterestRate(String accountType, double newRate, AccountOperation accountOperation) {
        System.out.println("You don’t have permission for this operation");
    }

    @Override
    public void see() {
        System.out.println("You don't have permission for this operation.");
    }
}
