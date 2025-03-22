package multiworks;

import java.util.Date;

public class Proyecto {
    private int idProyecto;
    private int idCliente;
    private String nombreProyecto;
    private String estado;
    private Date fechaInicio;
    private Date fechaFin;

    public Proyecto(int idProyecto, int idCliente, String nombreProyecto) {
        this.idProyecto = idProyecto;
        this.idCliente = idCliente;
        this.nombreProyecto = nombreProyecto;
        this.fechaInicio = new Date();
        this.estado = "En curso";
    }

    public void crearProyecto() {
        System.out.println("📁 Proyecto creado: " + nombreProyecto);
    }

    public void editarProyecto(String nuevoNombre) {
        this.nombreProyecto = nuevoNombre;
        System.out.println("✏️ Proyecto renombrado a: " + nombreProyecto);
    }

    public void finalizarProyecto() {
        this.estado = "Finalizado";
        this.fechaFin = new Date();
        System.out.println("✅ Proyecto finalizado.");
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public String getEstado() {
        return estado;
    }

    public int getIdProyecto() {
        return idProyecto;
    }
}
