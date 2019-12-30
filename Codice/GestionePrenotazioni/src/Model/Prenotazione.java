package Model;
import java.sql.Date;

public class Prenotazione {
	
	public Prenotazione() {
	}
	@Override
	public String toString() {
		return "Prenotazione [IDprenotazione=" + IDprenotazione + ", titolo=" + titolo + ", data=" + data
				+ ", oraInizio=" + oraInizio + ", oraFine=" + oraFine + ", descrizione=" + descrizione + "]";
	}
	public int getIDprenotazione() {
		return IDprenotazione;
	}
	public void setIDprenotazione(int iDprenotazione) {
		IDprenotazione = iDprenotazione;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getOraInizio() {
		return oraInizio;
	}
	public void setOraInizio(int oraInizio) {
		this.oraInizio = oraInizio;
	}
	public int getOraFine() {
		return oraFine;
	}
	public void setOraFine(int oraFine) {
		this.oraFine = oraFine;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getAulaPrenotata() {
		return aulaPrenotata;
	}
	public void setAulaPrenotata(String aulaPrenotata) {
		this.aulaPrenotata = aulaPrenotata;
	}
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}

	private int IDprenotazione;
	private String titolo;
	private  Date data;
	private int oraInizio;
	private int oraFine;
	private String descrizione;
	private String aulaPrenotata;
	private String edificio;
	private String utente;

}