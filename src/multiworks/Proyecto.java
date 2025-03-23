// Código hecho por (Cesar Antonio Serrano Gutierrez)
package multiworks;

// Importación para manejar fechas
import java.time.LocalDate;

// Clase que representa un proyecto dentro del sistema
public class Proyecto {

    // Atributos privados del proyecto
    private int idProyecto;              // Identificador único del proyecto
    private int idCliente;               // ID del cliente asociado al proyecto
    private String nombreProyecto;       // Nombre del proyecto
    private String estado;               // Estado actual del proyecto (Ej: En desarrollo, Finalizado)
    private LocalDate fechaInicio;       // Fecha en que inicia el proyecto
    private LocalDate fechaFin;          // Fecha en que finaliza el proyecto

    // Constructor que inicializa un nuevo proyecto
    public Proyecto(int idProyecto, int idCliente, String nombreProyecto) {
        this.idProyecto = idProyecto;
        this.idCliente = idCliente;
        this.nombreProyecto = nombreProyecto;
        this.estado = "En desarrollo";            // Estado por defecto al crear
        this.fechaInicio = LocalDate.now();       // Fecha actual del sistema como fecha de inicio
        this.fechaFin = null;                     // Fecha fin aún no definida
    }

    // Método para mostrar en consola los detalles del proyecto registrado
    public void crearProyecto() {
        System.out.println("✅ Proyecto registrado:");
        System.out.println("ID: " + idProyecto);
        System.out.println("Cliente ID: " + idCliente);
        System.out.println("Nombre: " + nombreProyecto);
        System.out.println("Estado: " + estado);
        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("Fecha de fin: " + (fechaFin != null ? fechaFin : "No definida"));
    }

    // Setters para actualizar valores después de la creación

    // Cambiar el estado del proyecto
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Cambiar la fecha de inicio (si es necesario)
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    // Asignar la fecha de finalización del proyecto
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    // Getters para acceder a los atributos desde otras clases o mostrarlos en interfaces

    public int getIdProyecto() {
        return idProyecto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
}
