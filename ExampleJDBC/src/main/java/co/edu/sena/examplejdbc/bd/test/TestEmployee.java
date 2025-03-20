/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.test;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBEmployeeType;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;

/**
 *fecha: 20/3/2025
 * @author rojas
 * objetivo: probar consultar/transacciones en la tabla employee
 */
public class TestEmployee {
    public static void main(String[] args) {
        DBEmployee dbe= new DBEmployee();
        DBEmployeeType dbet = new DBEmployeeType();
        
        //insertar
        EmployeeType employeeType = dbet.findById(1);
        Employee employee = new Employee(111625896, "elsa Broson", "ev Sa", "310", employeeType);
        dbe.insert(employee);
        
        //actualizar
        employee.setFullname("Elton Tito");
        employeeType = dbet.findById(2);
        employee.setEmployeeType(employeeType);
        dbe.update(employee);
        
        //eliminar
        dbe.delete(11625896);
        
        
        //Consultar todos
        List<Employee> employees = dbe.findAll();
        for(Employee e : employees){
            System.out.println("document: " + e.getDocument() 
                    + " fullname: " + e.getFullname() 
                    + " address: " + e.getAddress()
                    + " phone: " + e.getPhone()
                    + " type: "+ e.getEmployeeType().getDescript());
            
        }
        
          //consultar por ID
        System.out.println("");
        Employee employee2 = dbe.findById(1118);
        System.out.println("document: " + employee2.getDocument() 
                    + " fullname: " + employee2.getFullname() 
                    + " address: " + employee2.getAddress()
                    + " phone: " + employee2.getPhone()
                    + " type: "+ employee2.getEmployeeType().getDescript());

        
    }
}
