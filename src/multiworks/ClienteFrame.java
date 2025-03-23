package multiworks;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteFrame extends JFrame {

    private final List<Cliente> listaClientes = new ArrayList<>();
    private final DefaultTableModel tableModel;

    public ClienteFrame() {
        setTitle("Clientes Registrados");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Título
        JLabel titulo = new JLabel("Lista de Clientes", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        // Tabla de clientes
        String[] columnas = {"ID", "Nombre", "DUI", "Tipo"};
        tableModel = new DefaultTableModel(columnas, 0);
        JTable tablaClientes = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tablaClientes);
        panel.add(scroll, BorderLayout.CENTER);

        // Botones
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnRegistrar = new JButton("Registrar nuevo cliente");
        JButton btnVolver = new JButton("Volver al menú");

        botones.add(btnRegistrar);
        botones.add(btnVolver);
        panel.add(botones, BorderLayout.SOUTH);

        // Acciones
        btnRegistrar.addActionListener(e -> abrirFormulario());
        btnVolver.addActionListener(e -> dispose());

        add(panel);
        setVisible(true);
    }

    private void abrirFormulario() {
        JDialog dialog = new JDialog(this, "Registrar Cliente", true);
        dialog.setSize(400, 400);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);

        JPanel form = new JPanel(new GridLayout(7, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField txtNombre = new JTextField();
        JTextField txtDui = new JTextField();
        JComboBox<String> cbTipo = new JComboBox<>(new String[]{"Natural", "Jurídica"});
        JTextField txtTelefono = new JTextField();
        JTextField txtCorreo = new JTextField();
        JTextField txtDireccion = new JTextField();

        JButton btnGuardar = new JButton("Guardar");

        form.add(new JLabel("Nombre:")); form.add(txtNombre);
        form.add(new JLabel("DUI:")); form.add(txtDui);
        form.add(new JLabel("Tipo Persona:")); form.add(cbTipo);
        form.add(new JLabel("Teléfono:")); form.add(txtTelefono);
        form.add(new JLabel("Correo:")); form.add(txtCorreo);
        form.add(new JLabel("Dirección:")); form.add(txtDireccion);
        form.add(new JLabel()); form.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String dui = txtDui.getText().trim();
            String tipo = (String) cbTipo.getSelectedItem();
            String telefono = txtTelefono.getText().trim();
            String correo = txtCorreo.getText().trim();
            String direccion = txtDireccion.getText().trim();

            // Validaciones
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

            // Si pasa todas las validaciones
            Cliente cliente = new Cliente(
                    listaClientes.size() + 1,
                    nombre, dui, tipo, telefono, correo, direccion, "cesar"
            );

            listaClientes.add(cliente);
            cliente.registrarCliente();
            actualizarTabla();
            JOptionPane.showMessageDialog(dialog, "✅ Cliente registrado correctamente");
            dialog.dispose();
        });

        dialog.add(form);
        dialog.setVisible(true);
    }

    private void actualizarTabla() {
        tableModel.setRowCount(0);
        for (Cliente c : listaClientes) {
            tableModel.addRow(new Object[]{c.getIdCliente(), c.getNombre(), c.getDui(), c.getTipoPersona()});
        }
    }
}
