package Employees;

import Accounts.AccountOperation;
import Bank.Bank;

public class ManagingDirector implements Employees {
    @Override
    public void lookUp(String name,  AccountOperation accountOperation) {
        accountOperation.lookup(name);
    }

    @Override
    public void approveLoan(AccountOperation accountOperation) {
        accountOperation.approveLoan();
    }

    @Override
    public void changeInterestRate(String accountType, double newRate, AccountOperation accountOperation) {
        accountOperation.changeRate(accountType, newRate);
    }

    @Override
    public void see() {
        System.out.println("Bank's Internal Fund " + Bank.getInstance().getInternalFund() + "$");
    }
}
