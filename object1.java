class Employee {
    int empId;
    String empName;

    void showDetails() {
        System.out.println(empId);
        System.out.println(empName);
    }
}

public class object1 {
    public static void main(String[] args) {
        Employee e1 = new Employee(); // Object creation
        e1.empId = 1001;
        e1.empName = "Rahul";

        e1.showDetails(); // Method call
    }
}

