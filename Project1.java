import java.util.*;

class Employee {
    int empNo;
    String name;
    String joinDate;
    char desigCode;
    String department;
    int basic;
    int hra;
    int it;

    public Employee(int empNo, String name, String joinDate, char desigCode, String department, int basic, int hra, int it) {
        this.empNo = empNo;
        this.name = name;
        this.joinDate = joinDate;
        this.desigCode = desigCode;
        this.department = department;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }
}

public class Project1 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Project1 <EmpID>");
            return;
        }

        int inputEmpId;

        try {
            inputEmpId = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid EmpID. Please enter a number.");
            return;
        }

        // Employee Data Initialization
        Employee[] employees = {
            new Employee(1001, "Ashish", "01/04/2009", 'e', "R&D", 20000, 8000, 3000),
            new Employee(1002, "Sushma", "23/08/2012", 'c', "PM", 30000, 12000, 9000),
            new Employee(1003, "Rahul", "12/11/2008", 'k', "Acct", 10000, 8000, 1000),
            new Employee(1004, "Chahat", "29/01/2013", 'r', "Front Desk", 12000, 6000, 2000),
            new Employee(1005, "Ranjan", "16/07/2005", 'm', "Engg", 50000, 20000, 20000),
            new Employee(1006, "Suman", "1/1/2000", 'e', "Manufacturing", 23000, 9000, 4400),
            new Employee(1007, "Tanmay", "12/06/2006", 'c', "PM", 29000, 12000, 10000),
        };

        // Designation and DA mapping
        Map<Character, String> designationMap = new HashMap<>();
        Map<Character, Integer> daMap = new HashMap<>();

        designationMap.put('e', "Engineer");       daMap.put('e', 20000);
        designationMap.put('c', "Consultant");     daMap.put('c', 32000);
        designationMap.put('k', "Clerk");          daMap.put('k', 12000);
        designationMap.put('r', "Receptionist");   daMap.put('r', 15000);
        designationMap.put('m', "Manager");        daMap.put('m', 40000);

        // Search employee
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.empNo == inputEmpId) {
                found = true;
                String desig = designationMap.get(emp.desigCode);
                int da = daMap.get(emp.desigCode);
                int salary = emp.basic + emp.hra + da - emp.it;

                System.out.println("Emp No.\tEmp Name\tDepartment\tDesignation\t\tSalary");
                System.out.println(emp.empNo + "\t" + emp.name + "\t\t" + emp.department + "\t" + desig + "\t\t" + salary);
                break;
            }
        }

        if (!found) {
            System.out.println("There is no employee with empid : " + inputEmpId);
        }
    }
}
