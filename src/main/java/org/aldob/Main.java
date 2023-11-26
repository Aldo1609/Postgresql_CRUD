package org.aldob;

import org.aldob.util.DBManager;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        DBManager.getConnection();

        int opcion = 0;
        do {
            System.out.println("\nBienvenido a la base de datos de Aldo");
            System.out.println("1. Ver personas");
            System.out.println("2. Crear persona");
            System.out.println("3. Listar personas");
            System.out.println("4. Eliminar personas");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    verPersonas();
                    break;
                case 2:
                    crearPersonas();
                    break;
                case 3:
                    editarPersonas();
                    break;
                case 4:
                    eliminarPersonas();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 5);
    }

        public static void verPersonas() {
            DBManager.verPersonas();
        }

        public static void crearPersonas() {
            System.out.println("INGRESE EL NOMBRE DE LA PERSONA: ");
            scanner.nextLine();
            String nombre = scanner.nextLine();

            System.out.println("\nINGRESE EL APELLIDO DE LA PERSONA: ");
            String apellido = scanner.nextLine();

            System.out.println("\nINGRESE LA EDAD DE LA PERSONA: ");
            int edad = scanner.nextInt();
            DBManager.crearPersonas(nombre, apellido, edad);
        }

        public static void editarPersonas() {
            System.out.println("Ingrese el ID a editar: ");
            scanner.nextLine();
            int id = scanner.nextInt();

            System.out.println("\nIngrese el nombre: ");
            scanner.nextLine();
            String nombre = scanner.nextLine();

            System.out.println("\nIngrese el apellido: ");
            String apellido = scanner.nextLine();

            System.out.println("\nIngrese la edad: ");
            int edad = scanner.nextInt();

            DBManager.editarPersonas(id, nombre, apellido, edad);

        }

        public static void eliminarPersonas() {
            System.out.println("Ingrese el ID a eliminar: ");
            int id = scanner.nextInt();
            DBManager.eliminarPersonas(id);
        }

}