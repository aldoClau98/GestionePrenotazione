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
	public synchronized int doSave(String aula, String edificio, String descrizione) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("insert into Struttura(Aula, Edificio,tipo,Descrizione) values (?,?,?,?);");
			ps.setString(1, aula);
			ps.setString(2, edificio);
			ps.setInt(3, 0);
			ps.setString(4, descrizione);
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public synchronized int doUpdate(String aula, String edificio, String tipoaula) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("Update Struttura set  tipo=? where Aula=? AND Edificio=?;");
			ps.setInt(1, Integer.parseInt(tipoaula));
			ps.setString(2, aula);
			ps.setString(3, edificio);

			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// salva un edificio nel database
	public synchronized int doSaveEdificio(String aula, String edificio, String descrizione) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("insert into Struttura(Aula, Edificio,tipo,Descrizione) values (?,?,?,?);");
			ps.setString(1, aula);
			ps.setString(2, edificio);
			ps.setInt(3, 0);
			ps.setString(4, descrizione);
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// elimina edificio ed aula nel database
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

	public synchronized int doDeleteEdificio(String edificio) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("DELETE FROM Struttura WHERE edificio=?;");
			ps.setString(1, edificio);
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public synchronized int doUpdateDipartimento(String aula, String edificio, String dip) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("Update Struttura set  dipartimento=? where Aula=? AND Edificio=?;");
			ps.setString(1, dip);
			ps.setString(2, aula);
			ps.setString(3, edificio);

			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// prendi tutti le strutture
	public synchronized ArrayList<Struttura> doRetrieveAll() {

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

	// Ricerca per dipartimento
	public synchronized Dipartimento doRetrieveByKey(String nome) {
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

	// crea lista nomi Edifici
	public synchronized ArrayList<String> doRetrieveAllEdifici() {

		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select DISTINCT  Edificio from Struttura;");

			ArrayList<String> listaNomiEdifici = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String p = (rs.getString(1));
				listaNomiEdifici.add(p);
			}

			return listaNomiEdifici;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Ricerca le aule per Edificio
	public synchronized ArrayList<Struttura> doAulabyEdificio(String edificio) {
		// connessione al database
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			// preparo la query
			PreparedStatement ps = con
					.prepareStatement("select Aula, tipo, Descrizione,Dipartimento from  Struttura where Edificio=?;");
			ps.setString(1, edificio);

			ArrayList<Struttura> listaAule = new ArrayList<>();
			// eseguo la query
			ResultSet rs = ps.executeQuery();
			// riempio la mia lista di aule
			while (rs.next()) {
				Struttura p = new Struttura();
				p.setAula(rs.getString(1));
				p.setTipoAula(rs.getInt(2));
				p.setDescrizione(rs.getString(3));
				p.setDipartimento(rs.getString(4));
				listaAule.add(p);
			}
			return listaAule;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Ricerca Struttura
	public synchronized Struttura doStrutturabyName(String aula, String edificio) {
		// connessione al database
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			// preparo la query
			PreparedStatement ps = con.prepareStatement(
					"select Aula, tipo,Edificio,Dipartimento,Descrizione from  Struttura where Aula=? AND Edificio=?;");
			ps.setString(1, aula);
			ps.setString(2, edificio);
			// eseguo la query
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Struttura p = new Struttura();
				p.setAula(rs.getString(1));
				p.setTipoAula(rs.getInt(2));
				p.setDipartimento(rs.getString(3));
				p.setEdificio(rs.getString(4));
				p.setDescrizione(rs.getString(5));

				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Ricerca Strutture per Dipartimento
	public synchronized ArrayList<Struttura> doStrutturabyDip(String dip) {
		// connessione al database
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			// preparo la query
			PreparedStatement ps = con.prepareStatement(
					"select Aula, Edificio, tipo, Dipartimento from  Struttura where Dipartimento=?;");
			ps.setString(1, dip);

			ArrayList<Struttura> listastr = new ArrayList<>();
			// eseguo la query
			ResultSet rs = ps.executeQuery();
			// riempio la mia lista di aule
			while (rs.next()) {
				Struttura p = new Struttura();
				p.setAula(rs.getString(1));
				p.setEdificio(rs.getString(2));
				p.setTipoAula(rs.getInt(3));
				p.setDipartimento(rs.getString(4));
				listastr.add(p);
			}
			return listastr;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

//ricerca le strutture  per l aula
	public synchronized Struttura doStrutturabyAula(String aula) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"select Aula, tipo, Edificio, Dipartimento, Descrizione from  Struttura where Aula=?;");
			ps.setString(1, aula);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Struttura p = new Struttura();
				p.setAula(rs.getString(1));
				p.setTipoAula(rs.getInt(2));
				p.setEdificio(rs.getString(3));
				p.setDipartimento(rs.getString(4));
				p.setDescrizione(rs.getString(5));
				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public synchronized ArrayList<Struttura> doStrutturabyDipartimenti(String dip) {
		// connessione al database
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			// preparo la query
			PreparedStatement ps = con.prepareStatement(
					"select Aula, Edificio, tipo, Dipartimento, Descrizione from  Struttura where Dipartimento=?;");
			ps.setString(1, dip);

			ArrayList<Struttura> listastr = new ArrayList<>();
			// eseguo la query
			ResultSet rs = ps.executeQuery();
			// riempio la mia lista di aule
			while (rs.next()) {
				Struttura p = new Struttura();
				p.setAula(rs.getString(1));
				p.setEdificio(rs.getString(2));
				p.setTipoAula(rs.getInt(3));
				p.setDipartimento(rs.getString(4));
				p.setDescrizione(rs.getString(5));
				listastr.add(p);
			}
			return listastr;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public synchronized ArrayList<Struttura> doRetrieveAllAule() {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("select DISTINCT Aula, Edificio from  Struttura;");

			ArrayList<Struttura> listaAule = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Struttura s = new Struttura();
				s.setAula(rs.getString(1));
				s.setEdificio(rs.getString(2));

				listaAule.add(s);
			}
			return listaAule;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}