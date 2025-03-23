package multiworks;

import java.time.LocalDate;

public class Proyecto {
    private int idProyecto;
    private int idCliente;
    private String nombreProyecto;
    private String estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Proyecto(int idProyecto, int idCliente, String nombreProyecto) {
        this.idProyecto = idProyecto;
        this.idCliente = idCliente;
        this.nombreProyecto = nombreProyecto;
        this.estado = "En desarrollo";
        this.fechaInicio = LocalDate.now();
        this.fechaFin = null;
    }

    public void crearProyecto() {
        System.out.println("✅ Proyecto registrado:");
        System.out.println("ID: " + idProyecto);
        System.out.println("Cliente ID: " + idCliente);
        System.out.println("Nombre: " + nombreProyecto);
        System.out.println("Estado: " + estado);
        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("Fecha de fin: " + (fechaFin != null ? fechaFin : "No definida"));
    }

    // Setters para campos que se asignan luego
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    // Getters para mostrar en la tabla
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
