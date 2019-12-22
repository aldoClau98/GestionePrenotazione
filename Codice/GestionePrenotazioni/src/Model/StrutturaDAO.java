package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StrutturaDAO {

	public StrutturaDAO() {

	}

	// salva un aula ed edificio nel database
	public synchronized int doSave(String aula, String edificio, int tipoAula) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("insert into Struttura(Aula, Edificio,tipo) values (?,?,?);");
			ps.setString(1, aula);
			ps.setString(2, edificio);
			ps.setInt(3, tipoAula);

			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// elimina edificio ed aula ed edificio nel database
	public synchronized int doDelete(String aula, String edificio) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("DELETE FROM Struttura WHERE aula=? AND edificio=?;");
			ps.setString(1, aula);
			ps.setString(2, edificio);
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	// prendi tutti le strutture
		public ArrayList<Struttura> doRetrieveAll() {

			try (Connection con = DriverManagerConnectionPool.getConnection()) {
				PreparedStatement ps = con.prepareStatement("select Aula, Edificio, tipo, Dipartimento from Struttura;");

				ArrayList<Struttura> listaStrutture = new ArrayList<>();
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Struttura p = new Struttura();
					p.setAula(rs.getString(1));
					p.setEdificio(rs.getString(2));
					p.setTipoAula(rs.getInt(3));
					p.setDipartimento(rs.getString(4));
					
					listaStrutture.add(p);
				}
				return listaStrutture;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
			//Ricerca per struttura
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
