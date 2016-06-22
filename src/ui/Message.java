package ui;

import javax.swing.JOptionPane;

/**
 * Esta clase sirve para mostrar errores o mensajes desde cualquier parte del código.
 * Ejemplo:
 *      Message.showError("Título","Mensaje");
 **/
public class Message {
    
    public static void showError(String title, String msg) {
        JOptionPane.showMessageDialog(new java.awt.Frame(), msg, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showMessage(String title, String msg) {
        JOptionPane.showMessageDialog(new java.awt.Frame(), msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
}
