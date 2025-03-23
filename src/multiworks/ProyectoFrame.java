package multiworks;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProyectoFrame extends JFrame {

    private final List<Proyecto> listaProyectos = new ArrayList<>();
    private final DefaultTableModel tableModel;

    public ProyectoFrame() {
        setTitle("Proyectos Registrados");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel("Lista de Proyectos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        String[] columnas = {"ID", "Nombre", "Cliente ID", "Estado", "Inicio", "Fin"};
        tableModel = new DefaultTableModel(columnas, 0);
        JTable tablaProyectos = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tablaProyectos);
        panel.add(scroll, BorderLayout.CENTER);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnRegistrar = new JButton("Registrar nuevo proyecto");
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
        JDialog dialog = new JDialog(this, "Registrar Proyecto", true);
        dialog.setSize(400, 400);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);

        JPanel form = new JPanel(new GridLayout(6, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField txtIdCliente = new JTextField();
        JTextField txtNombre = new JTextField();
        JComboBox<String> cbEstado = new JComboBox<>(new String[]{"En desarrollo", "Finalizado"});
        JTextField txtInicio = new JTextField("2025-03-25");
        JTextField txtFin = new JTextField("2025-04-25");

        JButton btnGuardar = new JButton("Guardar");

        form.add(new JLabel("ID Cliente:")); form.add(txtIdCliente);
        form.add(new JLabel("Nombre del Proyecto:")); form.add(txtNombre);
        form.add(new JLabel("Estado:")); form.add(cbEstado);
        form.add(new JLabel("Fecha de Inicio (AAAA-MM-DD):")); form.add(txtInicio);
        form.add(new JLabel("Fecha de Fin (AAAA-MM-DD):")); form.add(txtFin);
        form.add(new JLabel()); form.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                int idCliente = Integer.parseInt(txtIdCliente.getText().trim());
                String nombre = txtNombre.getText().trim();
                String estado = (String) cbEstado.getSelectedItem();
                LocalDate fechaInicio = LocalDate.parse(txtInicio.getText().trim());
                LocalDate fechaFin = LocalDate.parse(txtFin.getText().trim());

                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "❌ El nombre del proyecto no puede estar vacío.");
                    return;
                }

                Proyecto proyecto = new Proyecto(
                        listaProyectos.size() + 1,
                        idCliente,
                        nombre
                );

                proyecto.setEstado(estado);
                proyecto.setFechaInicio(fechaInicio);
                proyecto.setFechaFin(fechaFin);

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

    private void actualizarTabla() {
        tableModel.setRowCount(0);
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
