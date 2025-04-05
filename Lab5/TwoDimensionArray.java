package Lab5;
import java.util.Random;

public class TwoDimensionArray {
    
    public static int random(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    // Method to generate a 2D array with random integers between min and max
    public static int[][] generateRandom2DArray(int rows, int cols, int min, int max) {
        Random rand = new Random();
        int[][] random2DArray = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                random2DArray[i][j] = rand.nextInt(max - min + 1) + min; // Random integer between min and max
            }
        }
        return random2DArray;
    }

    public static void main(String[] args) {
        // Generate a 3x3 2D array with random integers between 1 and 10
        int[][] array = generateRandom2DArray(3, 3, 1, 10);

        // Print the 2D array
        System.out.println("Random 2D array:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
