package Bank;

import Accounts.AccountOperation;
import Employees.Employees;
import Employees.EmployeesOperation;

import java.util.HashMap;
import java.util.Scanner;

public class Bank {

    private static Bank bank = null;

    private static boolean isTransactionOpen;
    private final AccountOperation accountOperation;
    private final EmployeesOperation employeesOperation;
    private double internalFund;

    public static HashMap<String, Object> personList;
    public static int clockYear = 0;
    public static double loanInterestRate;
    public static double serviceCharge;
    public static HashMap<String, Double> accountsInterest;

    private Bank() {

        isTransactionOpen = false;
        this.internalFund = 1000000;
        serviceCharge = 500;
        loanInterestRate = 0.1;

        personList = new HashMap<>();
        accountsInterest = new HashMap<>();

        accountOperation = new AccountOperation();
        employeesOperation = new EmployeesOperation();

        double savingsInterestRate = 0.1;
        accountsInterest.put("Savings", savingsInterestRate);
        double studentInterestRate = 0.05;
        accountsInterest.put("Student", studentInterestRate);
        double fixedDepositInterestRate = 0.15;
        accountsInterest.put("Fixed Deposit", fixedDepositInterestRate);
    }

    public static Bank getInstance() {

        return bank;
    }

    public static void run() {
        bank = new Bank();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your command.");

        while (true) {
            String inputLine = scanner.nextLine();
            String[] input = inputLine.split(" ");

            if (input[0].equalsIgnoreCase("Create")) {
                if (isTransactionOpen) {
                    //One transaction is still open
                    System.out.println("Invalid request. One transaction is still open.");

                } else {
                    isTransactionOpen = true;

                    String accountName = input[1];
                    String accountType = input[2];
                    double amount = Double.parseDouble(input[3]);

                    bank.createAccount(accountName, amount, accountType);
                }
            } else if(input[0].equalsIgnoreCase("Deposit")) {
                if (isTransactionOpen) {

                    double amount = Double.parseDouble(input[1]);

                    bank.deposit(amount);

                } else {
                    //Transaction is closed now
                    System.out.println("Invalid request. No transaction is open now.");
                }
            } else if (input[0].equalsIgnoreCase("Withdraw")) {
                if (isTransactionOpen) {

                    double amount = Double.parseDouble(input[1]);

                    bank.withdraw(amount);

                } else {
                    //Transaction is closed now
                    System.out.println("Invalid request. No transaction is open now.");
                }
            } else if (input[0].equalsIgnoreCase("Query")) {
                if (isTransactionOpen) {

                    bank.query();

                } else {
                    //Transaction is closed now
                    System.out.println("Invalid request. No transaction is open now.");
                }
            } else if (input[0].equalsIgnoreCase("Close")) {
                if (isTransactionOpen) {

                    bank.close();

                } else {
                    //Transaction is closed now
                    System.out.println("Invalid request. No transaction is open now.");
                }
            } else if (input[0].equalsIgnoreCase("Request")) {
                if (isTransactionOpen) {

                    double amount = Double.parseDouble(input[1]);

                    bank.requestLoan(amount);

                } else {
                    //Transaction is closed now
                    System.out.println("Invalid request. No transaction is open now.");
                }
            } else if (input[0].equalsIgnoreCase("Open")) {
                if (isTransactionOpen) {
                    //A Transaction is open
                    System.out.println("Invalid request. One transaction is still open.");
                } else {
                    String name = input[1];
                    bank.openTransaction(name);
                }
            } else if (input[0].equalsIgnoreCase("Lookup")) {
                if (isTransactionOpen) {

                    String accountName = input[1];

                    bank.lookup(accountName);

                } else {
                    //Transaction is closed now
                    System.out.println("Invalid request. No transaction is open now.");
                }
            } else if (input[0].equalsIgnoreCase("See")) {
                if (isTransactionOpen) {

                    bank.see();

                } else {
                    //Transaction is closed now
                    System.out.println("Invalid request. No transaction is open now.");
                }

            } else if (input[0].equalsIgnoreCase("Change")) {
                if (isTransactionOpen) {
                    String accountType = input[1];
                    double newInterestRate = Double.parseDouble(input[2]);

                    bank.changeRate(accountType, newInterestRate);
                } else {
                    //Transaction is closed
                    System.out.println("Invalid request. No transaction is open now.");
                }

            } else if (input[0].equalsIgnoreCase("Approve")) {
                if (isTransactionOpen) {

                    bank.approveLoan();
                } else {
                    //Transaction is closed
                    System.out.println("Invalid request. No transaction is open now.");
                }

            } else if (input[0].equalsIgnoreCase("INC")) {
                if (isTransactionOpen) {
                    //Transaction is open now
                    System.out.println("Invalid request. One transaction is still open.");
                } else {
                    bank.increaseYear();
                }
            } else if (input[0].equalsIgnoreCase("Exit")) {
                System.out.println("Bank Closed");
                break;
            }
        }
    }

    private void createAccount(String accountName, double amount, String accountType) {
        accountOperation.createAccount(accountName, amount, accountType);
    }

    private void deposit(double amount) {
        accountOperation.deposit(amount);
    }

    private void withdraw(double amount) {
        accountOperation.withdraw(amount);
    }

    private void requestLoan(double amount) {
        accountOperation.requestLoan(amount);
    }

    private void query() {
        accountOperation.query();
    }

    private void close() {
        isTransactionOpen = false;
        accountOperation.transactionClose();
        employeesOperation.transactionClose();
    }

    private void openTransaction(String accountName) {
        if (personList.containsKey(accountName)) {
            isTransactionOpen = true;
            Object object = personList.get(accountName);

            if (object instanceof Employees) {
                employeesOperation.transactionOpen(accountName, accountOperation);
            } else {
                accountOperation.transactionOpen(accountName);
            }

        } else {
            System.out.println("Invalid user. Login failed.");
        }

    }

    private void lookup(String accountName) {
        employeesOperation.lookup(accountName, this.accountOperation);
    }

    private void see() {
        employeesOperation.see();
    }

    public double getInternalFund() {
        return this.internalFund;
    }

    private void increaseYear() {
        clockYear++;
        accountOperation.increaseYear();
    }

    private void changeRate(String accountType, double newRate) {
        employeesOperation.changeRate(accountType, newRate, this.accountOperation);
    }

    public void increaseInternalFund(double amount) {
        this.internalFund += amount;
    }

    public void decreaseInternalFund(double amount) {
        this.internalFund -= amount;
    }

    public void approveLoan() {
        employeesOperation.approveLoan(accountOperation);
    }
}
