package Project3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ContactManager {
    /**
     * This program allows the user to enter contact information and saves it to a file.
     * The user can add multiple contacts until they choose to stop.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "contacts.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            boolean keepGoing = true;

            while (keepGoing) {
                System.out.print("First name: ");
                String firstName = scanner.nextLine().trim();

                System.out.print("Last name: ");
                String lastName = scanner.nextLine().trim();

                System.out.print("Landline phone: ");
                String landline = scanner.nextLine().trim();

                System.out.print("Mobile phone: ");
                String mobile = scanner.nextLine().trim();

                if (firstName.isEmpty() || lastName.isEmpty() || landline.isEmpty() || mobile.isEmpty()) {
                    System.out.println("All fields are required. Try again.");
                    continue;
                }

                writer.write(firstName + "," + lastName + "," + landline + "," + mobile);
                writer.newLine();
                writer.flush();
                System.out.println("Contact saved.\n");

                System.out.print("Do you want to add another contact? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                keepGoing = response.equals("yes");
            }

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("Program finished.");
    }
}
