package controlador;

import modelo.Usuario;
import util.ArchivoUtil;
import java.util.ArrayList;
import java.util.List;

public class LoginControlador {
    private static final String ARCHIVO_USUARIOS = "usuarios.dat";
    private List<Usuario> usuarios;

    @SuppressWarnings("unchecked")
    public LoginControlador() {
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        try {
            usuarios = (List<Usuario>) ArchivoUtil.cargarObjeto(ARCHIVO_USUARIOS);
        } catch (Exception e) {
            usuarios = new ArrayList<>();
            // Usuario por defecto
            usuarios.add(new Usuario("admin", "123"));
            guardarUsuarios();
        }
    }

    private void guardarUsuarios() {
        try {
            ArchivoUtil.guardarObjeto(ARCHIVO_USUARIOS, usuarios);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean autenticar(String username, String password) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.checkPassword(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean registrar(String username, String password) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username)) {
                return false; // ya existe
            }
        }
        usuarios.add(new Usuario(username, password));
        guardarUsuarios();
        return true;
    }
}