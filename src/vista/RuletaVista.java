package vista;

import controlador.RuletaControlador;
import modelo.*;

import javax.swing.*;
import java.awt.*;

public class RuletaVista extends JFrame {
    private RuletaControlador controlador;
    private JComboBox<String> comboTipo;
    private JTextField txtMonto;
    private JTextArea areaResultado;

    public RuletaVista() {
        controlador = new RuletaControlador();
        initComponents();
    }

    private void initComponents() {
        setTitle("Ruleta - Mesa de Juego");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelApuesta = new JPanel(new GridLayout(3, 2, 10, 10));
        panelApuesta.setBorder(BorderFactory.createTitledBorder("Realizar Apuesta"));

        panelApuesta.add(new JLabel("Tipo de apuesta:"));
        comboTipo = new JComboBox<>(new String[]{"Rojo", "Negro", "Par", "Impar"});
        panelApuesta.add(comboTipo);

        panelApuesta.add(new JLabel("Monto:"));
        txtMonto = new JTextField("100");
        panelApuesta.add(txtMonto);

        JButton btnJugar = new JButton("Girar Ruleta");
        panelApuesta.add(btnJugar);

        add(panelApuesta, BorderLayout.NORTH);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        btnJugar.addActionListener(e -> jugar());

        setVisible(true);
    }

    private void jugar() {
        try {
            double monto = Double.parseDouble(txtMonto.getText());
            String tipo = (String) comboTipo.getSelectedItem();

            ApuestaBase apuesta = null;
            switch (tipo) {
                case "Rojo":
                    apuesta = new ApuestaRojo(monto);
                    break;
                case "Negro":
                    apuesta = new ApuestaNegro(monto);
                    break;
                case "Par":
                    apuesta = new ApuestaPar(monto);
                    break;
                case "Impar":
                    apuesta = new ApuestaImpar(monto);
                    break;
            }

            Resultado resultado = controlador.jugar(apuesta);
            double ganancia = controlador.calcularGanancia(apuesta, resultado.isAcierto());

            String msg = "Número: " + resultado.getNumero() +
                    "\nColor: " + resultado.getColor() +
                    "\nApuesta: " + apuesta.getEtiqueta() +
                    "\nMonto: $" + monto +
                    "\nResultado: " + (resultado.isAcierto() ? "¡GANASTE!" : "PERDISTE") +
                    "\nGanancia: $" + ganancia +
                    "\n-------------------------\n";

            areaResultado.insert(msg, 0); // nuevo resultado arriba

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Monto inválido");
        }
    }
}