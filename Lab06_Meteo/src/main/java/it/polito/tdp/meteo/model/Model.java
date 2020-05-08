package it.polito.tdp.meteo.model;


import java.util.*;

import it.polito.tdp.meteo.DAO.MeteoDAO;

public class Model {
	
	private final static int COST = 100;
	private final static int NUMERO_GIORNI_CITTA_CONSECUTIVI_MIN = 3;
	private final static int NUMERO_GIORNI_CITTA_MAX = 6;
	private final static int NUMERO_GIORNI_TOTALI = 15;
	
	private MeteoDAO meteodao;
	private List<Citta> allCitta;
	private List<Citta> soluzione;
	
	
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
	// Livello = giorno sequenza
	// Parziale = citta in cui fare il rilevamentofino al giorno N
	// Risultato = sequenza ottima di 
	public List<Citta> trovaSequenza(int mese) {
		
		List<Citta> parziale = new ArrayList<Citta>();
	
	}
	
	private void cerca(int livello,List<Citta> parziale) {
		
		if(livello == NUMERO_GIORNI_TOTALI) {
			//caso terminale
			
			double costo = calcolaCosto(parziale);
			
			if(costo < calcolaCosto(soluzione) || soluzione == null) {
				soluzione = new ArrayList<Citta>(parziale);
			}
		}
		
		//sottoproblemi
		for(Citta c : allCitta) {
			if(aggiuntaValida(parziale,c)) {
				parziale.add(c);
				cerca(livello+1,parziale);
				parziale.remove(parziale.size()-1);
			}
		}	
	}
	
	
	private boolean aggiuntaValida(List<Citta> parziale, Citta c) {
		
		int conta = 0;
		
		for(Citta par : parziale) {
			if(par.equals(c));
			conta++;
		}
		
		if(conta > NUMERO_GIORNI_CITTA_MAX) 
			return false;
		
		if(parziale.size() == 0)
			return true;
		
		if(parziale.size()<NUMERO_GIORNI_CITTA_CONSECUTIVI_MIN)
				return parziale.get(parziale.size()-1).equals(c);
		
		if(parziale.get(parziale.size()-1).equals(c)) {
			return true;
		} else {
			for(int i =0 ; i<NUMERO_GIORNI_CITTA_CONSECUTIVI_MIN-1 ; i++) {
				
				if(!parziale.get(parziale.size()-1 -i).equals(parziale.get(parziale.size()-2-i))) {
					return false;
				}	
			}
		}	
		return true;
	}


	private double calcolaCosto(List<Citta> parziale) {
		
		int costo = 0;
		for(Citta c : parziale) {
			costo += c.getRilevamenti().get
		}
		return 0;
	}
	

}
