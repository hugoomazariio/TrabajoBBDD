package com.gestor.tareas.service;
import com.gestor.clientes.service.*;
import com.gestor.clientes.database.Conexion;
import com.gestor.tareas.entity.Tareas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    Conexion c = new Conexion();
    public void alta(Tareas t) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        // Conversión de Date a String. tratamiento de la fecha para que sea aceptada por MySQL
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String strFechaFormateada = sdf.format(p.getFechaNacimiento());
        // estring de inserción
        String cadena = "INSERT INTO tareas (tarea, tipo,importancia, horario, duracion) VALUES ('"
                + t.getTarea() + "','"
                + t.getTipo() + "','"
                + t.getImportancia()+ "','"
                + t.getHorario()+ "','"
                + t.getDuracion()+ "');";
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
        consulta.close();
    }
    public List<Tareas> listar() throws SQLException {
        Statement consulta = c.conectar().createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM tareas");
        List<Tareas> lista = new ArrayList<>();

        while (rs.next()) {
            Tareas t = new Tareas(
                    rs.getInt("id"),
                    rs.getString("tarea"),
                    rs.getString("tipo"),
                    rs.getString("importancia"),
                    rs.getString("horario"),
                    rs.getString("duracion")
            );
            lista.add(t);
        }
        rs.close();
        consulta.close();
        return lista;
    }
    public Tareas buscar(int id) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM tareas WHERE id = " + id);
        Tareas p = null;
        if (rs.next()) {
            p = new Tareas(
                    rs.getInt("id"),
                    rs.getString("tarea"),
                    rs.getString("tipo"),
                    rs.getString("importancia"),
                    rs.getString("horario"),
                    rs.getString("duracion")
            );
        }
        rs.close();
        consulta.close();
        return p;
    }
    public void modificar(Tareas t) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        // Conversión de Date a String. tratamiento de la fecha para que sea aceptada por MySQL
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String strFechaFormateada = sdf.format(p.getFechaNacimiento());
        // String de actualización
        String cadena = "UPDATE cliente SET "
                + "Tarea = '" + t.getTarea() + "', "
                + "tipo = '" + t.getTipo()+ "', "
                + " importancia = '" + t.getImportancia()+ "', "
                + "horario = '" + t.getHorario()+ "', "
                + "duracion = '" + t.getDuracion()+ "' "
                + "WHERE id = " + t.getId();
        // System.out.println(cadena);
        consulta.executeUpdate(cadena);
        consulta.close();
    }
    public void eliminar(int id) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        consulta.executeUpdate("DELETE FROM tareas WHERE id = " + id);
        consulta.close();
    }


}
