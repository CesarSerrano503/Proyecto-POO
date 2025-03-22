package multiworks;

import java.util.Date;

public class Cotizacion {
    private int idCotizacion;
    private int idCliente;
    private Date fechaCreacion;
    private String estado;
    private double costoTotal;

    public Cotizacion(int idCotizacion, int idCliente) {
        this.idCotizacion = idCotizacion;
        this.idCliente = idCliente;
        this.fechaCreacion = new Date();
        this.estado = "En proceso";
        this.costoTotal = 0.0;
    }

    public void crearCotizacion() {
        System.out.println("🧾 Cotización creada para Cliente ID: " + idCliente);
    }

    public void calcularCosto(double base, double extra) {
        this.costoTotal = base + extra;
        System.out.println("💰 Costo total actualizado: $" + costoTotal);
    }

    public void finalizarCotizacion() {
        this.estado = "Finalizada";
        System.out.println("✅ Cotización finalizada.");
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }
}
