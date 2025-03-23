// Código hecho por (Cesar Antonio Serrano Gutierrez)
package multiworks;

// Librerías necesarias para la interfaz gráfica y manejo de datos
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Clase que representa la ventana de gestión de proyectos
public class ProyectoFrame extends JFrame {

    // Lista de proyectos registrados en tiempo de ejecución
    private final List<Proyecto> listaProyectos = new ArrayList<>();

    // Modelo de tabla para mostrar los proyectos en un JTable
    private final DefaultTableModel tableModel;

    // Constructor de la ventana
    public ProyectoFrame() {
        // Configuración básica de la ventana
        setTitle("Proyectos Registrados");
        setSize(650, 400);
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); // Evita que se redimensione

        // Panel principal con espacios y diseño BorderLayout
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Título de la ventana
        JLabel titulo = new JLabel("Lista de Proyectos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        // Encabezados de la tabla
        String[] columnas = {"ID", "Nombre", "Cliente ID", "Estado", "Inicio", "Fin"};
        tableModel = new DefaultTableModel(columnas, 0);

        // Tabla para mostrar los proyectos
        JTable tablaProyectos = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tablaProyectos);
        panel.add(scroll, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnRegistrar = new JButton("Registrar nuevo proyecto");
        JButton btnVolver = new JButton("Volver al menú");

        botones.add(btnRegistrar);
        botones.add(btnVolver);
        panel.add(botones, BorderLayout.SOUTH);

        // Acciones de los botones
        btnRegistrar.addActionListener(e -> abrirFormulario());
        btnVolver.addActionListener(e -> dispose());

        // Se agrega el panel principal a la ventana y se muestra
        add(panel);
        setVisible(true);
    }

    // Método para abrir el formulario de registro de proyecto
    private void abrirFormulario() {
        // Diálogo modal para ingresar los datos del nuevo proyecto
        JDialog dialog = new JDialog(this, "Registrar Proyecto", true);
        dialog.setSize(400, 400);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);

        // Panel del formulario con GridLayout
        JPanel form = new JPanel(new GridLayout(6, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Campos del formulario
        JTextField txtIdCliente = new JTextField();
        JTextField txtNombre = new JTextField();
        JComboBox<String> cbEstado = new JComboBox<>(new String[]{"En desarrollo", "Finalizado"});
        JTextField txtInicio = new JTextField("2025-03-25"); // Valor por defecto
        JTextField txtFin = new JTextField("2025-04-25");   // Valor por defecto
        JButton btnGuardar = new JButton("Guardar");

        // Se agregan etiquetas y campos al formulario
        form.add(new JLabel("ID Cliente:")); form.add(txtIdCliente);
        form.add(new JLabel("Nombre del Proyecto:")); form.add(txtNombre);
        form.add(new JLabel("Estado:")); form.add(cbEstado);
        form.add(new JLabel("Fecha de Inicio (AAAA-MM-DD):")); form.add(txtInicio);
        form.add(new JLabel("Fecha de Fin (AAAA-MM-DD):")); form.add(txtFin);
        form.add(new JLabel()); form.add(btnGuardar); // Botón en última fila

        // Acción al presionar "Guardar"
        btnGuardar.addActionListener(e -> {
            try {
                // Se recuperan y validan los datos ingresados
                int idCliente = Integer.parseInt(txtIdCliente.getText().trim());
                String nombre = txtNombre.getText().trim();
                String estado = (String) cbEstado.getSelectedItem();
                LocalDate fechaInicio = LocalDate.parse(txtInicio.getText().trim());
                LocalDate fechaFin = LocalDate.parse(txtFin.getText().trim());

                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "❌ El nombre del proyecto no puede estar vacío.");
                    return;
                }

                // Se crea el objeto Proyecto y se ajustan atributos
                Proyecto proyecto = new Proyecto(
                        listaProyectos.size() + 1, // ID autogenerado
                        idCliente,
                        nombre
                );
                proyecto.setEstado(estado);
                proyecto.setFechaInicio(fechaInicio);
                proyecto.setFechaFin(fechaFin);

                // Se agrega a la lista, se imprime y se actualiza la tabla
                listaProyectos.add(proyecto);
                proyecto.crearProyecto();
                actualizarTabla();
                JOptionPane.showMessageDialog(dialog, "✅ Proyecto registrado correctamente");
                dialog.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "❌ El ID del cliente debe ser numérico.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "❌ Error: " + ex.getMessage());
            }
        });

        dialog.add(form);
        dialog.setVisible(true);
    }

    // Método para actualizar los datos mostrados en la tabla
    private void actualizarTabla() {
        tableModel.setRowCount(0); // Limpia la tabla
        for (Proyecto p : listaProyectos) {
            tableModel.addRow(new Object[]{
                    p.getIdProyecto(),
                    p.getNombreProyecto(),
                    p.getIdCliente(),
                    p.getEstado(),
                    p.getFechaInicio(),
                    p.getFechaFin()
            });
        }
    }
}
