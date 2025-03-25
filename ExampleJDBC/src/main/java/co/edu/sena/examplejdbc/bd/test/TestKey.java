/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.test;
import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 *fecha: 18/3/2025
 * @author rojas
 * Objetivo: Validar la correcta implementación de las operaciones CRUD (Crear, Leer, Actualizar y Eliminar)
 * sobre la tabla key en la base de datos mediante la clase DBKey.
 */
public class TestKey {
    public static void main(String[] args) {
        DBKey dBKey = new DBKey();
        //insertar
        Key key = new Key(0, "BICENTENARIO AMBIENTE 02", "Sala 202", 2, "Llavero con 2 llaves negras");
        dBKey.insert(key);
       
        //actualizar
        key.setId(6);
        key.setName("INFORMATICA 3");
        key.setRoom("Sala informatica 3");
        key.setCount(3);
        key.setObservation("Con 2 llaves");
        dBKey.update(key);
        
        //eliminar
        dBKey.delete(12);
        
        //consultar todos
          List<Key> listkKeys = dBKey.findALL();
        for (Key e : listkKeys) {
            System.out.println("id: " + e.getId() + " name: " + e.getName() + "room: " + e.getRoom() + "count: " + e.getCount()
            + "observation: " + e.getObservation());
        }
        
        //consultar por id
        System.out.println("");
        Key key2 = dBKey.findById(5);
        if(key2 != null)
        {
        System.out.println("id: " + key2.getId() +  " name: " + key2.getName() + "room: " + key2.getRoom() + "count: " +
         key2.getCount() + "observation: " + key2.getObservation());
        }
        else
        {
            System.out.println("No existe llaves con ese id");
        }

    }
        
    }
