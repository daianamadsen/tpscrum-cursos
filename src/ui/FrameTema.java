package ui;

import core.TemaDAO;
import entidades.Tema;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * FrameTema permite crear formularios tipo ABM para Tema.
 * Tiene dos tipos de Dialog:
 *   - Para altas: FrameTema.showInputTema();
 *   - Para bajas o modificaciones: FrameTema.showInputTema(tema);
 */
public class FrameTema {
    
    private static final Icon iAdd = icon("/imagenes/icono-add.png");
    private static final Icon iEdit = icon("/imagenes/icono-edit.png");
    
    private static JTextField tsigla;
    private static JTextField tnombre;
    private static JTextField tdescripcion;
    
    private static Object[] buildDialog(String sigla, String nombre, String descripcion) {
        //Cuadros de texto
        tsigla = new JTextField();
        tnombre = new JTextField();
        tdescripcion = new JTextField();
        //Precarga
        if (!sigla.equals("null")) {
            tsigla.setText(sigla);
        }
        if (!nombre.equals("null")) {
            tnombre.setText(nombre);
        }
        if (!descripcion.equals("null")) {
            tdescripcion.setText(descripcion);
        }
        //Msg
        Object[] msg = {
            "Sigla:", tsigla,
            "Nombre:", tnombre,
            "Descripción:", tdescripcion,
            " "
        };
        return msg;
    }
    
    //Nuevo tema
    public static boolean showInputTema() {
        //Dialog
        Object[] msg = buildDialog("", "", "");
        Object[] options = {"Guardar Tema", "Cancelar"};
        int option = JOptionPane.showOptionDialog(new java.awt.Frame(), msg, "Nuevo Tema", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, iAdd, options, options[1]);
        if (option == JOptionPane.OK_OPTION) {
            //Creación de Tema
            String s = tsigla.getText();
            String n = tnombre.getText();
            String d = tdescripcion.getText();
            Tema tema = new Tema(s, n, d);
            TemaDAO handler = new TemaDAO();
            handler.create(tema);
            return true;
        }
        return false;
    }
    
    //Modificar o eliminar tema
    public static boolean showInputTema(Tema tema) {
        //Dialog
        Object[] msg = buildDialog(tema.getSigla(), tema.getNombre(), tema.getDescripcion());
        Object[] options = {"Guardar cambios", "Eliminar Tema", "Cancelar"};
        int option = JOptionPane.showOptionDialog(new java.awt.Frame(), msg, "Editar Tema", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, iEdit, options, options[2]);
        if (option == JOptionPane.YES_OPTION) {
            //Modificación de Tema
            tema.setSigla(tsigla.getText());
            tema.setNombre(tnombre.getText());
            tema.setDescripcion(tdescripcion.getText());
            TemaDAO handler = new TemaDAO();
            handler.update(tema);
            return true;
        } else if (option == JOptionPane.NO_OPTION) {
            //Eiminación de Tema
            try {
                TemaDAO handler = new TemaDAO();
                handler.delete(tema);
            } catch(Exception e) {
                Message.showMessage("No se puede eliminar", "No se puede eliminar el tema porque tiene dependencias.");
            }
            return true;
        }
        return false;
    }
    
    private static Icon icon(String path) {
        URL resource = Message.class.getResource(path);
        return new ImageIcon(resource);
    }
    
}
