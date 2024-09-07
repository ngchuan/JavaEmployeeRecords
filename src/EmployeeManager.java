import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employeeList = new ArrayList<>();

    // Create an Employee
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Read all Employees
    public List<Employee> getEmployees() {
        return employeeList;
    }

    // Update Employee details
    public void updateEmployee(int index, Employee employee) {
        employeeList.set(index, employee);
    }

    // Delete an Employee
    public void deleteEmployee(int index) {
        employeeList.remove(index);
    }
}
