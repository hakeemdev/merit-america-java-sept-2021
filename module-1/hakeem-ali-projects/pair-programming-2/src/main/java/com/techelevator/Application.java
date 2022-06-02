package com.techelevator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class Application {

    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Map<String, Project> projects = new HashMap<>();

    /**
     * The main entry point in the application
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        departments.add(new Department("Marketing", 1));
        departments.add(new Department("Sales", 2));
        departments.add(new Department("Engineering", 3));
    }

    /**
     * Assigns index of departments to String equivalent
     **/

    private Department getDepartmentByName(String department) {
        for (Department departmentName : departments) {
            if (Objects.equals(department, "Marketing") && departmentName.getName().equals("Marketing")) {
                return departments.get(0);
            } else if (Objects.equals(department, "Sales") && departmentName.getName().equals("Sales")) {
                return departments.get(1);
            } else if (Objects.equals(department, "Engineering") && departmentName.getName().equals("Engineering")) {
                return departments.get(2);
            }
        }
        return null;
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (Department department : departments) {
            System.out.println(department.getName());
        }

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {

        LocalDate today = LocalDate.now();

        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        employee1.setFirstName("Dean");
        employee1.setLastName("Johnson");
        employee1.setEmail("djohnson@teams.com");
        employee1.setSalary(60000);
        employee1.setDepartment(getDepartmentByName("Engineering"));
        employee1.setHireDate(today);

        employees.add(employee1);
        employees.add(new Employee(2, "Angie", "Smith", "asmith@teams.com", getDepartmentByName("Engineering"), today));
        employees.add(new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", getDepartmentByName("Marketing"), today));

        employees.get(1).raiseSalary(10);
    }



    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        NumberFormat dollarsSalary = NumberFormat.getCurrencyInstance();
        for (Employee employee : employees) {
            System.out.println(employee.getFullName() + " (" + dollarsSalary.format(employee.getSalary()) + ") " + employee.getDepartment().getName());
        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {

        LocalDate startDate = LocalDate.now();
        Project project1 = new Project("TEams", "Project Management", startDate, startDate.plusDays(30));

        List<Employee> teamMembers1 = new ArrayList<>();
        teamMembers1.add(employees.get(0));
        teamMembers1.add(employees.get(1));

        project1.setTeamMembers(teamMembers1);
        projects.put("TEams", project1);

    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {

        LocalDate startDate = LocalDate.now().plusDays(31);
        Project project2 = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", startDate, startDate.plusDays(7));

        List<Employee> teamMembers2 = new ArrayList<>();
        teamMembers2.add(employees.get(2));

        project2.setTeamMembers(teamMembers2);
        projects.put("Marketing Landing Page", project2);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for (String key : projects.keySet()) {
            System.out.println(key + ": " + projects.get(key).getTeamMembers().size());
        }
    }

}
