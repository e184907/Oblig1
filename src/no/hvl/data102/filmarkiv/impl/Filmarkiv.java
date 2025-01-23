package no.hvl.data102.filmarkiv.impl;

import java.util.ArrayList;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT{

	private Film[] filmer;
	private int nesteledig;
	
	public Filmarkiv (int antall) {
		filmer = new Film[antall];
		this.nesteledig = 0;
	}
		
	@Override
	public Film finnFilm(int nr) {
		for (int i = 0; i < filmer.length; i++) {
			if (filmer[i].getFilmnr() == nr) {
				return filmer[i];
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (nesteledig < filmer.length) {
			filmer[nesteledig] = nyFilm;
			nesteledig++;
		} else {
			System.out.println("Tabellen er full");
		}
	}

	@Override
	public boolean slettFilm(int filmnr) {
	    for (int i = 0; i < nesteledig; i++) {  
	        if (filmer[i].getFilmnr() == filmnr) {  
	            filmer[i] = filmer[nesteledig - 1];  
	            filmer[nesteledig - 1] = null; 
	            nesteledig--;  
	            return true;  
	        }
	    }
	    return false; 
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		ArrayList<Film> resultater = new ArrayList<>();
		
		for (int i = 0; i < filmer.length; i++) {
			if (filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				resultater.add(filmer[i]);
			}
		}
		return resultater.toArray(new Film[0]);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		ArrayList<Film> resultater = new ArrayList<>();
		
		for (int i = 0; i < filmer.length; i++) {
			if (filmer[i].getFilmskaper().toLowerCase().contains(delstreng.toLowerCase())) {
				resultater.add(filmer[i]);
			}
		}
		return resultater.toArray(new Film[0]);
	}

	@Override
	public int antall(Sjanger sjanger) {
		return 0;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}
	heii
}
