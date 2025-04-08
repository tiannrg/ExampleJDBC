/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.controllers;

import co.edu.sena.examplejdbc.model.Employee;
import java.util.List;

/**
 *
 * @author rojas
 */
public interface IEmployeeControllers {
    public void insert(Employee employee) throws Exception;
    public void update (Employee employee) throws Exception;
    public void delete(Long document) throws Exception;
    public List<Employee> findAll() throws Exception;
    public Employee findById (long  document) throws Exception;
}
