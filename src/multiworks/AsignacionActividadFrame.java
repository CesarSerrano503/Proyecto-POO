package multiworks;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AsignacionActividadFrame extends JFrame {

    private final List<AsignacionActividad> listaAsignaciones = new ArrayList<>();
    private final DefaultTableModel tableModel;

    public AsignacionActividadFrame() {
        setTitle("Asignaciones de Actividades");
        setSize(750, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel("Lista de Asignaciones", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        String[] columnas = {
                "ID", "ID Cotización", "ID Empleado", "Área", "Costo/Hora", "Inicio",
                "Fin", "Horas", "Base", "Extra %", "Total"
        };

        tableModel = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll, BorderLayout.CENTER);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnRegistrar = new JButton("Registrar nueva asignación");
        JButton btnVolver = new JButton("Volver al menú");

        botones.add(btnRegistrar);
        botones.add(btnVolver);
        panel.add(botones, BorderLayout.SOUTH);

        btnRegistrar.addActionListener(e -> abrirFormulario());
        btnVolver.addActionListener(e -> dispose());

        add(panel);
        setVisible(true);
    }

    private void abrirFormulario() {
        JDialog dialog = new JDialog(this, "Registrar Asignación", true);
        dialog.setSize(450, 500);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);

        JPanel form = new JPanel(new GridLayout(11, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField txtIdCotizacion = new JTextField();
        JTextField txtIdEmpleado = new JTextField();
        JTextField txtArea = new JTextField();
        JTextField txtCostoHora = new JTextField();
        JTextField txtInicio = new JTextField("2025-03-25T08:00");
        JTextField txtFin = new JTextField("2025-03-25T17:00");
        JTextField txtHoras = new JTextField();
        JTextField txtBase = new JTextField();
        txtBase.setEditable(false);
        JTextField txtExtra = new JTextField();
        JTextField txtTotal = new JTextField();
        txtTotal.setEditable(false);

        JButton btnCalcular = new JButton("Calcular y Guardar");

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
        form.add(new JLabel()); form.add(btnCalcular);

        btnCalcular.addActionListener(e -> {
            try {
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

                txtBase.setText(String.format("%.2f", base));
                txtTotal.setText(String.format("%.2f", total));

                AsignacionActividad asignacion = new AsignacionActividad(
                        listaAsignaciones.size() + 1, idCot, idEmp, area, costoHora,
                        inicio, fin, horas, base, extra, total
                );

                listaAsignaciones.add(asignacion);
                asignacion.asignarActividad();
                actualizarTabla();
                JOptionPane.showMessageDialog(dialog, "✅ Asignación registrada correctamente");
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "❌ Error: " + ex.getMessage());
            }
        });

        dialog.add(form);
        dialog.setVisible(true);
    }

    private void actualizarTabla() {
        tableModel.setRowCount(0);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

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
