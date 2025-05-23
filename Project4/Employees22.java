import java.lang.reflect.Array;

public class Employees22 {
    String name ;
    int age;
    double timeworked;
    String gender;
    int telephone;
    String address;
    int kidsnumber;
    String maritalstatus;
    String jobtitle;
    final int CommonSalary = 1200;
    int xronoepidoma;
    int epidomateknon;
    double salary;

    // Constructor
    //Περιγραφή: Δημιουργεί ένα αντικείμενο Employees22 με τα δεδομένα του υπαλλήλου
    //Περιγραφή: Ελέγχει αν τα δεδομένα είναι έγκυρα και αν όχι, προβαλλει μια εξαίρεση
    public Employees22(String name, int age, double timeworked, String gender , int telephone, String address, int kidsnumber, String maritalstatus, String jobtitle) {
        
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }
        if (timeworked <= 0) {
            throw new IllegalArgumentException("Time worked must be positive.");
        }
        if (telephone <= 0) {
            throw new IllegalArgumentException("Telephone must be positive.");
        }
        if (kidsnumber < 0) {
            throw new IllegalArgumentException("Number of kids cannot be negative.");
        }
        if ((name == null || gender == null || address == null || maritalstatus == null || jobtitle == null) || (name.isEmpty() || gender.isEmpty() || address.isEmpty() || maritalstatus.isEmpty() || jobtitle.isEmpty())) {
                    throw new IllegalArgumentException("Fields cannot be null or empty.");
                }
        if (!maritalstatus.equals("Married") && !maritalstatus.equals("Single") && !maritalstatus.equals("Divorced")) {
            throw new IllegalArgumentException("Marital status must be either Married, Single, or Divorced.");
        }
        if (!gender.equals("Female") && !gender.equals("Male")) {
            throw new IllegalArgumentException("Gender must be Female or Male.");
        }
        if (!jobtitle.equals("Management") && !jobtitle.equals("SoftwareDeveloper")) {
            throw new IllegalArgumentException("Job title must be either Management or Software Developer.");       
        }

        this.name = name;
        this.age = age;
        this.timeworked = timeworked;
        this.gender = gender;
        this.telephone = telephone;
        this.address = address;
        this.kidsnumber = kidsnumber;
        this.maritalstatus = maritalstatus;
        this.jobtitle = jobtitle;
    }

    @Override
    public String toString() {
        return name + "\t" + age + "\t" + timeworked + "\t" + gender + "\t" + telephone + "\t" + address + "\t" +
                kidsnumber + "\t" + maritalstatus + "\t" + jobtitle;
    }

    public double CalculateSalary() {
        int xronoepidoma = checkxronoepidoma(timeworked, jobtitle);
        int epidomateknon = checkepidomateknon(kidsnumber);
        salary = CommonSalary + xronoepidoma + epidomateknon;
        return salary;
    }

    public int checkxronoepidoma(double timeworked, String jobtitle){
        int years = (int) timeworked;
        int bonusPeriods = years / 5;
        if (jobtitle.equals("Management")){
            xronoepidoma = bonusPeriods * 50;
        }
        else if (jobtitle.equals("SoftwareDeveloper")){
            xronoepidoma = bonusPeriods * 30;
        }
        else xronoepidoma = 0;
        return xronoepidoma;
    }

    public int checkepidomateknon(int kidsnumber){
        if (kidsnumber > 0){
            epidomateknon = 40 * kidsnumber;
        }
        else epidomateknon = 0;
        return epidomateknon;
    }

    public static void main(String[] args) {
        Employees22[] employees = new Employees22[10];
       try {
            employees[0] = new Employees22("John Doe", 30, 5, "Male", 123456789, "123 Main St", 2, "Married", "Management");
            employees[1] = new Employees22("Jane Smith", 28, 3, "Male", 987654321, "456 Elm St", 1, "Single", "Management");
            employees[2] = new Employees22("Alice Johnson", 35, 7, "Female", 555555555, "789 Oak St", 0, "Divorced", "SoftwareDeveloper");
            employees[3] = new Employees22("Bob Brown", 40, 10, "Male", 444444444, "321 Pine St", 3, "Married", "Management");
            employees[4] = new Employees22("Charlie Davis", 25, 2, "Male", 222222222, "654 Maple St", 1, "Single", "SoftwareDeveloper");
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating employee: " + e.getMessage());
        }

        // Print table header
        System.out.printf("%-15s%-8s%-8s%-8s%-14s%-18s%-8s%-12s%-18s%-10s%n",
        "Name", "Age", "Years", "Gender", "Phone", "Address", "Kids", "Marital", "JobTitle", "Salary");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");

        for (Employees22 emp : employees) {
            if (emp != null) {
                double salary = emp.CalculateSalary();
                System.out.printf("%-15s%-8d%-8.1f%-8s%-14d%-18s%-8d%-12s%-18s%-10.2f€%n",
                emp.name, emp.age, emp.timeworked, emp.gender, emp.telephone, emp.address, emp.kidsnumber,
                emp.maritalstatus, emp.jobtitle, salary);
            }
        }
    

}}
