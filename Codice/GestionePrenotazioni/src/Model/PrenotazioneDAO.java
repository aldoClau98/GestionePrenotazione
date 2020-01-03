package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class PrenotazioneDAO {

	
	//doSave
	//DoDelete
	
	public synchronized int doSave( String titolo, String data, int oraInizio, int oraFine, String descrizione, String nomeUtente, String aula, String edificio ) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("insert into Prenotazione(Titolo,Data ,OraInizio ,OraFine ,Descrizione ,NomeUtente ,Aula ,Edificio) values (?,?,?,?,?,?,?,?);");
			ps.setString(1, titolo);
			ps.setString(2, data);
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
				p.setData(PrenotazioneDAO.SplitData(rs.getString(3)));
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
	
	//Ricerca prenotazioni per data
		/*
		 * Data è di tipo string in questo modo ci rende piu  facile 
		 *  la chiamata al database,  ma il formato  deve essere gestito dal 
		 *  FrontEnd*/
		public ArrayList<Prenotazione> doRetrieveByDate(String data,String aula) {
			try (Connection con = DriverManagerConnectionPool.getConnection()) {
				
				
				PreparedStatement ps = con.prepareStatement("select IDprenotazione ,Titolo,Data ,OraInizio ,OraFine ,Descrizione ,Aula ,Edificio from Prenotazione where Data=? AND Aula=?;");
				ps.setString(1, data);
				ps.setString(2, aula);
				System.out.println("data: "+data);
				System.out.println("Aula: "+aula);
				
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
					System.out.println("Prenotazione aggiunta nella lista");
				}
				return prenotazioniData;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public static MyCalendar SplitData(String temp) {
			
			MyCalendar date = new MyCalendar();
			int year= Integer.parseInt(temp.substring(0, 3));
			int month =  Integer.parseInt(temp.substring(5, 7));
			int day =  Integer.parseInt(temp.substring(9,10));
			date.setDate(year, month, day);

			date.setDayofWeek();
			return date;
			
		}
		
		
	
		
		
}
