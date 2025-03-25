/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.model;

/**
 * @author rojas
 * objetivo: Creamos los parametros de la tabla key
 * fecha: 18/3/2025
 */
public class Key {
    
    private int id;
    private String name;
    private String room;
    private int count;
    private String observation;

    public Key() {
    }

    public Key(int id, String name, String room, int count, String observation) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.count = count;
        this.observation = observation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
    
    
}
