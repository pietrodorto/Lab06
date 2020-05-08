package it.polito.tdp.meteo.model;

import java.util.List;

import it.polito.tdp.meteo.DAO.MeteoDAO;

public class Model {
	
	private final static int COST = 100;
	private final static int NUMERO_GIORNI_CITTA_CONSECUTIVI_MIN = 3;
	private final static int NUMERO_GIORNI_CITTA_MAX = 6;
	private final static int NUMERO_GIORNI_TOTALI = 15;
	private MeteoDAO meteodao;
	
	public Model() {

		this.meteodao = new MeteoDAO();
	}

	public List<String> getLocalita() {
		return this.meteodao.getLocalita();
	}
	// of course you can change the String output with what you think works best
	public String getUmiditaMedia(int mese) {
		
		return this.meteodao.getUmiditaMedia(mese, localita) ;
	}
	
	// of course you can change the String output with what you think works best
	public String trovaSequenza(int mese) {
		return "TODO!";
	}
	

}
