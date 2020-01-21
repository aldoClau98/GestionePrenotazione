package Model;

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

	public String getData() {
		return data.getDate();
	}

	public void setData(MyCalendar data) {
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

	public boolean getAulaPrenotata() {
		if (Integer.parseInt(this.aulaPrenotata) == 0)
			return false;
		else
			return true;
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

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	private int IDprenotazione;
	private String titolo;
	private MyCalendar data = new MyCalendar();
	private int oraInizio;
	private int oraFine;
	private String descrizione;
	private String aulaPrenotata;
	private String edificio;
	private String utente;
	private String aula;
}
