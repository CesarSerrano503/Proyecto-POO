package multiworks;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuFrame());
    }

    public static class MenuFrame extends JFrame {

        public MenuFrame() {
            setTitle("Menú Principal - MultiWorks");
            setSize(500, 550);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setResizable(false);

            JPanel panel = new JPanel(new BorderLayout());

            JLabel titulo = new JLabel("Menú Principal", SwingConstants.CENTER);
            titulo.setFont(new Font("Arial", Font.BOLD, 22));
            titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
            panel.add(titulo, BorderLayout.NORTH);

            JPanel botonesPanel = new JPanel(new GridLayout(7, 1, 10, 10));
            botonesPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

            JButton btnClientes = new JButton("Clientes");
            JButton btnEmpleados = new JButton("Empleados");
            JButton btnProyectos = new JButton("Proyectos");
            JButton btnCotizaciones = new JButton("Cotizaciones");
            JButton btnAsignaciones = new JButton("Asignaciones");
            JButton btnSubtareas = new JButton("Subtareas");
            JButton btnSalir = new JButton("Salir");

            botonesPanel.add(btnClientes);
            botonesPanel.add(btnEmpleados);
            botonesPanel.add(btnProyectos);
            botonesPanel.add(btnCotizaciones);
            botonesPanel.add(btnAsignaciones);
            botonesPanel.add(btnSubtareas);
            botonesPanel.add(btnSalir);

            panel.add(botonesPanel, BorderLayout.CENTER);
            add(panel);

            // Acciones de los botones
            btnClientes.addActionListener(e -> new ClienteFrame());
            btnEmpleados.addActionListener(e -> new EmpleadoFrame());
            btnProyectos.addActionListener(e -> new ProyectoFrame());
            btnCotizaciones.addActionListener(e -> new CotizacionFrame());
            btnAsignaciones.addActionListener(e -> new AsignacionActividadFrame());
            btnSubtareas.addActionListener(e -> new SubtareaFrame());

            btnSalir.addActionListener(e -> {
                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "¿Seguro que deseas salir?",
                        "Salir",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            });

            setVisible(true);
        }
    }
}
