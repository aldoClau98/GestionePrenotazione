package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class DipartimentoDAO {

	public synchronized int doSave( String dip) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("insert into Dipartimento(Nome) values (?);");
			ps.setString(1, dip);
			

			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public synchronized int doDelete(String dip) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM Dipartimento WHERE Nome=?;");
			ps.setString(1, dip);
			int rs =ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}//rimuovo l  amministratore vecchio
	public synchronized int doDeleteAmm(String email) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("Update Dipartimento set AmmDip=? WHERE AmmDip=?;");
			ps.setString(1, "");
			ps.setString(2, email);
			int rs =ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public synchronized int doUpdate(String dip,String email) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("Update Dipartimento set AmmDip=? WHERE Nome=?;");
			ps.setString(1, email);
			ps.setString(2, dip);
			int rs =ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// prendi tutti i dipartimenti
	public synchronized ArrayList<Dipartimento> doRetrieveAll() {

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
	
	public synchronized ArrayList<Dipartimento> doRetrieveAllDip() {

		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select Dipartimento.Nome, Dipartimento.AmmDip from  Dipartimento;");

			ArrayList<Dipartimento> listaDip = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Dipartimento p = new Dipartimento();
				p.setDip(rs.getString(1));
				p.setAmmDip(rs.getString(2));

				listaDip.add(p);
			}
			return listaDip;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//Prende il nome di tutti i dipartimenti
	public synchronized ArrayList<String> doRetrieveAllDipartimenti() {

		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select Nome from   Dipartimento ;");

			ArrayList<String> listaNomiDipartimenti = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String p = (rs.getString(1));
					
				listaNomiDipartimenti.add(p);
			}

			return listaNomiDipartimenti;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
		//Ricerca per Dipartimento
	public synchronized String doRetrieveByKey(String email) {
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
	
	public synchronized Dipartimento doDipartimentoByStruttura(String aula, String edificio) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select Dipartimento.Nome, AmmDip from  Dipartimento join Struttura on Dipartimento.Nome= Struttura.Dipartimento where Aula=? and  Edificio=?;");
			ps.setString(1, aula);
			ps.setString(2, edificio);
			ResultSet rs = ps.executeQuery();
			Dipartimento p = new Dipartimento();
			if (rs.next()) {
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
