/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maindepartment;

import java.util.List;
import model.Department;
import model.Emp_DptTable;
import model.Employee;

/**
 *
 * @author pongs
 */
public class ReportDepartment_Employee {

    public static void main(String[] args) {
        List<Employee> empList = Emp_DptTable.findAllEmployee();
        List<Department> dptList = Emp_DptTable.findAllDepartment();
        System.out.println("All Employee (By ID)");
        for (Employee empI : empList) {
            System.out.println("--------------------");
            System.out.println("ID : " + empI.getEmployeeid());
            System.out.println("Name : " + empI.getName());
            System.out.println("Job : " + empI.getJob());
            System.out.println("Department : " + empI.getDepartmentid().getName());
            System.out.println("--------------------");

        }
        System.out.println("All Employee (By Department)");
        for (Department dptI : dptList) {
            for (Employee empInDepart : dptI.getEmployeeCollection()) {
                System.out.println("--------------------");
                System.out.println("ID : " + empInDepart.getEmployeeid());
                System.out.println("Name : " + empInDepart.getName());
                System.out.println("Job : " + empInDepart.getJob());
                System.out.println("Department : " + dptI.getName());
                System.out.println("--------------------");
            }

        }
    }
}
