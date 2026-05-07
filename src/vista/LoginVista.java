package vista;

import controlador.LoginControlador;
import javax.swing.*;
import java.awt.*;

public class LoginVista extends JFrame {
    private LoginControlador controlador;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;

    public LoginVista() {
        controlador = new LoginControlador();
        initComponents();
    }

    private void initComponents() {
        setTitle("Login - Ruleta");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Usuario:"), gbc);
        gbc.gridx = 1;
        txtUsuario = new JTextField(15);
        add(txtUsuario, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 1;
        txtPassword = new JPasswordField(15);
        add(txtPassword, gbc);

        JButton btnLogin = new JButton("Iniciar Sesión");
        JButton btnRegistro = new JButton("Registrarse");

        gbc.gridx = 0; gbc.gridy = 2;
        add(btnLogin, gbc);
        gbc.gridx = 1;
        add(btnRegistro, gbc);

        btnLogin.addActionListener(e -> login());
        btnRegistro.addActionListener(e -> registro());

        setVisible(true);
    }

    private void login() {
        String user = txtUsuario.getText();
        String pass = new String(txtPassword.getPassword());
        if (controlador.autenticar(user, pass)) {
            JOptionPane.showMessageDialog(this, "Login exitoso");
            new RuletaVista().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
        }
    }

    private void registro() {
        String user = txtUsuario.getText();
        String pass = new String(txtPassword.getPassword());
        if (controlador.registrar(user, pass)) {
            JOptionPane.showMessageDialog(this, "Registro exitoso. Ahora inicia sesión.");
        } else {
            JOptionPane.showMessageDialog(this, "Usuario ya existe");
        }
    }
}
