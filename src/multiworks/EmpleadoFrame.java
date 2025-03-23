// Código hecho por (Cesar Antonio Serrano Gutierrez)

// Paquete donde se encuentra esta clase
package multiworks;

// Importación de librerías necesarias para GUI (Swing) y estructuras de datos
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Clase principal que extiende JFrame: representa la ventana de listado de empleados
public class EmpleadoFrame extends JFrame {

    // Lista que almacena los empleados registrados en tiempo de ejecución
    private final List<Empleado> listaEmpleados = new ArrayList<>();

    // Modelo de tabla que se usará para mostrar los datos en el JTable
    private final DefaultTableModel tableModel;

    // Constructor de la ventana
    public EmpleadoFrame() {
        // Configuración básica de la ventana
        setTitle("Empleados Registrados");
        setSize(650, 400);
        setLocationRelativeTo(null);  // Centra la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        // Panel principal con bordes y diseño de BorderLayout
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Etiqueta de título
        JLabel titulo = new JLabel("Lista de Empleados", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        // Encabezados de columnas de la tabla
        String[] columnas = {"ID", "Nombre", "DUI", "Tipo Persona", "Contratación"};
        tableModel = new DefaultTableModel(columnas, 0);
        JTable tablaEmpleados = new JTable(tableModel);  // Tabla con el modelo definido
        JScrollPane scroll = new JScrollPane(tablaEmpleados); // Scroll para la tabla
        panel.add(scroll, BorderLayout.CENTER);  // Se coloca en el centro del panel

        // Panel para los botones de acciones
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnRegistrar = new JButton("Registrar nuevo empleado");
        JButton btnVolver = new JButton("Volver al menú");

        botones.add(btnRegistrar);
        botones.add(btnVolver);
        panel.add(botones, BorderLayout.SOUTH);  // Se coloca al sur del panel

        // Acción al presionar el botón "Registrar"
        btnRegistrar.addActionListener(e -> abrirFormulario());

        // Cierra la ventana actual al presionar "Volver"
        btnVolver.addActionListener(e -> dispose());

        add(panel);       // Agrega el panel a la ventana
        setVisible(true); // Muestra la ventana
    }

    // Método que abre un formulario para registrar un nuevo empleado
    private void abrirFormulario() {
        // Diálogo modal (ventana flotante)
        JDialog dialog = new JDialog(this, "Registrar Empleado", true);
        dialog.setSize(400, 450);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);

        // Formulario con diseño de cuadrícula
        JPanel form = new JPanel(new GridLayout(8, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Campos del formulario
        JTextField txtNombre = new JTextField();
        JTextField txtDui = new JTextField();
        JComboBox<String> cbTipo = new JComboBox<>(new String[]{"Natural", "Jurídica"});
        JComboBox<String> cbContratacion = new JComboBox<>(new String[]{"Permanente", "Outsourcing"});
        JTextField txtTelefono = new JTextField();
        JTextField txtCorreo = new JTextField();
        JTextField txtDireccion = new JTextField();

        JButton btnGuardar = new JButton("Guardar");

        // Agregar etiquetas y campos al formulario
        form.add(new JLabel("Nombre:")); form.add(txtNombre);
        form.add(new JLabel("DUI:")); form.add(txtDui);
        form.add(new JLabel("Tipo Persona:")); form.add(cbTipo);
        form.add(new JLabel("Tipo Contratación:")); form.add(cbContratacion);
        form.add(new JLabel("Teléfono:")); form.add(txtTelefono);
        form.add(new JLabel("Correo:")); form.add(txtCorreo);
        form.add(new JLabel("Dirección:")); form.add(txtDireccion);
        form.add(new JLabel()); form.add(btnGuardar);  // Botón de guardar alineado

        // Acción al presionar "Guardar"
        btnGuardar.addActionListener(e -> {
            // Se obtienen los valores de los campos
            String nombre = txtNombre.getText().trim();
            String dui = txtDui.getText().trim();
            String tipo = (String) cbTipo.getSelectedItem();
            String contratacion = (String) cbContratacion.getSelectedItem();
            String telefono = txtTelefono.getText().trim();
            String correo = txtCorreo.getText().trim();
            String direccion = txtDireccion.getText().trim();

            // Validaciones de campos
            if (!nombre.matches("^[a-zA-ZÁÉÍÓÚáéíóúÑñ\\s]+$")) {
                JOptionPane.showMessageDialog(dialog, "❌ El nombre solo puede contener letras y espacios.");
                return;
            }

            if (!dui.matches("\\d{8,10}")) {
                JOptionPane.showMessageDialog(dialog, "❌ El DUI debe contener solo números (8 a 10 dígitos).");
                return;
            }

            if (!telefono.matches("\\d{8,}")) {
                JOptionPane.showMessageDialog(dialog, "❌ El teléfono debe contener al menos 8 números.");
                return;
            }

            if (!correo.contains("@")) {
                JOptionPane.showMessageDialog(dialog, "❌ El correo debe contener un '@'.");
                return;
            }

            // Se crea un nuevo objeto Empleado
            Empleado empleado = new Empleado(
                    listaEmpleados.size() + 1,  // ID autogenerado
                    nombre, dui, tipo, contratacion,
                    telefono, correo, direccion, "cesar"  // Usuario creador por defecto
            );

            // Se agrega el empleado a la lista y se actualiza la tabla
            listaEmpleados.add(empleado);
            empleado.registrarEmpleado();  // Muestra info en consola
            actualizarTabla();  // Refresca la tabla en pantalla

            // Mensaje de éxito y cierre del formulario
            JOptionPane.showMessageDialog(dialog, "✅ Empleado registrado correctamente");
            dialog.dispose();
        });

        dialog.add(form);         // Se añade el formulario al diálogo
        dialog.setVisible(true);  // Se muestra el diálogo
    }

    // Método que actualiza la tabla con los empleados registrados
    private void actualizarTabla() {
        tableModel.setRowCount(0);  // Limpia las filas existentes
        for (Empleado e : listaEmpleados) {
            tableModel.addRow(new Object[]{   // Agrega cada empleado a la tabla
                    e.getIdEmpleado(),
                    e.getNombre(),
                    e.getDui(),
                    e.getTipoPersona(),
                    e.getTipoContratacion()
            });
        }
    }
}
