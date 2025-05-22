package Project3;

public class Main1 {
   
    public static void main(String[] args) {
        // Testing with valid data
        Supervisor sup = new Supervisor("Maria", "Papadopoulou", 101);
        Project project = new Project("AI Research", "2025-01-01", "2025-12-31", sup);

        project.printProjectDetails();

        // Assigning new supervisor
        Supervisor sup2 = new Supervisor("Giorgos", "Nikolaou", 202);
        project.assignSupervisor(sup2);
        System.out.println("\n--- After Supervisor Change ---");
        project.printProjectDetails();
    }
}


