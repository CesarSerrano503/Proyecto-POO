package multiworks;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CotizacionFrame extends JFrame {

    private final List<Cotizacion> listaCotizaciones = new ArrayList<>();
    private final DefaultTableModel tableModel;

    public CotizacionFrame() {
        setTitle("Cotizaciones Registradas");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel("Lista de Cotizaciones", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        String[] columnas = {"ID", "Cliente ID", "Estado", "Costo Total", "Fecha"};
        tableModel = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll, BorderLayout.CENTER);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnRegistrar = new JButton("Registrar nueva cotización");
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
        JDialog dialog = new JDialog(this, "Registrar Cotización", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField txtIdCliente = new JTextField();
        JComboBox<String> cbEstado = new JComboBox<>(new String[]{"En proceso", "Finalizada"});
        JTextField txtCosto = new JTextField();

        JButton btnGuardar = new JButton("Guardar");

        form.add(new JLabel("ID Cliente:")); form.add(txtIdCliente);
        form.add(new JLabel("Estado:")); form.add(cbEstado);
        form.add(new JLabel("Costo Total:")); form.add(txtCosto);
        form.add(new JLabel()); form.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                int idCliente = Integer.parseInt(txtIdCliente.getText().trim());
                String estado = (String) cbEstado.getSelectedItem();
                double costoTotal = Double.parseDouble(txtCosto.getText().trim());
                LocalDate fecha = LocalDate.now();

                Cotizacion cotizacion = new Cotizacion(
                        listaCotizaciones.size() + 1,
                        idCliente,
                        estado,
                        costoTotal,
                        fecha
                );

                listaCotizaciones.add(cotizacion);
                cotizacion.crearCotizacion();
                actualizarTabla();
                JOptionPane.showMessageDialog(dialog, "✅ Cotización registrada correctamente");
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "❌ El ID del cliente y el costo deben ser numéricos.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "❌ Error: " + ex.getMessage());
            }
        });

        dialog.add(form);
        dialog.setVisible(true);
    }

    private void actualizarTabla() {
        tableModel.setRowCount(0);
        for (Cotizacion c : listaCotizaciones) {
            tableModel.addRow(new Object[]{
                    c.getIdCotizacion(),
                    c.getIdCliente(),
                    c.getEstado(),
                    c.getCostoTotal(),
                    c.getFechaCreacion()
            });
        }
    }
}
