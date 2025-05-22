package Lab7;

public class TwoDimensions {
    public boolean equals(int[][] table1, int[][] table2) {
        
        for (int i = 0; i < table1.length; i++) {
            for (int j = 0; j < table1[i].length; j++) {
                if (table1[i][j] != table2[i][j]) {
                    return false; // Διαφορετικά στοιχεία
                }
            }
        }
        return true; // Ίσα πίνακες
    }
    public static void main(String[] args) {
        // Πρώτος δυσδιάστατος πίνακας 3x3
        int[][] table1 = {
            {1, 2},
            {4, 5}
        };

        // Δεύτερος δυσδιάστατος πίνακας 2x2
        int[][] table2 = {
            {10, 20},
            {30, 40}
        };
        Boolean b = new TwoDimensions().equals(table1, table2);
        System.out.println("Are the two tables equal? " + b);
       
    }
}
