// Código hecho por (Cesar Antonio Serrano Gutierrez)
package multiworks;

// Clase que representa una subtarea dentro de una asignación
public class Subtarea {

    // Atributos privados de la subtarea
    private int idSubtarea;       // Identificador único de la subtarea
    private int idAsignacion;     // ID de la asignación a la que pertenece
    private String titulo;        // Título corto de la subtarea
    private String descripcion;   // Descripción detallada de la subtarea

    // Constructor: inicializa todos los atributos al crear la subtarea
    public Subtarea(int idSubtarea, int idAsignacion, String titulo, String descripcion) {
        this.idSubtarea = idSubtarea;
        this.idAsignacion = idAsignacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    // Método que muestra la información de la subtarea en consola
    public void registrarSubtarea() {
        System.out.println("✅ Subtarea registrada:");
        System.out.println("ID Subtarea: " + idSubtarea);
        System.out.println("ID Asignación: " + idAsignacion);
        System.out.println("Título: " + titulo);
        System.out.println("Descripción: " + descripcion);
    }

    // Getters: permiten acceder a los datos de la subtarea desde otras clases

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
