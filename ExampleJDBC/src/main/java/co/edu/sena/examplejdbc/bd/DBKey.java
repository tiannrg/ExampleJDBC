/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import static co.edu.sena.examplejdbc.bd.DBConnection.connection;
import static co.edu.sena.examplejdbc.bd.DBConnection.statement;
import co.edu.sena.examplejdbc.bd.utils.MessageUtils;
import co.edu.sena.examplejdbc.model.Key;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *fecha: 18/03/2025
 * @author rojas
 * objetivo: Implementar las operaciones CRUD (Crear, Leer, Actualizar y Eliminar) para la gestión de llaves en 
 * una base de datos
 */
public class DBKey  extends  DBConnection{
    public void insert (Key key)
    {
        try {
            connect();
                 String sql =  "insert into `key` (name, room, count, observation) values(?, ?, ?, ?)";
                 PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 preparedStatement.setString(1, key.getName() );
                 preparedStatement.setString(2, key.getRoom() );
                 preparedStatement.setInt(3, key.getCount() );
                 preparedStatement.setString(4, key.getObservation() );
                 preparedStatement.executeUpdate();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al insertar llave" + e.getMessage());
        }finally {
            disconnect();
        }
    }
    public void update (Key key)
    {
        try {
            connect();
            String sql = "Update `key` set name = ?, room = ?, count = ?, observation = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key.getName() );
            preparedStatement.setString(2, key.getRoom() );
            preparedStatement.setInt(3, key.getCount() );
            preparedStatement.setString(4, key.getObservation() );
            preparedStatement.setInt(5, key.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al actualizar llave " +
                    e.getMessage());
        } finally {
            disconnect();
        }
        
       
    }
    public void delete(int id)
    {
          try {
              connect();
            String sql = "delete from `key` where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al eliminar llave" + e.getMessage());
        }
        finally{
            disconnect();
        }

    }
    
     public List<Key> findALL()
    {
        List<Key> results = new ArrayList<>();
        try {
            connect();
            String sql = "select * from `key`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
              Key key = new Key();
              key.setId(resultSet.getInt("id"));
              key.setName(resultSet.getString("name"));
              key.setRoom(resultSet.getString("room"));
              key.setCount(resultSet.getInt("count"));
              key.setObservation(resultSet.getString("observation"));
                results.add(key);
            }
            resultSet.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar tipos de llaves" +
                                            e.getMessage());
        } finally {
            disconnect();
        }
        return results;
        
        
    }
     
     public Key findById(int id)
    {
        Key key = null;
       try {
           connect();
            String sql = "select * from `key` where id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
               key = new Key();
               key.setId(resultSet.getInt("id"));
               key.setName(resultSet.getString("name"));
               key.setRoom(resultSet.getString("room"));
               key.setCount(resultSet.getInt("count"));
               key.setObservation(resultSet.getString("observation"));
            }
            
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar llave" +
                                            e.getMessage());
        } finally {
            disconnect();
        }
        return key;
    }

    public Key getKeyById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
    