package multiworks;

import java.time.LocalDate;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String dui;
    private String tipoPersona;
    private String tipoContratacion;
    private String telefono;
    private String correo;
    private String direccion;
    private String estado;
    private String creadoPor;
    private LocalDate fechaCreacion;

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
        this.estado = "Activo";
        this.creadoPor = creadoPor;
        this.fechaCreacion = LocalDate.now();
    }

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

    // Getters para mostrar en tabla
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
