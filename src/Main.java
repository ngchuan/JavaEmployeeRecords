//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            // Show options
            System.out.println("Choose an option:");
            System.out.println("1. Add a new Employee");
            System.out.println("2. Modify Employee records");
            System.out.println("3. List all Employees");
            System.out.println("4. Delete an Employee");
            System.out.println("5. Quit");

            int option = getUserOption(scanner);

            switch (option) {
                case 1:
                    // Add new employee
                    addNewEmployee(scanner, employeeManager);
                    break;
                case 2:
                    // Modify employee
                    modifyEmployee(scanner, employeeManager);
                    break;
                case 3:
                    // List all employees
                    listEmployees(employeeManager);
                    break;
                case 4:
                    // Delete employee
                    deleteEmployee(scanner, employeeManager);
                    break;
                case 5:
                    // Quit the program
                    keepRunning = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
        scanner.close();
    }

    // Method to get valid user input for the options
    private static int getUserOption(Scanner scanner) {
        int option = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter your choice: ");
                option = scanner.nextInt();

                if (option >= 1 && option <= 5) {
                    isValid = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // clear invalid input
            }
        }

        return option;
    }

    // Method to add a new employee
    private static void addNewEmployee(Scanner scanner, EmployeeManager employeeManager) {
        System.out.println("Is the employee Full-Time or Part-Time?");
        System.out.println("1. Full-Time");
        System.out.println("2. Part-Time");

        int type = getUserOption(scanner);

        System.out.print("Enter Employee Name: ");
        scanner.nextLine();  // Consume newline
        String name = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        if (type == 1) {
            // Full-Time Employee
            System.out.print("Enter Monthly Salary: ");
            double salary = scanner.nextDouble();
            FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name, title, department, salary);
            employeeManager.addEmployee(fullTimeEmployee);
            System.out.println("Full-Time employee added.");
        } else if (type == 2) {
            // Part-Time Employee
            System.out.print("Enter Hourly Wage: ");
            double hourlyWage = scanner.nextDouble();

            System.out.print("Enter Hours Worked: ");
            double hoursWorked = scanner.nextDouble();

            System.out.print("Enter Overtime Hours Worked: ");
            double overtimeHours = scanner.nextDouble();

            PartTimeEmployee partTimeEmployee = new PartTimeEmployee(name, title, department, hourlyWage, hoursWorked, overtimeHours);
            employeeManager.addEmployee(partTimeEmployee);
            System.out.println("Part-Time employee added.");
        }
    }

    // Method to modify an existing employee
    private static void modifyEmployee(Scanner scanner, EmployeeManager employeeManager) {
        listEmployees(employeeManager);

        System.out.print("Enter the Employee number to modify: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < employeeManager.getEmployees().size()) {
            System.out.println("Is the employee Full-Time or Part-Time?");
            System.out.println("1. Full-Time");
            System.out.println("2. Part-Time");

            int type = getUserOption(scanner);

            System.out.print("Enter Employee Name: ");
            scanner.nextLine();  // Consume newline
            String name = scanner.nextLine();

            System.out.print("Enter Title: ");
            String title = scanner.nextLine();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            if (type == 1) {
                // Full-Time Employee
                System.out.print("Enter Monthly Salary: ");
                double salary = scanner.nextDouble();
                FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name, title, department, salary);
                employeeManager.updateEmployee(index, fullTimeEmployee);
                System.out.println("Employee record updated.");
            } else if (type == 2) {
                // Part-Time Employee
                System.out.print("Enter Hourly Wage: ");
                double hourlyWage = scanner.nextDouble();

                System.out.print("Enter Hours Worked: ");
                double hoursWorked = scanner.nextDouble();

                System.out.print("Enter Overtime Hours Worked: ");
                double overtimeHours = scanner.nextDouble();

                PartTimeEmployee partTimeEmployee = new PartTimeEmployee(name, title, department, hourlyWage, hoursWorked, overtimeHours);
                employeeManager.updateEmployee(index, partTimeEmployee);
                System.out.println("Employee record updated.");
            }
        } else {
            System.out.println("Invalid employee number.");
        }
    }

    // Method to list all employees
    private static void listEmployees(EmployeeManager employeeManager) {
        List<Employee> employees = employeeManager.getEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                System.out.println((i + 1) + ". " + employee.getName() +
                        " (" + employee.getTitle() + ", " + employee.getDepartment() + ", " + employee.getTypeOfEmployment() + ") - " +
                        "Salary: " + employee.calculateSalary());
            }
        }
    }

    // Method to delete an employee
    private static void deleteEmployee(Scanner scanner, EmployeeManager employeeManager) {
        listEmployees(employeeManager);

        System.out.print("Enter the Employee number to delete: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < employeeManager.getEmployees().size()) {
            employeeManager.deleteEmployee(index);
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Invalid employee number.");
        }
    }
}
