package Project2.Pro2.Exercise1;
import java.util.Random;

public class MyTable{
    private int[] table;

    //ΠΡΩΤΗ ΜΕΘΟΔΟΣ
    // Method to fill the table with random values
    static void fillTableRandomly(double[] table) {
        if (table == null) {
            System.out.println("The table is null. Cannot fill with random values.");
            return;
        }
        Random randomfill = new Random();
        for (int i = 0; i < table.length; i++) {
            table[i] = randomfill.nextDouble() * 1000; // Random value between 0 and 1000
        }
    }

    //ΔΕΥΤΕΡΗ ΜΕΘΟΔΟΣ
    static void printTableΗ(double[] table) {
        if (table == null) {
            System.out.println("The table is empty.");
            return;
        }
        System.out.print("Table contents: \n");
        for (double value : table) {
            System.out.printf("%.2f ", value); // Correctly format the double value
        }
        System.out.println();
    }

    //ΤΡΙΤΗ ΜΕΘΟΔΟΣ
    static void printTableV(double[] table) {
        if (table == null) {
            System.out.println("The table is empty.");
            return;
        }
        System.out.print("Table contents (vertical): \n");
        for (double value : table) {
            System.out.printf("%.2f\n", value); // Correctly format the double value
        }
    }

    //ΤΕΤΑΡΤΗ ΜΕΘΟΔΟ
    static void swapValues(double []table , int x, int y){
        if (table == null) {
            System.out.println("The table is empty.");
            return;
        }
        if (x < 0 || x >= table.length || y < 0 || y >= table.length) {
            System.out.println("Invalid indices for swapping.");
            return;
        }
        double temp = table[x];
        table[x] = table[y];
        table[y] = temp;
        System.out.println("Values swapped: " + table[x] + " and " + table[y]);
        }

        //ΠΕΜΠΤΗ ΜΕΘΟΔΟΣ 
        // Method to find the index of the minimum value starting from index i
        static int minLocationFrom(double[] table, int i) {
            if (table == null) {
                System.out.println("The table is empty.");
                return -1;
            }
            if (i < 0 || i >= table.length) {
                System.out.println("Invalid index for finding minimum location.");
                return -1;
            }

            // Start with the assumption that the minimum value is at index i
            int minIndex = i;
            double minValue = table[i];

            // Iterate through the entire table, wrapping around if necessary
            for (int j = 0; j < table.length; j++) {
                int currentIndex = (i + j) % table.length; // Wrap around using modulo
                if (table[currentIndex] < minValue) {
                    minValue = table[currentIndex];
                    minIndex = currentIndex;
                }
            }

            System.out.println("Minimum value from index " + i + " is at index: " + minIndex + " with value: " + minValue);
            return minIndex;
        }

        //ΕΚΤΗ ΜΕΘΟΔΟΣ
        // Method to find the index of the maximum value starting from index i
        static int maxLocationFrom(double[] table, int i) {
            if (table == null) {
                System.out.println("The table is empty.");
                return -1;
            }
            if (i < 0 || i >= table.length) {
                System.out.println("Invalid index for finding maximum location.");
                return -1;
            }

            // Start with the assumption that the maximum value is at index i
            int maxIndex = i;
            double maxValue = table[i];

            // Iterate through the entire table, wrapping around if necessary
            for (int j = 0; j < table.length; j++) {
                int currentIndex = (i + j) % table.length; // Wrap around using modulo
                if (table[currentIndex] > maxValue) {
                    maxValue = table[currentIndex];
                    maxIndex = currentIndex;
                }
            }

            System.out.println("Maximum value from index " + i + " is at index: " + maxIndex + " with value: " + maxValue);
            return maxIndex;
        }

        //ΕΒΔΟΜΗ ΜΕΘΟΔΟΣ
        static double []  cloneTable (double [] table){
            if (table == null) {
                System.out.println("The table is empty.");
                return null;
            }
            double [] clonedTable = new double[table.length];
            for (int i = 0; i < table.length; i++) {
                clonedTable[i] = table[i];
            }
            System.out.println("Cloned table created.");
            return clonedTable;
        }

        //ΟΓΔΟΗ ΜΕΘΟΔΟΣ
        static double [] mergeTables (double []table , double [] table2){
            if (table == null || table == null) {
                System.out.println("One or both tables are empty.");
                return null;
            }
            double [] mergedTable = new double[table.length + table.length];
            for (int i = 0; i < table.length; i++) {
                mergedTable[i] = table[i];
            }
            for (int j = 0; j < table.length; j++) {
                mergedTable[j + table.length] = table[j];
            }
            System.out.println("Tables merged successfully.");
            
            return mergedTable;
        }

}
