package input_output;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import entidades.Dependencia;
import core.DependenciaDAO;
import core.TemaDAO;


public class Exportar {
	
	private String dotPath = "c:/Program Files (x86)/Graphviz2.38/bin/dot.exe";
	private String fileOutputPath;
	private String nameOutputFile;
	
	
	public Exportar(){
		fileOutputPath = "c:/temp";
		nameOutputFile = "grafo.pdf";
	}
	
	public Exportar(String path, String name){
		fileOutputPath = path;
		nameOutputFile = name;
	}
	
	public void exportarPDF(){
		
		DependenciaDAO handler_dependencias = new DependenciaDAO();
		List<Dependencia> dependencias = new ArrayList<Dependencia>();
		dependencias.addAll(handler_dependencias.read());
		TemaDAO handler_temas = new TemaDAO();
		
		//GraphViz gv = new GraphViz(); //dotPath y fileOutPath varia de acuerdo al sistema operativo e inclusive dentro del mismo, deberia ser posible seleccionarlo.
		GraphViz gv = new GraphViz(dotPath, fileOutputPath);
		gv.addln(gv.start_graph());
		for (Dependencia i : dependencias){
			String sigla_tema = handler_temas.read(i.getTema().getId()).getSigla();
			String sigla_correlativo = handler_temas.read(i.getCorrelativo().getId()).getSigla();
			gv.addln(sigla_tema + " -> "+ sigla_correlativo + ";");
		}
		gv.addln(gv.end_graph());
		
		System.out.println("Grafo resultante: ");
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
		File out = new File(fileOutputPath + "/" + nameOutputFile); //windows
		gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
	}
}
