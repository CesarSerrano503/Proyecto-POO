// Código hecho por (Cesar Antonio Serrano Gutierrez)
package multiworks;

// Importaciones necesarias para la interfaz gráfica y estructuras de datos
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Clase que representa la ventana para visualizar y registrar subtareas
public class SubtareaFrame extends JFrame {

    // Lista donde se almacenan las subtareas ingresadas
    private final List<Subtarea> listaSubtareas = new ArrayList<>();

    // Modelo de tabla que muestra las subtareas en pantalla
    private final DefaultTableModel tableModel;

    // Constructor de la ventana principal de subtareas
    public SubtareaFrame() {
        setTitle("Subtareas Registradas");
        setSize(650, 400);
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        setResizable(false); // Impide que se redimensione

        // Panel principal con diseño de bordes y espacios
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Título en la parte superior
        JLabel titulo = new JLabel("Lista de Subtareas", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        // Definición de columnas para la tabla
        String[] columnas = {"ID", "ID Asignación", "Título", "Descripción"};
        tableModel = new DefaultTableModel(columnas, 0);

        // Tabla que muestra las subtareas registradas
        JTable tabla = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll, BorderLayout.CENTER);

        // Panel con botones de acción
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnRegistrar = new JButton("Registrar nueva subtarea");
        JButton btnVolver = new JButton("Volver al menú");

        botones.add(btnRegistrar);
        botones.add(btnVolver);
        panel.add(botones, BorderLayout.SOUTH);

        // Acciones de los botones
        btnRegistrar.addActionListener(e -> abrirFormulario());
        btnVolver.addActionListener(e -> dispose());

        // Agrega el panel al frame y lo hace visible
        add(panel);
        setVisible(true);
    }

    // Método que abre el formulario para registrar una nueva subtarea
    private void abrirFormulario() {
        // Diálogo modal para ingresar los datos
        JDialog dialog = new JDialog(this, "Registrar Subtarea", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);

        // Panel del formulario con diseño en cuadrícula
        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Campos del formulario
        JTextField txtIdAsignacion = new JTextField();
        JTextField txtTitulo = new JTextField();
        JTextArea txtDescripcion = new JTextArea(3, 20); // Área de texto para descripción
        JScrollPane descripcionScroll = new JScrollPane(txtDescripcion); // Scroll por si hay mucho texto
        JButton btnGuardar = new JButton("Guardar");

        // Agrega los elementos al formulario
        form.add(new JLabel("ID Asignación:")); form.add(txtIdAsignacion);
        form.add(new JLabel("Título:")); form.add(txtTitulo);
        form.add(new JLabel("Descripción:")); form.add(descripcionScroll);
        form.add(new JLabel()); form.add(btnGuardar); // Espacio vacío para alinear el botón

        // Acción del botón Guardar
        btnGuardar.addActionListener(e -> {
            try {
                // Obtención y validación de datos
                int idAsignacion = Integer.parseInt(txtIdAsignacion.getText().trim());
                String titulo = txtTitulo.getText().trim();
                String descripcion = txtDescripcion.getText().trim();

                if (titulo.isEmpty() || descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "❌ El título y la descripción son obligatorios.");
                    return;
                }

                // Crea un nuevo objeto Subtarea y lo guarda en la lista
                Subtarea subtarea = new Subtarea(
                        listaSubtareas.size() + 1, // ID autogenerado
                        idAsignacion,
                        titulo,
                        descripcion
                );

                // Guarda e imprime en consola
                listaSubtareas.add(subtarea);
                subtarea.registrarSubtarea();
                actualizarTabla();
                JOptionPane.showMessageDialog(dialog, "✅ Subtarea registrada correctamente");
                dialog.dispose(); // Cierra el formulario

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "❌ El ID de asignación debe ser numérico.");
            }
        });

        dialog.add(form);         // Agrega el formulario al diálogo
        dialog.setVisible(true);  // Muestra el diálogo
    }

    // Método para actualizar la tabla con los datos de la lista
    private void actualizarTabla() {
        tableModel.setRowCount(0); // Limpia la tabla antes de llenarla
        for (Subtarea s : listaSubtareas) {
            tableModel.addRow(new Object[]{
                    s.getIdSubtarea(),
                    s.getIdAsignacion(),
                    s.getTitulo(),
                    s.getDescripcion()
            });
        }
    }
}
