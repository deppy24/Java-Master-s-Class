package Project2.Pro2.Exercise2;

public class BankAccount {
    private int accountNumber;
    private String holder;
    private double balance;

    /**
     * Κατασκευαστής για τον λογαριασμό τραπέζης.
     * Ελέγχει για αρνητικό αρχικό υπόλοιπο.
     */
    public BankAccount(int accountNumber, String holder, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Το αρχικό υπόλοιπο δεν μπορεί να είναι αρνητικό.");
        }
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Κατάθεση ποσού στον λογαριασμό.
     * Το ποσό πρέπει να είναι θετικό.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Το ποσό κατάθεσης πρέπει να είναι θετικό.");
        }
        balance += amount;
    }

    /**
     * Ανάληψη ποσού από τον λογαριασμό.
     * Το ποσό πρέπει να είναι θετικό και μικρότερο ή ίσο του υπολοίπου.
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Το ποσό ανάληψης πρέπει να είναι θετικό.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Ανεπαρκές υπόλοιπο για την ανάληψη.");
        }
        balance -= amount;
    }

    /**
     * Εκτύπωση στοιχείων λογαριασμού.
     */
    public void printDetails() {
        System.out.println("Λογαριασμός #" + accountNumber + " | Δικαιούχος: " + holder + " | Υπόλοιπο: " + balance + "€");
    }
}
