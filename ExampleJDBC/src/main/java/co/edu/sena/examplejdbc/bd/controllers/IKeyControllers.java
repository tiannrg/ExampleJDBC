/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.controllers;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 *
 * @author rojas
 */
public interface IKeyControllers {
    public void insert(Key key) throws Exception;
    public void update(Key key) throws Exception;
    public void delete(int id)throws Exception;
    public List<Key> findALL() throws Exception;
    public Key findById(int id) throws Exception;
}
