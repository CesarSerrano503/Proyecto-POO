package multiworks;

import java.util.Date;

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
    private Date fechaCreacion;

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
        this.creadoPor = creadoPor;
        this.estado = "Activo";
        this.fechaCreacion = new Date();
    }

    // Métodos
    public void registrarEmpleado() {
        System.out.println("📌 Empleado registrado: " + nombre);
    }

    public void editarEmpleado(String nuevoNombre) {
        this.nombre = nuevoNombre;
        System.out.println("✏️ Empleado actualizado: " + nombre);
    }

    public void inactivarEmpleado() {
        this.estado = "Inactivo";
        System.out.println("🛑 Empleado inactivado.");
    }

    // Getters útiles
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }
}
