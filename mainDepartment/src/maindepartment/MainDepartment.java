/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maindepartment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.Emp_DptTable;
import model.Employee;

/**
 *
 * @author pongs
 */
public class MainDepartment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Department dep = new Department();
        dep.setName("IT");
        Department dep2 = new Department();
        dep2.setName("HR");

        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        Employee emp3 = new Employee();
        Employee emp4 = new Employee();

        emp1.setName("John");
        emp1.setJob("Network Admin");
        emp1.setSalary(56789);
        emp1.setDepartmentid(dep);
        emp2.setName("Marry");
        emp2.setJob("HR Manager");
        emp2.setSalary(46789);
        emp2.setDepartmentid(dep2);
        emp3.setName("Henry");
        emp3.setJob("Programmer");
        emp3.setSalary(67890);
        emp3.setDepartmentid(dep);
        emp4.setName("Clark");
        emp4.setJob("HR Manager");
        emp4.setSalary(36789);
        emp4.setDepartmentid(dep2);

        persist(dep);
        persist(dep2);
        persist(emp1);
        persist(emp2);
        persist(emp3);
        persist(emp4);

        // TODO code application logic here
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mainDepartmentPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
