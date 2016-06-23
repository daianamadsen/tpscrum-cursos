package entidades;

public class Dependencia {
	private int id;	
	private Tema tema; 
	private Tema correlativo;
	
	public Dependencia(){
		
	}
	public Dependencia(Tema tema, Tema correlativo){
		this.tema = tema;
		this.correlativo = correlativo;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Tema getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(Tema correlativo) {
		this.correlativo = correlativo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString(){
		return tema.getSigla()+" -> "+correlativo.getSigla()+";";
	}
	
	

}
