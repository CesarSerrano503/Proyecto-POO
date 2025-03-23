// Código hecho por (Sara Yamileth Torres Henriquez)
package multiworks;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AsignacionActividadFrame extends JFrame {

    // Lista para almacenar objetos AsignacionActividad
    private final List<AsignacionActividad> listaAsignaciones = new ArrayList<>();
    // Modelo de datos para la tabla
    private final DefaultTableModel tableModel;

    public AsignacionActividadFrame() {
        // Configuración de la ventana principal
        setTitle("Asignaciones de Actividades");
        setSize(750, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
        setResizable(false);

        // Panel principal con BorderLayout
        JPanel panel = new JPanel(new BorderLayout(10, 10)); // Espacio entre componentes
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes

        // Título de la ventana
        JLabel titulo = new JLabel("Lista de Asignaciones", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        // Columnas de la tabla
        String[] columnas = {
            "ID", "ID Cotización", "ID Empleado", "Área", "Costo/Hora", "Inicio",
            "Fin", "Horas", "Base", "Extra %", "Total"
        };

        // Modelo de tabla y tabla
        tableModel = new DefaultTableModel(columnas, 0); // 0 filas iniciales
        JTable tabla = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tabla); // Scroll si hay muchos datos
        panel.add(scroll, BorderLayout.CENTER);

        // Panel para los botones
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Alineación derecha
        JButton btnRegistrar = new JButton("Registrar nueva asignación");
        JButton btnVolver = new JButton("Volver al menú");

        botones.add(btnRegistrar);
        botones.add(btnVolver);
        panel.add(botones, BorderLayout.SOUTH);

        // Eventos de los botones
        btnRegistrar.addActionListener(e -> abrirFormulario());
        btnVolver.addActionListener(e -> dispose()); // Cierra la ventana actual

        add(panel); // Añade el panel principal a la ventana
        setVisible(true); // Muestra la ventana
    }

    // Método para abrir el formulario de registro
    private void abrirFormulario() {
        JDialog dialog = new JDialog(this, "Registrar Asignación", true); // Modal
        dialog.setSize(450, 500);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);

        // Panel para el formulario con GridLayout
        JPanel form = new JPanel(new GridLayout(11, 2, 10, 10)); // Filas, columnas, espacios
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes

        // Campos de texto para los datos de la asignación
        JTextField txtIdCotizacion = new JTextField();
        JTextField txtIdEmpleado = new JTextField();
        JTextField txtArea = new JTextField();
        JTextField txtCostoHora = new JTextField();
        JTextField txtInicio = new JTextField("2025-03-25T08:00"); // Ejemplo de fecha/hora
        JTextField txtFin = new JTextField("2025-03-25T17:00"); // Ejemplo de fecha/hora
        JTextField txtHoras = new JTextField();
        JTextField txtBase = new JTextField();
        txtBase.setEditable(false); // No editable
        JTextField txtExtra = new JTextField();
        JTextField txtTotal = new JTextField();
        txtTotal.setEditable(false); // No editable

        // Botón para calcular y guardar
        JButton btnCalcular = new JButton("Calcular y Guardar");

        // Añadir campos y etiquetas al formulario
        form.add(new JLabel("ID Cotización:")); form.add(txtIdCotizacion);
        form.add(new JLabel("ID Empleado:")); form.add(txtIdEmpleado);
        form.add(new JLabel("Área Asignada:")); form.add(txtArea);
        form.add(new JLabel("Costo por Hora:")); form.add(txtCostoHora);
        form.add(new JLabel("Fecha/Hora Inicio (YYYY-MM-DDTHH:MM):")); form.add(txtInicio);
        form.add(new JLabel("Fecha/Hora Fin (YYYY-MM-DDTHH:MM):")); form.add(txtFin);
        form.add(new JLabel("Cantidad de Horas:")); form.add(txtHoras);
        form.add(new JLabel("Costo Base:")); form.add(txtBase);
        form.add(new JLabel("Incremento Extra (%):")); form.add(txtExtra);
        form.add(new JLabel("Costo Total:")); form.add(txtTotal);
        form.add(new JLabel()); form.add(btnCalcular); // Espacio en blanco y botón

        // Evento del botón "Calcular y Guardar"
        btnCalcular.addActionListener(e -> {
            try {
                // Obtener datos de los campos de texto
                int idCot = Integer.parseInt(txtIdCotizacion.getText());
                int idEmp = Integer.parseInt(txtIdEmpleado.getText());
                String area = txtArea.getText();
                double costoHora = Double.parseDouble(txtCostoHora.getText());
                LocalDateTime inicio = LocalDateTime.parse(txtInicio.getText());
                LocalDateTime fin = LocalDateTime.parse(txtFin.getText());
                double horas = Double.parseDouble(txtHoras.getText());
                double base = costoHora * horas;
                double extra = Double.parseDouble(txtExtra.getText());
                double total = base + (base * extra / 100);

                // Mostrar resultados en los campos de texto
                txtBase.setText(String.format("%.2f", base));
                txtTotal.setText(String.format("%.2f", total));

                // Crear objeto AsignacionActividad
                AsignacionActividad asignacion = new AsignacionActividad(
                    listaAsignaciones.size() + 1, idCot, idEmp, area, costoHora,
                    inicio, fin, horas, base, extra, total
                );

                // Añadir a la lista y actualizar la tabla
                listaAsignaciones.add(asignacion);
                asignacion.asignarActividad(); // Llama al método asignarActividad() (supongo que existe)
                actualizarTabla();

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(dialog, "✅ Asignación registrada correctamente");
                dialog.dispose(); // Cierra el diálogo
            } catch (Exception ex) {
                // Mostrar mensaje de error
                JOptionPane.showMessageDialog(dialog, "❌ Error: " + ex.getMessage());
            }
        });

        dialog.add(form); // Añade el formulario al diálogo
        dialog.setVisible(true); // Muestra el diálogo
    }

    // Método para actualizar la tabla con los datos de la lista
    private void actualizarTabla() {
        tableModel.setRowCount(0); // Limpia la tabla
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); // Formato de fecha/hora

        // Añade cada asignación como una fila en la tabla
        for (AsignacionActividad a : listaAsignaciones) {
            tableModel.addRow(new Object[]{
                a.getIdAsignacion(),
                a.getIdCotizacion(),
                a.getIdEmpleado(),
                a.getAreaAsignada(),
                a.getCostoHora(),
                a.getFechaHoraInicio().format(dtf),
                a.getFechaHoraFin().format(dtf),
                a.getCantidadHoras(),
                a.getCostoBase(),
                a.getIncrementoExtra(),
                a.getCostoTotal()
            });
        }
    }
}