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
			PreparedStatement ps = con.prepareStatement("select Nome , AmmDip from Dipartimento;");

			ArrayList<Dipartimento> listaProdotti = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Dipartimento p = new Dipartimento();
				p.setDip(rs.getString(1));
				p.setAmmDip(rs.getString(2));

				listaProdotti.add(p);
			}
			return listaProdotti;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
		//Ricerca per Dipartimento
	public Dipartimento doRetrieveByKey(String nome) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select Nome, AmmDip from  Dipartimento where Nome=?;");
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Dipartimento p = new Dipartimento();
				p.setDip(rs.getString(1));
				p.setAmmDip(rs.getString(2));

				return p;

			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
