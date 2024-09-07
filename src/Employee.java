public abstract class Employee {
    private String name;
    private String title;
    private String department;
    private String typeOfEmployment;

    // Constructor
    public Employee(String name, String title, String department, String typeOfEmployment) {
        this.name = name;
        this.title = title;
        this.department = department;
        this.typeOfEmployment = typeOfEmployment;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTypeOfEmployment() {
        return typeOfEmployment;
    }

    public void setTypeOfEmployment(String typeOfEmployment) {
        this.typeOfEmployment = typeOfEmployment;
    }

    // Abstract method for calculating salary (to be implemented by subclasses)
    public abstract double calculateSalary();
}
