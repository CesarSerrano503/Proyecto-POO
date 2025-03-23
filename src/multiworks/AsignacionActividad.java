import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
    // Atributos de la clase Cliente
    private int idCliente;
    private String nombre;
    private String dui;
    private String tipoPersona;
    private String telefono;
    private String correo;
    private String direccion;
    private String estado;
    private String creadoPor;
    private Date fechaCreacion;

    // Lista de cotizaciones asociadas al cliente
    private List<Cotizacion> cotizaciones;
    // Lista de proyectos asociados al cliente
    private List<Proyecto> proyectos;

    // Constructor de la clase Cliente
    public Cliente(int idCliente, String nombre, String dui, String tipoPersona, String telefono, String correo, String direccion, String estado, String creadoPor, Date fechaCreacion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dui = dui;
        this.tipoPersona = tipoPersona;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
        this.creadoPor = creadoPor;
        this.fechaCreacion = fechaCreacion;
        this.cotizaciones = new ArrayList<>();
        this.proyectos = new ArrayList<>();
    }

    // Método para agregar una cotización al cliente
    public void agregarCotizacion(Cotizacion cotizacion) {
        this.cotizaciones.add(cotizacion);
    }

    // Método para agregar un proyecto al cliente
    public void agregarProyecto(Proyecto proyecto) {
        this.proyectos.add(proyecto);
    }

    // Método para obtener información del cliente
    public String obtenerInformacion() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", dui='" + dui + '\'' +
                ", tipoPersona='" + tipoPersona + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", estado='" + estado + '\'' +
                ", creadoPor='" + creadoPor + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }

    // Getters y setters para los atributos de la clase Cliente
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // ... (Getters y setters para los demás atributos)
}