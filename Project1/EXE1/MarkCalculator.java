package Project1.EXE1;

import java.util.Scanner;

public class MarkCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Students student = new Students();

        // Ζητάμε το όνομα του φοιτητή
        System.out.print("Enter student's name: ");
        student.SetName(scanner.nextLine());

        // Ζητάμε τον αριθμό μητρώου
        System.out.print("Enter student's arithmos mitroou: ");
        student.SetArthMitrvou(scanner.nextInt());

        // Ζητάμε τον βαθμό εξετάσεων
        System.out.print("Enter student's vathmos exetasis: ");
        student.SetVathmosExetasis(scanner.nextInt());

        // Ζητάμε τον βαθμό εργαστηρίου
        System.out.print("Enter student's vathmos ergastiriou: ");
        student.SetVathmosErgastiriou(scanner.nextInt());


        // Εμφανίζουμε τα δεδομένα του φοιτητή
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + student.GetName());
        System.out.println("Arithmos Mitroou: " + student.GetArthMitrvou());
        System.out.println("Vathmos Exetasis: " + student.GetVathmosExetasis());
        System.out.println("Vathmos Ergastiriou: " + student.GetVathmosErgastiriou());
        
        // Υπολογίζουμε τον τελικό βαθμό
        student.TelikosVathmos(student.GetVathmosExetasis(), student.GetVathmosErgastiriou());


        scanner.close(); // Κλείνουμε τον scanner
    }
}