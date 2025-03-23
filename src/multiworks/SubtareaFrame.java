package multiworks;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SubtareaFrame extends JFrame {

    private final List<Subtarea> listaSubtareas = new ArrayList<>();
    private final DefaultTableModel tableModel;

    public SubtareaFrame() {
        setTitle("Subtareas Registradas");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel("Lista de Subtareas", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        String[] columnas = {"ID", "ID Asignación", "Título", "Descripción"};
        tableModel = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll, BorderLayout.CENTER);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnRegistrar = new JButton("Registrar nueva subtarea");
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
        JDialog dialog = new JDialog(this, "Registrar Subtarea", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField txtIdAsignacion = new JTextField();
        JTextField txtTitulo = new JTextField();
        JTextArea txtDescripcion = new JTextArea(3, 20);
        JScrollPane descripcionScroll = new JScrollPane(txtDescripcion);
        JButton btnGuardar = new JButton("Guardar");

        form.add(new JLabel("ID Asignación:")); form.add(txtIdAsignacion);
        form.add(new JLabel("Título:")); form.add(txtTitulo);
        form.add(new JLabel("Descripción:")); form.add(descripcionScroll);
        form.add(new JLabel()); form.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                int idAsignacion = Integer.parseInt(txtIdAsignacion.getText().trim());
                String titulo = txtTitulo.getText().trim();
                String descripcion = txtDescripcion.getText().trim();

                if (titulo.isEmpty() || descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "❌ El título y la descripción son obligatorios.");
                    return;
                }

                Subtarea subtarea = new Subtarea(
                        listaSubtareas.size() + 1,
                        idAsignacion,
                        titulo,
                        descripcion
                );

                listaSubtareas.add(subtarea);
                subtarea.registrarSubtarea();
                actualizarTabla();
                JOptionPane.showMessageDialog(dialog, "✅ Subtarea registrada correctamente");
                dialog.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "❌ El ID de asignación debe ser numérico.");
            }
        });

        dialog.add(form);
        dialog.setVisible(true);
    }

    private void actualizarTabla() {
        tableModel.setRowCount(0);
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
