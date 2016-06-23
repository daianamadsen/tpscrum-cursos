package input_output;
import java.io.File;
import java.util.ArrayList;

import entidades.Dependencia;
import core.DependenciaDAO;

public class Exportar {
	
	private String dotPath = "c:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
	private String fileOutputPath = "c:/temp";
	private String nameOutputFile = "grafo.pdf";
	
	
	public Exportar(){
		fileOutputPath = "c:/temp";
		nameOutputFile = "grafo.pdf";
	}
	
	public Exportar(String path, String name){
		fileOutputPath = path;
		nameOutputFile = name;
	}
	
	public void exportarPDF(){
		
		DependenciaDAO dDAO = new DependenciaDAO();
		ArrayList<Dependencia> dependencias = (ArrayList<Dependencia>) dDAO.read();
		
		//GraphViz gv = new GraphViz(); //dotPath y fileOutPath varia de acuerdo al sistema operativo e inclusive dentro del mismo, deberia ser posible seleccionarlo.
		GraphViz gv = new GraphViz(dotPath, fileOutputPath);
		gv.addln(gv.start_graph());
		for (Dependencia i : dependencias)
			gv.addln(i.toString());
		gv.addln(gv.end_graph());
		
		System.out.println(gv.getDotSource());

		gv.increaseDpi();   // 106 dpi

		//String type = "gif";
		//      String type = "dot";
		//      String type = "fig";    // open with xfig
		String type = "pdf";
		//      String type = "ps";
		//      String type = "svg";    // open with inkscape
		//      String type = "png";
		//      String type = "plain";
		
		String repesentationType= "dot";
		//		String repesentationType= "neato";
		//		String repesentationType= "fdp";
		//		String repesentationType= "sfdp";
		// 		String repesentationType= "twopi";
		// 		String repesentationType= "circo";
		
		//File out = new File("/tmp/out"+gv.getImageDpi()+"."+ type);   // Linux
		//File out = new File("c:/temp/out." + type);    // Windows
		File out = new File(fileOutputPath+ "/" + nameOutputFile); //windows
		gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
	}
}
