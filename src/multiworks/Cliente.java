package multiworks;

import java.time.LocalDate;

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
    private LocalDate fechaCreacion;

    public Cliente(int idCliente, String nombre, String dui, String tipoPersona,
                   String telefono, String correo, String direccion, String creadoPor) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dui = dui;
        this.tipoPersona = tipoPersona;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = "Activo";
        this.creadoPor = creadoPor;
        this.fechaCreacion = LocalDate.now();
    }

    public void registrarCliente() {
        System.out.println("✅ Cliente registrado:");
        System.out.println("ID: " + idCliente);
        System.out.println("Nombre: " + nombre);
        System.out.println("DUI: " + dui);
        System.out.println("Tipo: " + tipoPersona);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo: " + correo);
        System.out.println("Dirección: " + direccion);
        System.out.println("Estado: " + estado);
        System.out.println("Creado por: " + creadoPor);
        System.out.println("Fecha de creación: " + fechaCreacion);
    }

    // Getters para tabla o uso externo
    public int getIdCliente() {
        return idCliente;
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

    public String getEstado() {
        return estado;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
}
