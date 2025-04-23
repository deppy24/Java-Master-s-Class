package Project2.Pro2.Exercise1;



public class Main {
    public static void main(String[] args) {

    // Create a double array
    double[] myTable = new double[50];

    // Fill the table with random values
    MyTable.fillTableRandomly(myTable);

     // Print the table 
    MyTable.printTableΗ(myTable);
        

    //Print the table
    MyTable.printTableV(myTable);

    // Swap values at indices 2 and 5
    MyTable.swapValues(myTable, 2, 5);
    // Print the table again to see the changes
    MyTable.printTableΗ(myTable);

    //Find the minimum value in the table
    MyTable.minLocationFrom(myTable,8 );

    //Find the maximum value in the table
    MyTable.maxLocationFrom(myTable, 8);

    //Clone the table
    double[] clonedTable = MyTable.cloneTable(myTable);
    // Print the cloned table
    MyTable.printTableΗ(clonedTable);

    //Merge two tables  
    double[] mergedTable = MyTable.mergeTables(myTable, clonedTable);
    // Print the merged table
    MyTable.printTableΗ(mergedTable);
    }
}
