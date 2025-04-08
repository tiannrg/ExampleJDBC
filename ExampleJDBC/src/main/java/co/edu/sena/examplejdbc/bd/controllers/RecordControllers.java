/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.controllers;
import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.model.Record;
import java.util.List;

/**
 *fecha 25/3/3035
 * @author rojas
 * objetivo: Implementar la interface para controlar el model Record
 */
public class RecordControllers  implements  IRecordControllers{
  private DBRecord dbr = new DBRecord();

    @Override
    public void insert(Record record) throws Exception {
         if(record == null)
        {
        throw new Exception("El tipo de registro  es nulo");
        }
        
        if("".equals(record.getDateRecord()))
        {
        throw new Exception("La fecha es obligatorio");
        }
        
        if ("".equals(record.getStartTime()))
        {
             throw new Exception("La hora de inicio es obligatoria");
        }
        
        if ("".equals(record.getEndTime()))
        {
             throw new Exception("La hora de fin  es obligatoria");
        }
        
        //FK´s
        
        if (record.getEmployeeId() == null)
        {
               throw new Exception("El id del empleado es obligatorio");
        }
        
        if (record.getKeyId() == null)
        {
               throw new Exception("La llave es obligatoria");
        }
        
        //insertar 
        dbr.insert(record);
   
    }

    @Override
    public void update(Record record) throws Exception {
         if(record == null)
        {
        throw new Exception("El registro  es nulo");
        }

        if(record.getId() == 0)
        {
        throw new Exception("El Id es obligatorio");
        }
        
        if("".equals(record.getDateRecord()))
        {
        throw new Exception("El registro de fecha  es obligatoria");
        }
        
        if("".equals(record.getStartTime()))
        {
             throw new Exception("La hora de inicio  es obligatoria");
        }
        
        if("".equals(record.getEndTime()))
        {
            throw new Exception("La hora de fin  es obligatoria");
        }
         
        if ("".equals(record.getStatus()))
        {
            throw new Exception("El estado  es obligatorio");
        }
        
        //FK's
        
        if(record.getEmployeeId() == null)
        {
            throw new Exception("El id del empleado es obligatoria");
        }
        
        if(record.getKeyId() == null)
        {
             throw new Exception("El id de la llave es obligatoria");
        }
        
        //La FK no es autoincremental, se debe validar existencia del registro
        
        Record recordExist = dbr.findById(record.getId());
        
        if (recordExist == null)
        {
            throw new Exception("No existe un registro con ese Id");
        }

        //actualizar      
        dbr.update(record);
    }

    @Override
    public void delete(int id) throws Exception {
            if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
            
        Record recordExist = dbr.findById(id);
        if (recordExist == null)
        {
            throw new Exception("No existe un registro con ese id");
        }

        //eliminar
        dbr.delete(id);
    }

    @Override
    public List<Record> findALL() throws Exception {
        
        return dbr.findAll();
        
    }

    @Override
    public Record findById(int id) throws Exception {
        Record recordExist = dbr.findById(id);
        if (recordExist == null)
        {
            throw new Exception("No existe un registro con ese Id");
        }
        return dbr.findById(id);
    }

}