package ui;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import core.DependenciaDAO;
import core.TemaDAO;
import entidades.Dependencia;
import entidades.Tema;

public class FrameDependencia extends JFrame {

	 private static final Icon iAdd = icon("/imagenes/icono-add.png");
	    private static final Icon iEdit = icon("/imagenes/icono-edit.png");
	    
	    private static JComboBox<Tema> cTema;
	    private static JComboBox<Tema> cCorrelativa;
	    
	    private static Object[] buildDialog() {
	        //Cuadros de texto
	    	TemaDAO handler = new TemaDAO();
	    	ArrayList<Tema> lista = (ArrayList<Tema>) handler.read();
	    	//String[] arrTema = new String[lista.size()];
	    	//for (int i=0;i<lista.size();i++){
	    	//	arrTema[i] = lista.get(i).getNombre();
	    	//}
	    	Tema[] aux = (Tema[]) lista.toArray();
	    	cTema = new JComboBox<Tema>(aux);
	    	cCorrelativa = new JComboBox<Tema>(aux);
	        //Msg
	        Object[] msg = {
	            "Tema:", cTema,
                    " ",
	            "Correlativa:", cCorrelativa,
	            " "
	        };
	        return msg;
	    }
            
            private static Object[] buildDialog(Dependencia dependencia) {
                //Msg
                Object[] msg = {
                    "Tema:" + dependencia.getTema().toString(),
                    " ",
                    "Tema correlativo:" + dependencia.getCorrelativo().toString(),
                    " "
                };
                return msg;
            }
	    
	    //nueva dep
	    public static boolean showInputDependencia() {
	        //Dialog
	        Object[] msg = buildDialog();
	        Object[] options = {"Guardar Dependencia", "Cancelar"};
	        int option = JOptionPane.showOptionDialog(new java.awt.Frame(), msg, "Nueva Dependencia", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, iAdd, options, options[1]);
	        if (option == JOptionPane.OK_OPTION) {
	            //Creación de correlativa
	        	Tema tema = cTema.getItemAt(cTema.getSelectedIndex());
	        	Tema corr = cTema.getItemAt(cCorrelativa.getSelectedIndex());
	            if (tema!= null && corr!=null){ 	
	            	Dependencia dep = new Dependencia(tema,corr);
	            	DependenciaDAO handler = new DependenciaDAO();
	            	handler.create(dep);
	            	return true;
	            }
	        }
	        return false;
	    }
	    
	    //eliminar o ver dep
	    public static boolean showInputDependencia(Dependencia dependencia) {
	        //Dialog
	    	Object[] msg = buildDialog(dependencia);
	        Object[] options = {"Eliminar Dependencia", "Cancelar"};
	        int option = JOptionPane.showOptionDialog(new java.awt.Frame(), msg, "Eliminar Dependencia", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, iEdit, options, options[1]);
	        if (option == JOptionPane.OK_OPTION) {
	            //Eiminación de correlativa
	            DependenciaDAO handler = new DependenciaDAO();
	            handler.delete(dependencia);
	            return true;
	        }
	        return false;
	    }
	    
	    private static Icon icon(String path) {
	        URL resource = Message.class.getResource(path);
	        return new ImageIcon(resource);
	    }
	    
	

}
