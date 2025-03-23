// Código hecho por (Cesar Antonio Serrano Gutierrez)
package multiworks;

// Importación de librerías necesarias para crear interfaces gráficas
import javax.swing.*;
import java.awt.*;

// Clase principal que contiene el método main
public class Main {

    // Método principal del programa: inicia la aplicación gráfica
    public static void main(String[] args) {
        // Se asegura de que la interfaz gráfica se construya en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> new MenuFrame());
    }

    // Clase interna que representa el menú principal de la aplicación
    public static class MenuFrame extends JFrame {

        // Constructor del menú
        public MenuFrame() {
            // Configuración básica de la ventana principal
            setTitle("Menú Principal - MultiWorks");
            setSize(500, 550);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Centra la ventana
            setResizable(false);        // Impide redimensionar

            // Panel principal con BorderLayout
            JPanel panel = new JPanel(new BorderLayout());

            // Título centrado en la parte superior
            JLabel titulo = new JLabel("Menú Principal", SwingConstants.CENTER);
            titulo.setFont(new Font("Arial", Font.BOLD, 22));
            titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
            panel.add(titulo, BorderLayout.NORTH);

            // Panel con los botones del menú en forma de lista vertical
            JPanel botonesPanel = new JPanel(new GridLayout(7, 1, 10, 10));
            botonesPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

            // Botones del menú principal
            JButton btnClientes = new JButton("Clientes");
            JButton btnEmpleados = new JButton("Empleados");
            JButton btnProyectos = new JButton("Proyectos");
            JButton btnCotizaciones = new JButton("Cotizaciones");
            JButton btnAsignaciones = new JButton("Asignaciones");
            JButton btnSubtareas = new JButton("Subtareas");
            JButton btnSalir = new JButton("Salir");

            // Se añaden los botones al panel
            botonesPanel.add(btnClientes);
            botonesPanel.add(btnEmpleados);
            botonesPanel.add(btnProyectos);
            botonesPanel.add(btnCotizaciones);
            botonesPanel.add(btnAsignaciones);
            botonesPanel.add(btnSubtareas);
            botonesPanel.add(btnSalir);

            // Se añade el panel de botones al centro del panel principal
            panel.add(botonesPanel, BorderLayout.CENTER);

            // Se agrega el panel principal al frame
            add(panel);

            // Asignación de acciones a cada botón para abrir las respectivas ventanas
            btnClientes.addActionListener(e -> new ClienteFrame());                // Abre ventana de Clientes
            btnEmpleados.addActionListener(e -> new EmpleadoFrame());              // Abre ventana de Empleados
            btnProyectos.addActionListener(e -> new ProyectoFrame());              // Abre ventana de Proyectos
            btnCotizaciones.addActionListener(e -> new CotizacionFrame());         // Abre ventana de Cotizaciones
            btnAsignaciones.addActionListener(e -> new AsignacionActividadFrame()); // Abre ventana de Asignaciones
            btnSubtareas.addActionListener(e -> new SubtareaFrame());              // Abre ventana de Subtareas

            // Acción para el botón "Salir" con confirmación
            btnSalir.addActionListener(e -> {
                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "¿Seguro que deseas salir?",
                        "Salir",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0); // Cierra el programa
                }
            });

            // Hace visible la ventana
            setVisible(true);
        }
    }
}
