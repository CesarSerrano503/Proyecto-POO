package multiworks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MainConsola {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String usuarioCorrecto = "cesar";
        String contrasenaCorrecta = "12345";
        int intentos = 0;
        boolean acceso = false;

        while (intentos < 5 && !acceso) {
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();

            if (usuario.equals(usuarioCorrecto) && contrasena.equals(contrasenaCorrecta)) {
                acceso = true;
                System.out.println("✅ Acceso concedido.\n");
            } else {
                intentos++;
                System.out.println("❌ Credenciales incorrectas. Intento " + intentos + "/5\n");
            }
        }

        if (!acceso) {
            System.out.println("🚫 Se agotaron los intentos. Saliendo...");
            return;
        }

        // Listas para almacenar registros
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        ArrayList<Cotizacion> cotizaciones = new ArrayList<>();
        ArrayList<AsignacionActividad> asignaciones = new ArrayList<>();
        ArrayList<Subtarea> subtareas = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\n📋 Menú Principal:");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Empleado");
            System.out.println("3. Registrar Proyecto");
            System.out.println("4. Registrar Cotización");
            System.out.println("5. Registrar Asignación");
            System.out.println("6. Registrar Subtarea");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.println("👤 Registro de Cliente:");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("DUI: ");
                    String dui = scanner.nextLine();
                    System.out.print("Tipo Persona (Natural/Jurídica): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String dir = scanner.nextLine();

                    Cliente cliente = new Cliente(clientes.size() + 1, nombre, dui, tipo, tel, correo, dir, "cesar");
                    clientes.add(cliente);
                    cliente.registrarCliente();
                }

                case 2 -> {
                    System.out.println("👨‍💼 Registro de Empleado:");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("DUI: ");
                    String dui = scanner.nextLine();
                    System.out.print("Tipo Persona: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Tipo Contratación: ");
                    String contratacion = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String dir = scanner.nextLine();

                    Empleado emp = new Empleado(empleados.size() + 1, nombre, dui, tipo, contratacion, tel, correo, dir, "cesar");
                    empleados.add(emp);
                    emp.registrarEmpleado();
                }

                case 3 -> {
                    System.out.println("📁 Registro de Proyecto:");
                    System.out.print("ID Cliente: ");
                    int idCliente = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nombre del Proyecto: ");
                    String nombre = scanner.nextLine();
                    Proyecto proyecto = new Proyecto(proyectos.size() + 1, idCliente, nombre);
                    proyecto.setEstado("En desarrollo");
                    proyecto.setFechaInicio(LocalDate.now());
                    proyecto.setFechaFin(LocalDate.now().plusMonths(1));
                    proyectos.add(proyecto);
                    proyecto.crearProyecto();
                }

                case 4 -> {
                    System.out.println("💼 Registro de Cotización:");
                    System.out.print("ID Cliente: ");
                    int idCliente = Integer.parseInt(scanner.nextLine());
                    System.out.print("Estado (En proceso/Finalizada): ");
                    String estado = scanner.nextLine();
                    System.out.print("Costo Total: ");
                    double costo = Double.parseDouble(scanner.nextLine());
                    Cotizacion cot = new Cotizacion(cotizaciones.size() + 1, idCliente, estado, costo, LocalDate.now());
                    cotizaciones.add(cot);
                    cot.crearCotizacion();
                }

                case 5 -> {
                    System.out.println("📌 Registro de Asignación:");
                    System.out.print("ID Cotización: ");
                    int idCot = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID Empleado: ");
                    int idEmp = Integer.parseInt(scanner.nextLine());
                    System.out.print("Área Asignada: ");
                    String area = scanner.nextLine();
                    System.out.print("Costo por Hora: ");
                    double costoHora = Double.parseDouble(scanner.nextLine());
                    System.out.print("Cantidad de Horas: ");
                    double horas = Double.parseDouble(scanner.nextLine());
                    System.out.print("Incremento Extra (%): ");
                    double extra = Double.parseDouble(scanner.nextLine());
                    double base = costoHora * horas;
                    double total = base + (base * extra / 100);
                    AsignacionActividad asignacion = new AsignacionActividad(
                            asignaciones.size() + 1, idCot, idEmp, area, costoHora,
                            LocalDateTime.now(), LocalDateTime.now().plusHours((long) horas),
                            horas, base, extra, total
                    );
                    asignaciones.add(asignacion);
                    asignacion.asignarActividad();
                }

                case 6 -> {
                    System.out.println("📝 Registro de Subtarea:");
                    System.out.print("ID Asignación: ");
                    int idAsig = Integer.parseInt(scanner.nextLine());
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    Subtarea subtarea = new Subtarea(subtareas.size() + 1, idAsig, titulo, descripcion);
                    subtareas.add(subtarea);
                    subtarea.registrarSubtarea();
                }

                case 7 -> System.out.println("👋 Saliendo del sistema...");
                default -> System.out.println("❌ Opción no válida.");
            }

        } while (opcion != 7);

        scanner.close();
    }
}
