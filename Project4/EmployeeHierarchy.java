// Base class for all employees
abstract class Employee {
    private String name;
    private int age;
    private int yearsOfExperience;
    private String gender;
    private String phone;
    private String address;
    private boolean isMarried;
    private int numberOfChildren;

    public Employee(String name, int age, int yearsOfExperience, String gender, String phone, String address, boolean isMarried, int numberOfChildren) {
        if (age <= 0 || yearsOfExperience < 0 || numberOfChildren < 0) {
            throw new IllegalArgumentException("Invalid input: Age, years of experience, and number of children must be non-negative.");
        }
        this.name = name;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.isMarried = isMarried;
        this.numberOfChildren = numberOfChildren;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Years of Experience: " + yearsOfExperience +
                ", Gender: " + gender + ", Phone: " + phone + ", Address: " + address +
                ", Married: " + (isMarried ? "Yes" : "No") + ", Number of Children: " + numberOfChildren;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }
}

// Class for administrative employees
class AdministrativeEmployee extends Employee {
    private double baseSalary;

    public AdministrativeEmployee(String name, int age, int yearsOfExperience, String gender, String phone, String address, boolean isMarried, int numberOfChildren, double baseSalary) {
        super(name, age, yearsOfExperience, gender, phone, address, isMarried, numberOfChildren);
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Base salary must be positive.");
        }
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        double experienceBonus = (getYearsOfExperience() / 5) * 50;
        double childrenBonus = getNumberOfChildren() * 40;
        return baseSalary + experienceBonus + childrenBonus;
    }
}

// Class for production employees
class ProductionEmployee extends Employee {
    private static final double BASE_SALARY = 1200;

    public ProductionEmployee(String name, int age, int yearsOfExperience, String gender, String phone, String address, boolean isMarried, int numberOfChildren) {
        super(name, age, yearsOfExperience, gender, phone, address, isMarried, numberOfChildren);
    }

    @Override
    public double calculateSalary() {
        double experienceBonus = (getYearsOfExperience() / 5) * 30;
        double childrenBonus = getNumberOfChildren() * 40;
        return BASE_SALARY + experienceBonus + childrenBonus;
    }
}

// Main class
public class EmployeeHierarchy {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        try {
            // Adding administrative employees
            employees[0] = new AdministrativeEmployee("Invalid Employee", 30, 10, "Male", "1234567890", "Invalid St", true, 2, 1500);
            employees[1] = new AdministrativeEmployee("Jane Smith", 38, 15, "Female", "0987654321", "456 Admin St", false, 0, 1400);
            employees[2] = new AdministrativeEmployee("Alice Johnson", 50, 25, "Female", "1122334455", "789 Admin St", true, 3, 1600);

            // Adding production employees
            employees[3] = new ProductionEmployee("Bob Brown", 30, 10, "Male", "2233445566", "123 Prod St", true, 1);
            employees[4] = new ProductionEmployee("Charlie White", 28, 6, "Male", "3344556677", "456 Prod St", false, 0);

            // Displaying employee details and salaries
            for (Employee employee : employees) {
                System.out.println(employee);
                System.out.println("Final Salary: " + employee.calculateSalary() + "€");
                System.out.println("--------------------------------------------------");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}