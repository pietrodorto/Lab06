package it.polito.tdp.meteo.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model m = new Model();
		List<Citta> allCitta = m.getAllCitta();
		
		for(Citta c : allCitta)
			System.out.println(m.getUmiditaMedia(12,c));
		
		System.out.println(m.calcolaCosto(m.trovaSequenza(2)));
		
		System.out.println(m.trovaSequenza(5));
		

	}

}
