package Lab5;
import java.util.Random;
// 1. Write a method that takes an integer n and a value v as
// parameters and returns an array of size n filled with the value v.

public class Array {
   
    public static int random(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    // Method to generate an array of 10 random integers between 1 and 10
    public static int[] generateRandomIntArray(int size, int min, int max) {
        Random rand = new Random();
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = rand.nextInt(max - min + 1) + min; // Random integer between min and max
        }
        return randomArray;
    }
    public static void main(String[] args) {
        
        int[] randomIntArray = generateRandomIntArray(10, 1, 10);

        for (int value : randomIntArray) {
            System.out.print(value + " ");
        }
    }
}
