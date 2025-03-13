/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.bd.utils.MessageUtils;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rojas
 */
public class DBEmployeeType extends  DBConnection {
    public void insert (EmployeeType employeeType)
    {
            connect();
            try {
                String sql =  "Insert into employee_type (descript) values(?)";
                PreparedStatement preparedStatement =   connection.prepareStatement (sql);
                preparedStatement.setString (1, employeeType.getDescript() );
                preparedStatement.setString (1, employeeType.getDescript() );
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                        MessageUtils.showErrorMessage("Error al insertar tipo de empleado" + e.getMessage());
            }finally {
                disconnect();
            }        
   }
    
     public void update(EmployeeType employeeType)
    {
        try {
            connect();
            String sql = "Update employee_type set descript = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employeeType.getDescript());
            preparedStatement.setInt(2, employeeType.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al actualizar tipo de empleado " +
                    e.getMessage());
        } finally{
            disconnect();
        }
    }
 public void delete(int id)
    {
        try {
            connect();
            String sql = "delete from employee_type where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al eliminar tipo de empleado" + e.getMessage());
        }
        finally{
            disconnect();
        }

    }
    public List<EmployeeType> findALL()
    {
        List<EmployeeType> results = new ArrayList<>();
        try {
            connect();
            String sql = "select * from employee_type";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                EmployeeType employeeType = new EmployeeType();
                employeeType.setId(resultSet.getInt("id"));
                employeeType.setDescript(resultSet.getString("descript"));
                results.add(employeeType);
            }
            resultSet.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar tipos de empleado" +
                                            e.getMessage());
        } finally {
            disconnect();
        }
        return results;
    }

 public EmployeeType findById(int id)
    {
        EmployeeType employeeType = null;
        try {
            connect();
            String sql = "select * from employee_type where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            
            if (resultSet.next()) {
                employeeType = new EmployeeType();
                employeeType.setId(resultSet.getInt("id"));
                employeeType.setDescript(resultSet.getString("descript"));
            }
            
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar tipos de empleado" +
                                            e.getMessage());
        } finally {
            disconnect();
        }
        return employeeType;
    }
}
