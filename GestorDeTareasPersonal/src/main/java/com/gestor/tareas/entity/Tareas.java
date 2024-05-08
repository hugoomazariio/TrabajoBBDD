package com.gestor.tareas.entity;

public class Tareas {

    private int id;
    private String tarea;
    private String tipo;
    private String importancia;
    private String horario;
    private String duracion;

    public Tareas(int id, String tarea, String tipo, String importancia, String horario, String duracion) {
        this.id = id;
        this.tarea = tarea;
        this.tipo = tipo;
        this.importancia = importancia;
        this.horario = horario;
        this.duracion = duracion;
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

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {

        return String.format("%-4d %-20s %-20s %-15s %-25s %-35s",
                id,
                tarea,
                tipo,
                importancia,
                horario,
                duracion);
    }

}
