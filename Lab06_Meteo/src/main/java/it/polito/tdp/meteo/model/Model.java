package it.polito.tdp.meteo.model;

import java.util.List;

import it.polito.tdp.meteo.DAO.MeteoDAO;

public class Model {
	
	private final static int COST = 100;
	private final static int NUMERO_GIORNI_CITTA_CONSECUTIVI_MIN = 3;
	private final static int NUMERO_GIORNI_CITTA_MAX = 6;
	private final static int NUMERO_GIORNI_TOTALI = 15;
	
	private MeteoDAO meteodao;
	private List<Citta> allCitta;
	
	public Model() {

		this.meteodao = new MeteoDAO();
		this.allCitta = meteodao.getAllCitta();
		
	}

	
	public List<Citta> getAllCitta() {
		return allCitta;
	}


	// of course you can change the String output with what you think works best
	public double getUmiditaMedia(int mese, String localita) {
		
		return this.meteodao.getUmiditaMedia(mese, localita) ;
	}
	
	// of course you can change the String output with what you think works best
	public String trovaSequenza(int mese) {
		return "TODO!";
	}
	

}
