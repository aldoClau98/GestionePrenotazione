package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CorsoDAO {
	
	// inizio metodi CRUD
	public synchronized int doSave( String NomeCorso, String NomeDip) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("insert into Corso(NomeCorso,NomeDip) values (?,?);");
			ps.setString(1, NomeCorso);
			ps.setString(2, NomeDip);
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public synchronized int doDelete(String NomeCorso, String NomeDip) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM Corso WHERE NomeCorso=? && NomeDip=?;");
			ps.setString(1, NomeCorso);
			ps.setString(2, NomeDip);
			int rs =ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public synchronized int doUpdate(String CorsoNuovo,String CorsoVecchio) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("Update Corso set NomeCorso=? WHERE NomeCorso=?;");
			ps.setString(1, CorsoNuovo);
			ps.setString(2, CorsoVecchio);
			int rs =ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//fine metodi CRUD
	
	//update customizzato per tutor
	public synchronized int doUpdateTutor(String email) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("Update Corso set tutor=? WHERE tutor=?;");
			ps.setString(1, "");
			ps.setString(2, email);
			int rs =ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//inizio metodi di ricerca
	
	public synchronized ArrayList<Corso> doRetrieveAll() {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement("select NomeCorso, Tutor, NomeDip from Corso ;");
			ArrayList<Corso> listaCorsi = new ArrayList<Corso>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Corso p = new Corso();

				p.setNomeCorso(rs.getString(1));
				p.setTutor(rs.getString(2));
				p.setNomeDip(rs.getString(3));
				
				listaCorsi.add(p);
			}
			return listaCorsi;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
