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
		return tipoAula;
	}
	public void setTipoAula(int tipoAula) {
		this.tipoAula = tipoAula;
	}
	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDipartimento() {
		return dipartimento;
	}
	
	private String aula;
	private String edificio;
	private int tipoAula;
	private String dipartimento;
	private String descrizione;
	
	





}
