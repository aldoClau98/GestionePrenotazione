package Model;

public class Aula {

	public Aula() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIsAulaStd() {
		return isAulaStd;
	}
	public void setIsAulaStd(int isAulaStd) {
		this.isAulaStd = isAulaStd;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		descrizione = descrizione;
	}

	private String nome;
	private int  isAulaStd=0;
	private String descrizione;
}
