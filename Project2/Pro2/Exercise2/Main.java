package Project2.Pro2.Exercise2;

// Main.java
// Δοκιμές για την κλάση Bank και BankAccount με παραδείγματα και έλεγχο περιορισμών

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Δημιουργία λογαριασμών
        try {
            bank.createAccount(1001, "Γιάννης Παπαδόπουλος", 500.0);
            bank.createAccount(1002, "Μαρία Νικολάου", 1200.0);
            bank.createAccount(1003, "Αλέξανδρος Τσάμης", 50.0);
            bank.createAccount(1004, "Ελένη Κωνσταντίνου", 3000.0);
            bank.createAccount(1005, "Πέτρος Βασιλείου", 0.0);
            System.out.println("✅ Δημιουργήθηκαν οι λογαριασμοί με επιτυχία.");
        } catch (Exception e) {
            System.out.println("⚠️ Σφάλμα κατά τη δημιουργία λογαριασμών: " + e.getMessage());
        }

        // Προσπάθεια δημιουργίας λογαριασμού με ήδη υπάρχον αριθμό
        try {
            bank.createAccount(1001, "Διπλός Λογαριασμός", 100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Σφάλμα: " + e.getMessage());
        }

        // Καταθέσεις και Αναλήψεις
        try {
            bank.deposit(1001, 200); // Επιτυχής κατάθεση
            bank.withdraw(1002, 300); // Επιτυχής ανάληψη
            bank.withdraw(1003, 60); // Αποτυχία (ανεπαρκές υπόλοιπο)
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Σφάλμα κατά την οικονομική συναλλαγή: " + e.getMessage());
        }

        // Προσπάθεια κατάθεσης σε μη υπαρκτό λογαριασμό
        try {
            bank.deposit(9999, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Προσπάθεια κατάθεσης σε άκυρο λογαριασμό: " + e.getMessage());
        }

        // Εύρεση λογαριασμού με το μεγαλύτερο υπόλοιπο
        try {
            BankAccount richest = bank.findHighestBalanceAccount();
            if (richest != null) {
                System.out.println("👑 Λογαριασμός με το μεγαλύτερο υπόλοιπο:");
                richest.printDetails();
            } else {
                System.out.println("⚠️ Δεν υπάρχουν λογαριασμοί στην τράπεζα.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Σφάλμα κατά την εύρεση του λογαριασμού με το μεγαλύτερο υπόλοιπο: " + e.getMessage());
        }

        // Υπολογισμός συνολικών καταθέσεων
        try {
            double total = bank.totalDeposits();
            System.out.println("💰 Συνολικό ποσό καταθέσεων: " + total + "€");
        } catch (Exception e) {
            System.out.println("⚠️ Σφάλμα κατά τον υπολογισμό συνολικών καταθέσεων: " + e.getMessage());
        }

        // Εύρεση λογαριασμών με υπόλοιπο κάτω από όριο
        try {
            int count = bank.countAccountsUnderLimit(100);
            System.out.println("📉 Λογαριασμοί με υπόλοιπο κάτω από 100€: " + count);
        } catch (Exception e) {
            System.out.println("⚠️ Σφάλμα κατά την εύρεση λογαριασμών: " + e.getMessage());
        }

        // Αναζήτηση λογαριασμού με αριθμό
        try {
            BankAccount account = bank.findAccountByNumber(1002);
            if (account != null) {
                System.out.println("🔎 Αναζήτηση λογαριασμού 1002:");
                account.printDetails();
            } else {
                System.out.println("⚠️ Δεν βρέθηκε λογαριασμός με αριθμό 1002.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Σφάλμα κατά την αναζήτηση λογαριασμού: " + e.getMessage());
        }

        // Προσπάθεια δημιουργίας πάνω από 1000 λογαριασμών
        for (int i = 6; i <= 1005; i++) {
            try {
                bank.createAccount(1000 + i, "Χρήστης " + i, 10.0);
            } catch (IllegalStateException e) {
                System.out.println("⚠️ Δημιουργία πέρα από το όριο: " + e.getMessage());
                break;
            } catch (Exception e) {
                System.out.println("⚠️ Άλλο σφάλμα κατά τη δημιουργία λογαριασμού: " + e.getMessage());
                break;
            }
        }
    }
}
