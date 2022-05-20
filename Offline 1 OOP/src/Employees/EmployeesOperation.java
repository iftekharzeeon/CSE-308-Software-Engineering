package Employees;

import Accounts.AccountOperation;
import Bank.Bank;

public class EmployeesOperation {
    private String activeEmployee = null;

    public EmployeesOperation() {

        Employees md = new ManagingDirector();
        Employees s1 = new Officer();
        Employees s2 = new Officer();
        Employees c1 = new Cashier();
        Employees c2 = new Cashier();
        Employees c3 = new Cashier();
        Employees c4 = new Cashier();
        Employees c5 = new Cashier();

        Bank.personList.put("MD", md);
        Bank.personList.put("S1", s1);
        Bank.personList.put("S2", s2);
        Bank.personList.put("C1", c1);
        Bank.personList.put("C2", c2);
        Bank.personList.put("C3", c3);
        Bank.personList.put("C4", c4);
        Bank.personList.put("C5", c5);

        System.out.println("Original.Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created");
    }

    public void transactionOpen(String name, AccountOperation accountOperation) {
        activeEmployee = name;
        Employees employee = (Employees) Bank.personList.get(name);

        if (employee instanceof ManagingDirector || employee instanceof Officer) {
            if (accountOperation.isLoanRequestActive()) {
                System.out.println(name + " active, there are loan approvals pending.");
            } else {
                System.out.println(name + " active");
            }
        } else {
            System.out.println(name + " active");
        }
    }

    public void lookup(String name, AccountOperation accountOperation) {
        Employees employee = (Employees) Bank.personList.get(activeEmployee);
        employee.lookUp(name, accountOperation);
    }

    public void see() {
        Employees employee = (Employees) Bank.personList.get(activeEmployee);
        employee.see();
    }

    public void changeRate(String accountType, double newRate, AccountOperation accountOperation) {
        Employees employee = (Employees) Bank.personList.get(activeEmployee);
        employee.changeInterestRate(accountType, newRate, accountOperation);
    }

    public void approveLoan(AccountOperation accountOperation) {
        Employees employee = (Employees) Bank.personList.get(activeEmployee);
        employee.approveLoan(accountOperation);
    }

    public void transactionClose() {
        if (this.activeEmployee != null) {
            System.out.println("Operations for " + this.activeEmployee + " closed.");
            this.activeEmployee = null;
        }
    }
}
