package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PrenotazioneDAO {

	
	//doSave
	//DoDelete
	
	public synchronized int doSave( String titolo, Date data, int oraInizio, int oraFine, String descrizione, String nomeUtente, String aula, String edificio ) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("insert into Prenotazione(Titolo,Data ,OraInizio ,OraFine ,Descrizione ,NomeUtente ,Aula ,Edificio) values (?,?,?,?,?,?,?,?);");
			ps.setString(1, titolo);
			ps.setDate(2, data);
			ps.setInt(3, oraInizio);
			ps.setInt(4, oraFine);
			ps.setString(5, descrizione);
			ps.setString(6, nomeUtente);
			ps.setString(7, aula);
			ps.setString(8, edificio);

			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void doDelete(int dip) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM Prenotazione WHERE ID=?;");
			ps.setInt(1, dip);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// prendi tutti i dipartimenti
	public ArrayList<Prenotazione> doRetrieveAll() {

		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select IDprenotazione ,Titolo,Data ,OraInizio ,OraFine ,Descrizione ,NomeUtente ,Aula ,Edificio from Prenotazione;");

			ArrayList<Prenotazione> listaPrenotazioni = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prenotazione p = new Prenotazione();
				p.setIDprenotazione(rs.getInt(1));
				p.setTitolo(rs.getString(2));
				p.setData(rs.getDate(3));
				p.setOraInizio(rs.getInt(4));
				p.setOraFine(rs.getInt(5));
				p.setDescrizione(rs.getString(6));
				p.setUtente(rs.getString(7));
				p.setAulaPrenotata(rs.getString(8));
				p.setEdificio(rs.getString(9));
				listaPrenotazioni.add(p);
			}
			return listaPrenotazioni;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
		//Ricerca prenotazioni utente
	public ArrayList<Prenotazione> doRetrieveByUtente(String nomeUtente) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select IDprenotazione ,Titolo,Data ,OraInizio ,OraFine ,Descrizione ,Aula ,Edificio from Prenotazione where NomeUtente=?;");
			ps.setString(1, nomeUtente);
			
			ArrayList<Prenotazione> prenotazioniUtente = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prenotazione p = new Prenotazione();
				p.setIDprenotazione(rs.getInt(1));
				p.setTitolo(rs.getString(2));
				p.setData(rs.getDate(3));
				p.setOraInizio(rs.getInt(4));
				p.setOraFine(rs.getInt(5));
				p.setDescrizione(rs.getString(6));
				p.setAulaPrenotata(rs.getString(7));
				p.setEdificio(rs.getString(8));
				prenotazioniUtente.add(p);
			}
			return prenotazioniUtente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
