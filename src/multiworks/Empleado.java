// Código hecho por (Cesar Antonio Serrano Gutierrez)

// Paquete donde se encuentra esta clase
package multiworks;

// Importación de la clase LocalDate para manejar fechas
import java.time.LocalDate;

// Definición de la clase Empleado
public class Empleado {

    // Atributos privados del empleado
    private int idEmpleado;                // Identificador único del empleado
    private String nombre;                // Nombre completo del empleado
    private String dui;                   // Documento Único de Identidad del empleado
    private String tipoPersona;           // Puede representar si es natural o jurídica
    private String tipoContratacion;      // Tipo de contrato (temporal, indefinido, etc.)
    private String telefono;              // Número de teléfono del empleado
    private String correo;                // Dirección de correo electrónico
    private String direccion;             // Dirección física
    private String estado;                // Estado del empleado (activo/inactivo)
    private String creadoPor;             // Usuario que creó el registro
    private LocalDate fechaCreacion;      // Fecha en la que se creó el registro

    // Constructor que inicializa los atributos del empleado
    public Empleado(int idEmpleado, String nombre, String dui, String tipoPersona, String tipoContratacion,
                    String telefono, String correo, String direccion, String creadoPor) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.dui = dui;
        this.tipoPersona = tipoPersona;
        this.tipoContratacion = tipoContratacion;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = "Activo";                   // Se asigna por defecto al crear
        this.creadoPor = creadoPor;
        this.fechaCreacion = LocalDate.now();     // Fecha actual del sistema
    }

    // Método para imprimir por consola los datos del empleado registrado
    public void registrarEmpleado() {
        System.out.println("✅ Empleado registrado:");
        System.out.println("ID: " + idEmpleado);
        System.out.println("Nombre: " + nombre);
        System.out.println("DUI: " + dui);
        System.out.println("Tipo Persona: " + tipoPersona);
        System.out.println("Tipo Contratación: " + tipoContratacion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo: " + correo);
        System.out.println("Dirección: " + direccion);
        System.out.println("Estado: " + estado);
        System.out.println("Creado por: " + creadoPor);
        System.out.println("Fecha de creación: " + fechaCreacion);
    }

    // Métodos "getter" que permiten acceder a atributos privados desde fuera de la clase

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDui() {
        return dui;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public String getTipoContratacion() {
        return tipoContratacion;
    }
}
