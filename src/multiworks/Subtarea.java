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
        System.out.println("📌 Subtarea registrada: " + titulo);
    }

    public void editarSubtarea(String nuevoTitulo) {
        this.titulo = nuevoTitulo;
        System.out.println("✏️ Subtarea renombrada a: " + titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public int getIdSubtarea() {
        return idSubtarea;
    }
}
