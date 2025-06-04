package Project1.EXE2;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    private int numberToGuess;  // The random number the user needs to guess
    private int maxNumber;      // Maximum number the user can guess

    // Constructor of the class, which sets the limit N and calculates the random number
    public GuessGame(int maxNumber) {
        if (maxNumber <= 0) {
            this.maxNumber = 200;  // If maxNumber is invalid (<= 0), set the default value to 200
            System.out.println("Invalid maximum number. Setting the maximum number to 200.");
        } else {
            this.maxNumber = maxNumber;
        }

        // Generate a random number the user needs to guess
        Random rand = new Random();
        this.numberToGuess = rand.nextInt(this.maxNumber) + 1; // Random number between 1 and maxNumber
    }

    // Method to check if the number entered by the user is correct
    public boolean guessNumber(int userGuess) {
        if (userGuess < numberToGuess) {
            System.out.println("The number is higher.");
            return false;
        } else if (userGuess > numberToGuess) {
            System.out.println("The number is lower.");
            return false;
        } else {
            System.out.println("Congratulations! You guessed the number.");
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter the maximum number (or default to 100 if not provided)
        System.out.print("Welcome to the Guessing Game!\n");
        System.out.print("Let's play a game where you have to guess a number between 1 and N.\n");
        System.out.print("Enter the maximum number limit (default is 100 if invalid): ");
        int maxNumber = scanner.nextInt();

    
        GuessGame game = new GuessGame(maxNumber);

        int userGuess = -1;
        int attempts = 0;

        // The user tries to guess the number until they find it
        while (!game.guessNumber(userGuess)) {
            System.out.print("Guess the number: ");
            userGuess = scanner.nextInt();
            attempts++;
        }
        System.out.println("The random number was: " + game.numberToGuess);
        System.out.println("Total attempts: " + attempts);
        
        scanner.close();
    }
}