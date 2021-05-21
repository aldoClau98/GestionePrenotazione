package Model;

public class Corso {
	
	public Corso() {
		
	}
	
	public Corso(String NomeCorso, String Tutor, String NomeDip) {
		
		this.NomeCorso=NomeCorso;
		this.Tutor= Tutor;
		this.NomeDip=NomeDip;
	}

	
	private String NomeCorso;
	private String Tutor;
	private String NomeDip;
	
	
	
	public String getNomeCorso() {
		return NomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		NomeCorso = nomeCorso;
	}

	public String getTutor() {
		return Tutor;
	}

	public void setTutor(String tutor) {
		Tutor = tutor;
	}

	public String getNomeDip() {
		return NomeDip;
	}

	public void setNomeDip(String nomeDip) {
		NomeDip = nomeDip;
	}
}
