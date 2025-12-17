class Employee123 {
    private int empId;
    public int empId1 = 55;
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
public class getset {
    public static void main(String[] args) {
        Employee123 emp = new Employee123();
        System.out.println("Employee ID: " + emp.empId1);
        System.out.println("Employee ID: " + emp.getEmpId());// empty 0
        // Using setter methods to set values
        emp.setEmpId(101);
        // Using getter methods to get values
        System.out.println("Employee ID: " + emp.getEmpId());//101
       
    }
}