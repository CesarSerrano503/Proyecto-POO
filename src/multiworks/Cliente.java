package multiworks;

import java.util.Date;

public class Cliente {
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

    // Constructor
    public Cliente(int idCliente, String nombre, String dui, String tipoPersona, String telefono,
                   String correo, String direccion, String creadoPor) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dui = dui;
        this.tipoPersona = tipoPersona;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = "Activo";
        this.creadoPor = creadoPor;
        this.fechaCreacion = new Date();
    }

    // Método para registrar cliente
    public void registrarCliente() {
        System.out.println("✅ Cliente registrado: " + nombre);
    }

    // Método para editar cliente (solo de ejemplo)
    public void editarCliente(String nuevoNombre, String nuevoCorreo) {
        this.nombre = nuevoNombre;
        this.correo = nuevoCorreo;
        System.out.println("✏️ Cliente actualizado.");
    }

    // Método para inactivar cliente
    public void inactivarCliente() {
        this.estado = "Inactivo";
        System.out.println("⚠️ Cliente inactivado.");
    }

    // Getters necesarios para listados
    public String getNombre() {
        return nombre;
    }

    public String getDui() {
        return dui;
    }

    public String getEstado() {
        return estado;
    }
}
