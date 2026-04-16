package controlador;

import javax.swing.JOptionPane;

import modelo.Usuario;
import vista.VistaIniciarSesion; 

public class ControllerInicioSesion {
    

    public static void comprobarDatos(Usuario user) throws UsuarioNoEncontradoException, PasswordIncorrectaException {
        
        String nombre = user.getNombre();
        String password = user.getContraseña();
        
        ControllerFichero.leerFichero();
        
        
        if(!ControllerFichero.comprobarUsuario(nombre)) {
            throw new UsuarioNoEncontradoException();
        }
        
        
        if(!ControllerFichero.comprobarPassword(nombre, password)) {
            throw new PasswordIncorrectaException();
        }
        
       
        mensajeConfirmacion(nombre);
    }

    private static void mensajeConfirmacion(String nombre) {
        JOptionPane.showMessageDialog(null, "Has iniciado sesión como " + nombre, "Inicio sesión", JOptionPane.INFORMATION_MESSAGE);
    }
    

   
}