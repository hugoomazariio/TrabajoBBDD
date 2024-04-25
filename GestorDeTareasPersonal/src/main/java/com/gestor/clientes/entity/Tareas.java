
package com.gestor.clientes.entity;


public class Tareas {
    private int id;
    private String tarea; 
    private String tipo; 

    public Tareas(int id, String tarea, String tipo) {
        this.id = id;
        this.tarea = tarea;
        this.tipo = tipo;
    }

    public Tareas(String tarea, String tipo) {
        this.tarea = tarea;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
     @Override
    public String toString() {

        return String.format("%-4d %-20s %-20s %-15s %-25s %-35s",
                id,
                tarea,
                tipo);
    }
    
}
