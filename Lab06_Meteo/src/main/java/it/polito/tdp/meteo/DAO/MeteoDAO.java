package it.polito.tdp.meteo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.meteo.model.Citta;
import it.polito.tdp.meteo.model.Rilevamento;

public class MeteoDAO {
	
	public List<Rilevamento> getAllRilevamenti() {

		final String sql = "SELECT Localita, Data, Umidita FROM situazione ORDER BY data ASC";

		List<Rilevamento> rilevamenti = new ArrayList<Rilevamento>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Rilevamento r = new Rilevamento(rs.getString("Localita"), rs.getDate("Data"), rs.getInt("Umidita"));
				rilevamenti.add(r);
			}

			conn.close();
			return rilevamenti;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Rilevamento> getAllRilevamentiLocalitaMese(int mese, String localita) {
		final String sql = "SELECT Localita, Data, Umidita FROM situazione WHERE Localita=? AND MONTH(DATA)= ? ORDER BY data ASC";

		List<Rilevamento> rilevamenti = new ArrayList<Rilevamento>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, localita);
			st.setInt(2, mese);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Rilevamento r = new Rilevamento(rs.getString("Localita"), rs.getDate("Data"), rs.getInt("Umidita"));
				rilevamenti.add(r);
			}

			conn.close();
			return rilevamenti;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public double getUmiditaMedia(int mese, String localita) {
		final String sql = "SELECT AVG(Umidita) AS u FROM situazione WHERE Localita=? AND MONTH(DATA)= ?";

		

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, localita);
			st.setInt(2, mese);
			ResultSet rs = st.executeQuery();

			
			rs.next();
		    double u = rs.getDouble("u");
		
			conn.close();
			return u;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Citta> getAllCitta() {
		final String sql = "SELECT distinct Localita FROM situazione";

		List<Citta> localita = new ArrayList<Citta>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			
			while(rs.next()) {
		    localita.add(new Citta(rs.getString("Localita")));
			}
			conn.close();
			return localita;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
