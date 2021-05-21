package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteDAO {

	// doSave Salva un nuovo utente nel database
	public synchronized int doSave(String email, String password, String nome, String cognome, int tipoUtente) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement(
					"insert into  Utente(Email,Password,Nome,Cognome,TipoUtente) values (?,?,?,?,?);");
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, nome);
			ps.setString(4, cognome);
			ps.setInt(5, tipoUtente);
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public synchronized int doUpdate(String email, int flag) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {

			if (flag == 2) {
				ps = conn.prepareStatement("Update Utente set  TipoUtente=? where email=?;");
				ps.setInt(1, flag);
				ps.setString(2, email);
				int rs = ps.executeUpdate();
				return rs;
			} else {
				ps = conn.prepareStatement("Update Utente set  TipoUtente=? where email=?;");
				ps.setInt(1, flag);
				ps.setString(2, email);
				int rs = ps.executeUpdate();
				return rs;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// cambia l' amministratore al dipartimento
	public synchronized int doChangeDip(String email, String dip) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {

			ps = conn.prepareStatement("Update Dipartimento set  AmmDip=? where Nome=?;");
			ps.setString(1, email);
			ps.setString(2, dip);
			int rs = ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// ricerca un tipo di utente per email
	public synchronized Utente doRetrieveByKey(String email, String password) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement(
					"select Email, Password, Nome , Cognome, TipoUtente from Utente Where Email=? AND Password=?;");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utente p = new Utente();
				p.setEmail(rs.getString(1));
				p.setPassword(rs.getString(2));
				p.setNome(rs.getString(3));
				p.setCognome(rs.getString(4));
				p.setTipoUtente(rs.getInt(5));

				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public synchronized ArrayList<Utente> doRetrieveAll() {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement("select Email, Nome , Cognome, TipoUtente from Utente ;");
			ArrayList<Utente> listaUtente = new ArrayList<Utente>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utente p = new Utente();

				p.setEmail(rs.getString(1));
				p.setNome(rs.getString(2));
				p.setCognome(rs.getString(3));
				p.setTipoUtente(rs.getInt(4));

				listaUtente.add(p);
			}
			return listaUtente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// modifica della password
	public synchronized int doUpdate(String email, String password) {
		int rs = 0;
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("UPDATE Utente SET  password=?  WHERE email =?;");

			ps.setString(1, password);
			ps.setString(2, email);

			rs = ps.executeUpdate();

			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public synchronized Utente doRetrieveByEmail(String email) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con
					.prepareStatement("select Email, Password, Nome , Cognome, TipoUtente from Utente Where Email=?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Utente p = new Utente();
				p.setEmail(rs.getString(1));
				p.setPassword(rs.getString(2));
				p.setNome(rs.getString(3));
				p.setCognome(rs.getString(4));
				p.setTipoUtente(rs.getInt(5));
				return p;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	public int doChangeCorso(String email, String corso) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {

			ps = conn.prepareStatement("Update Corso set  Tutor=? where NomeCorso=?;");
			ps.setString(1, email);
			ps.setString(2, corso);
			int rs = ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int doChangeTypeUser(String email) {
		PreparedStatement ps = null;
		System.out.println("model: utenteDAO" +email);
		try (Connection conn = DriverManagerConnectionPool.getConnection();) {

			ps = conn.prepareStatement("Update Utente set  TipoUtente=? where Email=?;");
			ps.setInt(1, 4);
			ps.setString(2, email);
			int rs = ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
