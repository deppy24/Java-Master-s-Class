package Project2.Pro2.Exercise2;

public class Bank {
    private BankAccount[] accounts = new BankAccount[1000];  // Μέγιστο 1000 λογαριασμοί
    private int accountCount = 0;


    /**
     * Δημιουργία νέου λογαριασμού, αν δεν έχουμε φτάσει το όριο.
     */
    public void createAccount(int number, String holder, double initialBalance) {
        if (accountCount >= 1000) {
            throw new IllegalStateException("Η τράπεζα έχει φτάσει το όριο των 1000 λογαριασμών.");
        }

        // Έλεγχος για μοναδικότητα αριθμού λογαριασμού
        if (findAccountByNumber(number) != null) {
            throw new IllegalArgumentException("Ο αριθμός λογαριασμού υπάρχει ήδη.");
        }

        accounts[accountCount++] = new BankAccount(number, holder, initialBalance);
    }

    /**
     * Επιστρέφει το συνολικό ποσό όλων των υπολοίπων.
     */
    public double totalDeposits() {
        double total = 0;
        for (int i = 0; i < accountCount; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    /**
     * Μετράει τους λογαριασμούς με υπόλοιπο μικρότερο από κάποιο όριο.
     */
    public int countAccountsUnderLimit(double limit) {
        int count = 0;
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getBalance() < limit) {
                count++;
            }
        }
        return count;
    }

    /**
     * Επιστρέφει τον λογαριασμό με το μεγαλύτερο υπόλοιπο.
     */
    public BankAccount findHighestBalanceAccount() {
        if (accountCount == 0) return null;

        BankAccount max = accounts[0];
        for (int i = 1; i < accountCount; i++) {
            if (accounts[i].getBalance() > max.getBalance()) {
                max = accounts[i];
            }
        }
        return max;
    }

    /**
     * Αναζητά λογαριασμό με βάση τον αριθμό του.
     */
    public BankAccount findAccountByNumber(int number) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == number) {
                return accounts[i];
            }
        }
        return null;
    }

    /**
     * Καταθέτει χρήματα σε έναν λογαριασμό.
     */
    public void deposit(int accountNumber, double amount) {
        BankAccount account = findAccountByNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Ο λογαριασμός με αριθμό " + accountNumber + " δεν βρέθηκε.");
        }
        account.deposit(amount);
    }

    /**
     * Αναλήψη χρημάτων από έναν λογαριασμό.
     */
    public void withdraw(int accountNumber, double amount) {
        BankAccount account = findAccountByNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Ο λογαριασμός με αριθμό " + accountNumber + " δεν βρέθηκε.");
        }
        account.withdraw(amount);
    }
}
