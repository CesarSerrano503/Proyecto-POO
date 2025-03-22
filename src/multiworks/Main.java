package multiworks;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();

        String usuarioCorrecto = "cesar";
        String contrasenaCorrecta = "12345";
        boolean accesoConcedido = false;
        int intentos = 0;

        ArrayList<Cliente> listaClientes = new ArrayList<>();

        System.out.println("🔒 Bienvenido a MultiWorks");

        while (intentos < 5 && !accesoConcedido) {
            System.out.print("Usuario: ");
            String usuarioIngresado = scanner.nextLine();

            String contrasenaIngresada;
            if (console != null) {
                char[] passwordChars = console.readPassword("Contraseña: ");
                contrasenaIngresada = new String(passwordChars);
            } else {
                System.out.print("Contraseña (visible): ");
                contrasenaIngresada = scanner.nextLine();
            }

            if (usuarioIngresado.equals(usuarioCorrecto) && contrasenaIngresada.equals(contrasenaCorrecta)) {
                accesoConcedido = true;
                System.out.println("✅ Acceso concedido.\n");
            } else {
                intentos++;
                System.out.println("❌ Credenciales incorrectas. Intento " + intentos + " de 5.");
                if (intentos == 5) {
                    System.out.println("🚫 Has excedido el número de intentos permitidos.");
                    System.exit(0);
                }
            }
        }

        // Menú principal
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n📋 Menú Principal:");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Empleado");
            System.out.println("3. Registrar Proyecto");
            System.out.println("4. Ver lista de clientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("DUI: ");
                    String duiCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(1, nombreCliente, duiCliente, "Natural", "7777-8888", "cliente@correo.com", "San Salvador", "cesar");
                    cliente.registrarCliente();
                    listaClientes.add(cliente);
                    break;

                case 2:
                    System.out.print("Nombre del empleado: ");
                    String nombreEmpleado = scanner.nextLine();
                    System.out.print("DUI: ");
                    String duiEmpleado = scanner.nextLine();
                    Empleado empleado = new Empleado(1, nombreEmpleado, duiEmpleado, "Natural", "Permanente", "6666-5555", "empleado@correo.com", "Santa Tecla", "cesar");
                    empleado.registrarEmpleado();
                    break;

                case 3:
                    System.out.print("Nombre del proyecto: ");
                    String nombreProyecto = scanner.nextLine();
                    Proyecto proyecto = new Proyecto(1, 1, nombreProyecto); // ID cliente simulado
                    proyecto.crearProyecto();
                    break;

                case 4:
                    System.out.println("\n📄 Lista de Clientes:");
                    if (listaClientes.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                    } else {
                        for (Cliente c : listaClientes) {
                            System.out.println("- " + c.getNombre() + " | DUI: " + c.getDui());
                        }
                    }
                    break;

                case 5:
                    System.out.println("👋 Cerrando sesión. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("❗ Opción no válida.");
            }
        }

        scanner.close();
    }
}
