package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.spi.SyncResolver;




public class DipartimentoDAO {
	/*Fuzioni  standard 
	 * doSave
	 * doDelete
	 * */
	public synchronized int doSave(String ammDip, String dip) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("insert into Dipartimento(Nome, AmmDip) values (?,?);");
			ps.setString(1, dip);
			ps.setString(2, ammDip);

			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void doDelete(int dip) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM Dipartimento WHERE Nome=?;");
			ps.setInt(1, dip);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// prendi tutti i dipartimenti
	public ArrayList<Dipartimento> doRetrieveAll() {

		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select Dipartimento.Nome, Utente.Nome, Utente.Cognome from  Dipartimento join Utente  on Dipartimento.AmmDip =  Utente.Email;");

			ArrayList<Dipartimento> listaDip = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Dipartimento p = new Dipartimento();
				p.setDip(rs.getString(1));
				String a = rs.getString(2)+" "+rs.getString(3);
				p.setAmmDip(a);

				listaDip.add(p);
			}
			return listaDip;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
		//Ricerca per Dipartimento
	public String doRetrieveByKey(String email) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select Nome from  Dipartimento where AmmDip=?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String p = rs.getString(1);
				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
