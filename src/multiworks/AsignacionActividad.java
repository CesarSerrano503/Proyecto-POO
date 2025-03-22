package multiworks;

import java.util.Date;

public class AsignacionActividad {
    private int idAsignacion;
    private int idCotizacion;
    private int idEmpleado;
    private String areaAsignada;
    private double costoHora;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    private double cantidadHoras;
    private double costoBase;
    private double incrementoExtra;
    private double costoTotal;
    public int getIdAsignacion() {
        return idAsignacion;
    }


    public AsignacionActividad(int idAsignacion, int idCotizacion, int idEmpleado, String areaAsignada,
                               double costoHora, double cantidadHoras, double incrementoExtra) {
        this.idAsignacion = idAsignacion;
        this.idCotizacion = idCotizacion;
        this.idEmpleado = idEmpleado;
        this.areaAsignada = areaAsignada;
        this.costoHora = costoHora;
        this.cantidadHoras = cantidadHoras;
        this.incrementoExtra = incrementoExtra;
        this.fechaHoraInicio = new Date();
        this.fechaHoraFin = null;
        this.costoBase = costoHora * cantidadHoras;
        this.costoTotal = 0.0;
    }

    public void asignarActividad() {
        System.out.println("🔧 Actividad asignada al empleado ID " + idEmpleado + " en área: " + areaAsignada);
    }

    public void calcularCostoTotal() {
        double extra = costoBase * (incrementoExtra / 100);
        costoTotal = costoBase + extra;
        System.out.println("💲 Costo total de la asignación: $" + costoTotal);
    }

    public double getCostoTotal() {
        return costoTotal;
    }
}
