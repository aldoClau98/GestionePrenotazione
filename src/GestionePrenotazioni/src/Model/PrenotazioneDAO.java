package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrenotazioneDAO {

	// doSave
	// DoDelete

	public synchronized int doSave(String titolo, String data, int oraInizio, int oraFine, String descrizione,
			String nomeUtente, String aula, String edificio, int accettata) {
		PreparedStatement ps = null;
		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement(
					"INSERT INTO Prenotazione(Titolo,Data ,OraInizio ,OraFine ,Descrizione ,NomeUtente ,Aula ,Edificio,accettata) VALUES (?,?,?,?,?,?,?,?,?);");
			ps.setString(1, titolo);
			ps.setString(2, data);
			ps.setInt(3, oraInizio);
			ps.setInt(4, oraFine);
			ps.setString(5, descrizione);
			ps.setString(6, nomeUtente);
			ps.setString(7, aula);
			ps.setString(8, edificio);
			ps.setInt(9, accettata);
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public synchronized int doDelete(int id) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM Prenotazione WHERE IDprenotazione=?;");
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public synchronized int doDeleteByStruttura(String edificio, String aula) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM Prenotazione WHERE Edificio=? AND Aula=?;");
			ps.setString(1, edificio);
			ps.setString(2, aula);
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public synchronized int doDeleteByEdificio(String edificio) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM Prenotazione WHERE Edificio=?;");
			ps.setString(1, edificio);

			int rs = ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public synchronized void doUpdate(int id) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("UPDATE Prenotazione SET  Accettata=? WHERE IDprenotazione = ?;");
			ps.setInt(1, 1);
			ps.setInt(2, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// prendi tutte le prenotazioni
	public synchronized ArrayList<Prenotazione> doRetrieveAll() {

		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"select IDprenotazione, Titolo, Data, OraInizio, OraFine, Descrizione, NomeUtente, Aula, Edificio from Prenotazione;");

			ArrayList<Prenotazione> listaPrenotazioni = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prenotazione p = new Prenotazione();
				p.setIDprenotazione(rs.getInt(1));
				p.setTitolo(rs.getString(2));
				p.setData(PrenotazioneDAO.SplitData(rs.getString(3)));
				p.setOraInizio(rs.getInt(4));
				p.setOraFine(rs.getInt(5));
				p.setDescrizione(rs.getString(6));
				p.setUtente(rs.getString(7));
				p.setAula(rs.getString(8));
				p.setEdificio(rs.getString(9));
				listaPrenotazioni.add(p);
			}
			return listaPrenotazioni;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Ricerca prenotazioni utente
	public synchronized ArrayList<Prenotazione> doRetrieveByUtente(String nomeUtente) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"select IDprenotazione ,Titolo,Data ,OraInizio ,OraFine ,Descrizione ,Aula ,Edificio from Prenotazione where NomeUtente=?;");
			ps.setString(1, nomeUtente);

			ArrayList<Prenotazione> prenotazioniUtente = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prenotazione p = new Prenotazione();
				p.setIDprenotazione(rs.getInt(1));
				p.setTitolo(rs.getString(2));
				p.setData(PrenotazioneDAO.SplitData(rs.getString(3)));
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

	// Ricerca prenotazioni per dipartimento
	public synchronized ArrayList<Prenotazione> doRetrieveByDip(String dipartimento, String data) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"select  Utente.Email,IDprenotazione, Titolo, Data,OraInizio, OraFine, Prenotazione.Descrizione, Prenotazione.Aula, Prenotazione.Edificio from Struttura join Prenotazione on Struttura.Aula=Prenotazione.Aula join Utente on Prenotazione.NomeUtente=Utente.Email where  Struttura.Dipartimento=? AND Data >= ? and accettata=0 ;");
			ps.setString(1, dipartimento);
			ps.setString(2, data);
			ArrayList<Prenotazione> prenotazioniDip = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prenotazione p = new Prenotazione();
				p.setUtente(rs.getString(1));
				p.setIDprenotazione(rs.getInt(2));
				p.setTitolo(rs.getString(3));
				p.setData(rs.getString(4));
				p.setOraInizio(rs.getInt(5));
				p.setOraFine(rs.getInt(6));
				p.setDescrizione(rs.getString(7));
				p.setAula(rs.getString(8));
				p.setEdificio(rs.getString(9));
				prenotazioniDip.add(p);
			}
			return prenotazioniDip;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Ricerca prenotazioni per data
	/*
	 * Data � di tipo string in questo modo ci rende piu facile la chiamata al
	 * database, ma il formato deve essere gestito dal FrontEnd
	 */
	public synchronized ArrayList<Prenotazione> doRetrieveByDate(String email, String data) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"select IDprenotazione, Titolo, Data, OraInizio, OraFine, Descrizione, Aula, Edificio, Email from Prenotazione join Utente  on  NomeUtente = Email where Email=? AND ( Data BETWEEN ? and ? )order by  Data Desc ;");
			ps.setString(1, email);
			// qua gli dobbiamo passare la data corrente
			ps.setString(2, "1975-01-01");
			ps.setString(3, data);

			ArrayList<Prenotazione> prenotazioniData = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prenotazione p = new Prenotazione();

				p.setIDprenotazione(rs.getInt(1));
				p.setTitolo(rs.getString(2));
				p.setData(PrenotazioneDAO.SplitData(rs.getString(3)));
				p.setOraInizio(rs.getInt(4));
				p.setOraFine(rs.getInt(5));
				p.setDescrizione(rs.getString(6));
				p.setAula(rs.getString(7));
				p.setEdificio(rs.getString(8));
				prenotazioniData.add(p);
			}
			return prenotazioniData;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public synchronized ArrayList<Prenotazione> doRetrieveByCalendario(String aula, String edificio, String data) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement(
					"select IDprenotazione ,Titolo,Data ,OraInizio ,OraFine ,Descrizione ,Aula ,Edificio, Email from Prenotazione join Utente  on  NomeUtente = Email where Aula=? AND edificio = ? AND ( Data BETWEEN ? and ? )order by  Data Desc ;");
			ps.setString(1, aula);
			ps.setString(2, edificio);
			ps.setString(3, "1975-01-01");
			ps.setString(4, data);

			ArrayList<Prenotazione> prenotazioniData = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Prenotazione p = new Prenotazione();
				p.setIDprenotazione(rs.getInt(1));
				p.setTitolo(rs.getString(2));

				p.setData(PrenotazioneDAO.SplitData(rs.getString(3)));

				p.setOraInizio(rs.getInt(4));
				p.setOraFine(rs.getInt(5));
				p.setDescrizione(rs.getString(6));
				p.setAulaPrenotata(rs.getString(7));
				p.setEdificio(rs.getString(8));
				prenotazioniData.add(p);
			}
			return prenotazioniData;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static String SplitData(String temp) {

		MyCalendar date = new MyCalendar();
		int year = Integer.parseInt(temp.substring(0, 4));
		int month = Integer.parseInt(temp.substring(5, 7));
		int day = Integer.parseInt(temp.substring(9, 10));
		date.setDate(year, month, day);
		date.setDayofWeek();
		return year + "-" + month + "-" + day;

	}

	public synchronized ArrayList<Prenotazione> doAulabyDate(String data, String aula) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement("SELECT Titolo, OraInizio, OraFine, Descrizione, Accettata "
					+ "FROM Prenotazione " + "WHERE Data=? AND Aula=?;");
			ps.setString(1, data);
			ps.setString(2, aula);

			ArrayList<Prenotazione> pren = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prenotazione p = new Prenotazione();
				p.setTitolo(rs.getString(1));
				p.setOraInizio(rs.getInt(2));
				p.setOraFine(rs.getInt(3));
				p.setDescrizione(rs.getString(4));
				p.setAulaPrenotata(rs.getString(5));
				pren.add(p);
			}
			return pren;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public synchronized int controlloOra(String data, int orainizio, int orafine, String aula, String edificio) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"select IDprenotazione from Prenotazione where Aula=? AND Edificio=? AND data=? AND oraFine > ? AND ? > oraInizio AND accettata=1;");
			ps.setString(1, aula);
			ps.setString(2, edificio);
			ps.setString(3, data);
			ps.setInt(4, orainizio);
			ps.setInt(5, orafine);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// se ha trovato qualcosa torna 0
				return 0;
			}
			// se non ha trovato alcuna prentazione torna 1 ( l' utente puo prenotare a
			// quell'ora)
			return 1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
