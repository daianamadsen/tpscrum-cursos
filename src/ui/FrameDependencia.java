package ui;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import core.DependenciaDAO;
import core.TemaDAO;
import entidades.Dependencia;
import entidades.Tema;
import java.util.Iterator;
import java.util.List;

/**
 * FrameDependencia permite crear formularios tipo ABM para Dependencia.
 * Tiene dos tipos de Dialog:
 *   - Para altas: FrameDependencia.showInputDependencia();
 *   - Para bajas: FrameDependencia.showInputDependencia(dependencia);
 */
public class FrameDependencia extends JFrame {

        private static final Icon iAdd = icon("/imagenes/icono-add.png");
        private static final Icon iEdit = icon("/imagenes/icono-edit.png");
	    
        private static JComboBox cTema;
        private static JComboBox cCorrelativa;
            
        private static void buildComboBox(JComboBox combo, List<Tema> temas) {
            Iterator i = temas.iterator();
            while (i.hasNext()) {
                combo.addItem(i.next());
            }
        }
	    
        private static Object[] buildDialog() {
            //Combos
            TemaDAO handler = new TemaDAO();
            List<Tema> lista = handler.read();
            cTema = new JComboBox();
            cCorrelativa = new JComboBox();
            buildComboBox(cTema, lista);
            buildComboBox(cCorrelativa, lista);
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
            TemaDAO handler = new TemaDAO();
            Tema tema = handler.read(dependencia.getTema().getId());
            Tema corr = handler.read(dependencia.getCorrelativo().getId());
            //Msg
            Object[] msg = {
                "Tema: " + tema.toString(),
                "Tema correlativo: " + corr.toString(),
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
                    Tema tema = (Tema)cTema.getSelectedItem();
                    Tema corr = (Tema)cCorrelativa.getSelectedItem();
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
