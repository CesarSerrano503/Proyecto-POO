package multiworks;

public class Subtarea {
    private int idSubtarea;
    private int idAsignacion;
    private String titulo;
    private String descripcion;

    public Subtarea(int idSubtarea, int idAsignacion, String titulo, String descripcion) {
        this.idSubtarea = idSubtarea;
        this.idAsignacion = idAsignacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public void registrarSubtarea() {
        System.out.println("✅ Subtarea registrada:");
        System.out.println("ID Subtarea: " + idSubtarea);
        System.out.println("ID Asignación: " + idAsignacion);
        System.out.println("Título: " + titulo);
        System.out.println("Descripción: " + descripcion);
    }

    // Getters para la tabla
    public int getIdSubtarea() {
        return idSubtarea;
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
