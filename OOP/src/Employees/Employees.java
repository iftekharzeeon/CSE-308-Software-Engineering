package Employees;

import Accounts.AccountOperation;

public interface Employees {
    void lookUp(String name, AccountOperation accountOperation);
    void approveLoan(AccountOperation accountOperation);
    void changeInterestRate(String accountType, double newRate, AccountOperation accountOperation);
    void see();
}
