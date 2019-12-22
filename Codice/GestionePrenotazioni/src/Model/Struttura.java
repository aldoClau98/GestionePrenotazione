package Model;

public class Struttura {
	
	public Struttura() {
		
	}
	
	

	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	public int getTipoAula() {
		return TipoAula;
	}
	public void setTipoAula(int tipoAula) {
		TipoAula = tipoAula;
	}
	public void setDipartimento(String dipartimento) {
		Dipartimento = dipartimento;
	}
	
	private String aula;
	private String edificio;
	private int TipoAula;
	private String Dipartimento;
	public String getDipartimento() {
		return Dipartimento;
	}





}
