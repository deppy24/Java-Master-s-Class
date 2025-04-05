package Lab5;

public class Max {
    int[] a = new int[]{5, 10, 15, 20, 25};
    int max;
    int index;

    public Max() {
        max = a[0];
        index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
    }
  
    public static void main(String[] args) {
        Max maxValue = new Max();
        // Print the array
        System.out.print("Array: ");
        for (int value : maxValue.a) {
            System.out.print(value + " ");
        }
        System.out.println();
        // Access the max and index values to use the variable
        System.out.println("Accessed max value: " + maxValue.max);
        System.out.println("Accessed index value: " + maxValue.index);
        
    }
}
