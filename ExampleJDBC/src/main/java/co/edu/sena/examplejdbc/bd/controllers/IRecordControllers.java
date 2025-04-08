/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.controllers;
import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.model.Record;
import java.util.List;

/**
 *
 * @author rojas
 */
public interface IRecordControllers {
     public void insert(Record record) throws Exception;
    public void update(Record record) throws Exception;
    public void delete(int id)throws Exception;
    public List<Record> findALL() throws Exception;
    public Record findById(int id) throws Exception;
}
