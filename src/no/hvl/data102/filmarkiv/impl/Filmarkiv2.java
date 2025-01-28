package no.hvl.data102.filmarkiv.impl;

import java.util.ArrayList;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT	{
	
	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2(){
		start = null;
		antall = 0;
	}
	
    @Override
    public Film finnFilm(int nr) {
    	LinearNode<Film> current = start;
    	while (current != null) {
    		if (current.getElement().getFilmnr() == nr) {
    			return current.getElement();    		
    		}
    		current = current.getNeste();	
    	}
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
    	LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
    	
    	if(start == null) {
    		start = nyNode;
    	} else {
    		LinearNode<Film> current = start;
    		while (current.getNeste() != null) {
    			current = current.getNeste();
    		}
    		current.setNeste(nyNode);
    	}
    	antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (start == null) return false;
        if (start.getElement().getFilmnr() == filmnr) {
        	start = start.getNeste();
        	antall--;
        	return true;
        }
        LinearNode<Film> current = start;
        while (current.getNeste() != null) {
        	if(current.getNeste().getElement().getFilmnr() == filmnr) {
        		current.setNeste(current.getNeste().getNeste());
        		antall--;
        		return true;
        	}
        	current = current.getNeste();
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        ArrayList<Film> resultater = new ArrayList<>();
        LinearNode<Film> current = start;
        
        while (current != null) {
            if (current.getElement().getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                resultater.add(current.getElement()); 
            }
            current = current.getNeste(); 
        }
        return resultater.toArray(new Film[0]); 
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        ArrayList<Film> resultater = new ArrayList<>();
        LinearNode<Film> current = start;
        
        while (current != null) {
            if (current.getElement().getFilmskaper().toLowerCase().contains(delstreng.toLowerCase())) {
                resultater.add(current.getElement()); 
            }
            current = current.getNeste(); 
        }
        return resultater.toArray(new Film[0]); 
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antall = 0;
        LinearNode<Film> current = start;
        
        while (current != null) {
            if (current.getElement().getSjanger().equals(sjanger)) {
                antall++;
            }
            current = current.getNeste(); 
        }
        return antall;
    }

    @Override
    public int antall() {
        return antall; 
    }

	@Override
	public Film[] hentAlleFilmer() {
	    Film[] resultat = new Film[antall]; 
	    LinearNode<Film> current = start;
	    int indeks = 0;

	    while (current != null) {
	        resultat[indeks] = current.getElement(); 
	        current = current.getNeste(); // Gå til neste node
	        indeks++;
	    }

	    return resultat; // Returner arrayet med alle filmene
	}

}
