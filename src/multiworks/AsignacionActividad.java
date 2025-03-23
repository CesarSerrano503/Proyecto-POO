package multiworks;

import java.time.LocalDateTime;

public class AsignacionActividad {
    private int idAsignacion;
    private int idCotizacion;
    private int idEmpleado;
    private String areaAsignada;
    private double costoHora;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private double cantidadHoras;
    private double costoBase;
    private double incrementoExtra;
    private double costoTotal;

    public AsignacionActividad(int idAsignacion, int idCotizacion, int idEmpleado, String areaAsignada,
                               double costoHora, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin,
                               double cantidadHoras, double costoBase, double incrementoExtra, double costoTotal) {
        this.idAsignacion = idAsignacion;
        this.idCotizacion = idCotizacion;
        this.idEmpleado = idEmpleado;
        this.areaAsignada = areaAsignada;
        this.costoHora = costoHora;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.cantidadHoras = cantidadHoras;
        this.costoBase = costoBase;
        this.incrementoExtra = incrementoExtra;
        this.costoTotal = costoTotal;
    }

    public void asignarActividad() {
        System.out.println("✅ Asignación registrada:");
        System.out.println("ID Asignación: " + idAsignacion);
        System.out.println("Cotización ID: " + idCotizacion);
        System.out.println("Empleado ID: " + idEmpleado);
        System.out.println("Área: " + areaAsignada);
        System.out.println("Costo por hora: $" + costoHora);
        System.out.println("Inicio: " + fechaHoraInicio);
        System.out.println("Fin: " + fechaHoraFin);
        System.out.println("Horas: " + cantidadHoras);
        System.out.println("Costo base: $" + costoBase);
        System.out.println("Incremento extra: " + incrementoExtra + "%");
        System.out.println("Costo total: $" + costoTotal);
    }

    // Getters
    public int getIdAsignacion() {
        return idAsignacion;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getAreaAsignada() {
        return areaAsignada;
    }

    public double getCostoHora() {
        return costoHora;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public double getCantidadHoras() {
        return cantidadHoras;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public double getIncrementoExtra() {
        return incrementoExtra;
    }

    public double getCostoTotal() {
        return costoTotal;
    }
}
