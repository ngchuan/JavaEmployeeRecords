public class PartTimeEmployee extends Employee {
    private double hourlyWage;
    private double hoursWorked;
    private double overtimeHours;

    // Constructor
    public PartTimeEmployee(String name, String title, String department, double hourlyWage, double hoursWorked, double overtimeHours) {
        super(name, title, department, "Part Time");
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.overtimeHours = overtimeHours;
    }

    // Getters and Setters
    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    // Implement calculateSalary method
    @Override
    public double calculateSalary() {
        return (hoursWorked * hourlyWage) + (overtimeHours * hourlyWage * 1.5);
    }
}
