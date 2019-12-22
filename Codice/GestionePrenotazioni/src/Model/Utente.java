package Model;

public class Utente {
	
	public Utente() {	
	}

	



@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome
				+ ", tipoUtente=" + tipoUtente + "]";
	}





public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getTipoUtente() {
		return tipoUtente;
	}
	public void setTipoUtente(int tipoUtente) {
		this.tipoUtente = tipoUtente;
	}





private String email;
private String password;
private String nome;
private String cognome;
private int tipoUtente;


}