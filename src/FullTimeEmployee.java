public class FullTimeEmployee extends Employee {
    private double monthlySalary;

    // Constructor
    public FullTimeEmployee(String name, String title, String department, double monthlySalary) {
        super(name, title, department, "Full Time");
        this.monthlySalary = monthlySalary;
    }

    // Getters and Setters
    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    // Implement calculateSalary method
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
