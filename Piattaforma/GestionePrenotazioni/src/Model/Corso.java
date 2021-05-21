package Model;

public class Corso {
	
	public Corso() {
		
	}
	
	public Corso(String nomeCorso, String tutor, String nomeDip) {
		
		this.nomeCorso=nomeCorso;
		this.tutor= tutor;
		this.nomeDip=nomeDip;
	}

	
	private String nomeCorso;
	private String tutor;
	private String nomeDip;
	
	
	
	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getNomeDip() {
		return nomeDip;
	}

	public void setNomeDip(String nomeDip) {
		this.nomeDip = nomeDip;
	}
}
