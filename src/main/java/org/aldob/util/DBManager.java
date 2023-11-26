package org.aldob.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {

    private static final String user = "postgres";
    private static final String password = "root";
    private static Connection connection;

    // Inicializar la conexion
    public static void getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Usuario", user, password);
            System.out.println("Connection exitosa");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Inserta una persona en la base de datos
    public static void crearPersonas(String nombre, String apellido, int edad){
        try {

            PreparedStatement stmnt = connection.prepareStatement("INSERT INTO PERSONA (nombre, apellido, edad) VALUES (?, ?, ?)");
            stmnt.setString(1, nombre);
            stmnt.setString(2, apellido);
            stmnt.setInt(3, edad);
            stmnt.executeUpdate();
            System.out.println("Persona creada exitosamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Listar personas de la base de datos
    public static void verPersonas(){
        try {
            PreparedStatement stmnt = connection.prepareStatement("SELECT * FROM PERSONA");
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getInt("id") + " | ");
                System.out.print(rs.getString("nombre") + " | ");
                System.out.print(rs.getString("apellido") + " | ");
                System.out.print(rs.getInt("edad") + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Editar personas de la base de datos
    public static void editarPersonas(int id, String nombre, String apellido, int edad){
        try {
            PreparedStatement stmnt = connection.prepareStatement("UPDATE PERSONA SET nombre = ?, apellido = ?, edad = ? WHERE id = ?");
            stmnt.setString(1, nombre);
            stmnt.setString(2, apellido);
            stmnt.setInt(3, edad);
            stmnt.setInt(4, id);
            stmnt.executeUpdate();
            System.out.println("Persona editada exitosamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Eliminar personas de la base de datos
    public static void eliminarPersonas(int id){
        try {
            PreparedStatement stmnt = connection.prepareStatement("DELETE FROM PERSONA WHERE id = ?");
            stmnt.setInt(1, id);
            stmnt.executeUpdate();
            System.out.println("Persona eliminada exitosamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Cerar la conexion
    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada");
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }



}
