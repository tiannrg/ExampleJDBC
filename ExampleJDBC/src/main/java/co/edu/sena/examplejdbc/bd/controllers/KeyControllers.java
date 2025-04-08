/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.controllers;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 *fecha 25/3/3035
 * @author rojas
 * objetivo: Implementar la interface para controlar el model Key
 */
public class KeyControllers  implements  IKeyControllers{
    private DBKey dbk = new DBKey();

    @Override
    public void insert(Key key) throws Exception {
          if (key == null)
        {
        throw new Exception("El tipo de llave es nulo");
        }
        
        if ("".equals(key.getName()))
        {
        throw new Exception("El nombre es obligatorio");
        }
        
        if ("".equals(key.getRoom()))
        {
            throw new Exception("El ambiente es obligatorio");
        }
        
        if (key.getCount() <1)
        {
             throw new Exception("La cantidad de llaves es obligatoria");
        }
        
        //insertar 
        dbk.insert(key);
   
        
    }

    @Override
    public void update(Key key) throws Exception {
         if (key == null)
        {
            throw new Exception("El tipo de llave es nulo");
        }
         
         if ("".equals(key.getName()))
             
         {
             throw new Exception("El nombre es obligatorio"); 
         }
         
         if (key.getCount() == 0)
         {
             throw new Exception("El cantidad llaves es obligatoria"); 
         }
         
         //consultar si el key existe en la bd
         
            Key keyExist = dbk.findById(key.getId());
             if (keyExist  == null )
            {
                throw  new Exception("La llave no existe");
            }

        //actualizar      
        dbk.update(key);
    }

    @Override
    public void delete(int id) throws Exception {
           if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        //consultar si el key existe en la bd
        Key keyExist = dbk.findById(id);
        if( keyExist == null)
        {
            throw new Exception("El tipo de llave no existe");
        }
        
        //Eliminar
        dbk.delete(id);

    }


    @Override
    public List<Key> findALL() throws Exception {
        return  dbk.findALL();
    }

    @Override
    public Key findById(int id) throws Exception {
        if(id==0)
        {
            throw  new Exception("El id es obligatorio");
        }
        return dbk.findById(id);
    }

    @Override
    public List<Key> getAllKey() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


