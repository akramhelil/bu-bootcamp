package module3;
import java.util.ArrayList;
import java.util.HashMap;

public class Employee {

    // FIELDS: the data each Employee object holds
    private String name;
    private double salary;
    private boolean active;

    // CONSTRUCTOR: runs when you write new Employee(...)
    public Employee(String name, double salary) {
        this.name = name; // 'this.name' is the field; 'name' is the parameter
        this.salary = salary;
        this.active = true; // all new employees start active
    }

    // GETTERS: controlled read access to private fields
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isActive() {
        return active;
    }

    // METHODS: actions this object can perform
    public void promote(double raise) {
        if (raise > 0)
            this.salary += raise;
    }

    public void deactivate() {
        this.active = false;
    }

    // TO_STRING: what prints when you System.out.println(employee)
    @Override
    public String toString() {
        return name + " | $" + salary + " | active: " + active;
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", 50000);
        Employee emp2 = new Employee("Bob", 60000);
        Employee emp3 = new Employee("Charlie", 70000);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        HashMap<String, Employee> employeeMap = new HashMap<>();

        for (Employee emp : employees) {
            employeeMap.put(emp.getName(), emp);
            System.out.println(emp);
        }
        System.out.println("Employee Map: " + employeeMap);
    }
}