// Código hecho por (Cesar Antonio Serrano Gutierrez)
package multiworks;

import java.time.LocalDate;

public class Cotizacion {
    private int idCotizacion;
    private int idCliente;
    private String estado;
    private double costoTotal;
    private LocalDate fechaCreacion;

    public Cotizacion(int idCotizacion, int idCliente, String estado, double costoTotal, LocalDate fechaCreacion) {
        this.idCotizacion = idCotizacion;
        this.idCliente = idCliente;
        this.estado = estado;
        this.costoTotal = costoTotal;
        this.fechaCreacion = fechaCreacion;
    }

    public void crearCotizacion() {
        System.out.println("✅ Cotización registrada:");
        System.out.println("ID: " + idCotizacion);
        System.out.println("Cliente ID: " + idCliente);
        System.out.println("Estado: " + estado);
        System.out.println("Costo Total: $" + costoTotal);
        System.out.println("Fecha de Creación: " + fechaCreacion);
    }

    // Getters para mostrar en tabla
    public int getIdCotizacion() {
        return idCotizacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getEstado() {
        return estado;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
}
