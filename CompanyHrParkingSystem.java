package oop.assigment_problems;
class CompanyEmployeeRecord {
    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;
    static int totalRecords = 0;
    public CompanyEmployeeRecord(String name, String empId, Employee employee, ParkingSlot slot) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;
        totalRecords++;
    }
    public String fullProfile() {
        double pay = 0.0;
        if (employee instanceof ManagerEmployee) {
            pay = ((ManagerEmployee) employee).effectiveSalary();
        } else if (employee instanceof InternEmployee) {
            pay = ((InternEmployee) employee).effectiveSalary();
        } else if (employee != null) {
            pay = employee.getSalary();
        }
        String slotStr = (slot != null) ? "Slot: " + slot.slotNo : "Slot: no parking assigned";
        return name + " | Pay: Rs " + pay + " | " + slotStr;
    }
}
public class CompanyHrParkingSystem {
    public static void main(String[] args) {
        ParkingSlot s1 = new ParkingSlot("A1", 1, 0);
        ParkingSlot s2 = new ParkingSlot("A2", 1, 0);
        ManagerEmployee divyaEmp = new ManagerEmployee("M101", "Divya", 70000.0, 8000.0);
        Employee karanEmp = new Employee("E102", "Karan", 40000.0);
        InternEmployee meeraEmp = new InternEmployee("I103", "Meera", 12000.0, 10000.0);
        CompanyEmployeeRecord r1 = new CompanyEmployeeRecord("Divya", "M101", divyaEmp, s1);
        CompanyEmployeeRecord r2 = new CompanyEmployeeRecord("Karan", "E102", karanEmp, s2);
        CompanyEmployeeRecord r3 = new CompanyEmployeeRecord("Meera", "I103", meeraEmp, null);
        System.out.println(r1.fullProfile());
        System.out.println(r2.fullProfile());
        System.out.println(r3.fullProfile());
        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}
