package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAO {

	public UtenteDAO() {

	}

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

	// ricerca un tipo di utente per email
	public Utente doRetrieveByKey(String email, String password) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			System.out.println(email);
			PreparedStatement ps = con.prepareStatement(
					"select Email, Password, Nome , Cognome, TipoUtente from Utente Where Email=? AND Password=?;");
			ps.setString(1, email);
			ps.setString(2, password);
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
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// modifica della password
	public static int doUpdate(String email, String password) {
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

}
