package Project3;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

class Supervisor {
    private String firstName;
    private String lastName;
    private int id;

    public Supervisor(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public void printSupervisorDetails() {
        System.out.println("Supervisor Info:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("ID: " + id);
    }
}

class Project {
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private Supervisor supervisor;

    // Default constructor
    public Project() {
        this.title = "";
        this.startDate = null;
        this.endDate = null;
        this.supervisor = null;
    }

    // Parameterized constructor
    public Project(String title, String startDateStr, String endDateStr, Supervisor supervisor) {
        this.title = title;
        try {
            this.startDate = LocalDate.parse(startDateStr);
            this.endDate = LocalDate.parse(endDateStr);
            if (this.endDate.isBefore(this.startDate)) {
                throw new IllegalArgumentException("End date must be after start date.");
            }
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date format. Use YYYY-MM-DD.");
        }
        this.supervisor = supervisor;
    }

    public void assignSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public void printProjectDetails() {
        System.out.println("Project Title: " + title);
        System.out.println("Start Date: " + (startDate != null ? startDate : "N/A"));
        System.out.println("End Date: " + (endDate != null ? endDate : "N/A"));
        if (supervisor != null) {
            supervisor.printSupervisorDetails();
        } else {
            System.out.println("No supervisor assigned.");
        }
    }
}


