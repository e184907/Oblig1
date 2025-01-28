package no.hvl.data102.filmarkiv.klient;

import javax.swing.JOptionPane;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}

	public void start() {
	    Film film1 = new Film(1, "Quentin Tarantino", "Pulp Fiction", 1994, Sjanger.ACTION, "Miramax");
	    Film film2 = new Film(2, "Christopher Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros");
	    Film film3 = new Film(3, "Francis Ford Coppola", "The Godfather", 1972, Sjanger.DRAMA, "Paramount Pictures");
	    Film film4 = new Film(4, "Robert Zemeckis", "Back to the Future", 1985, Sjanger.SCIFI, "Universal Pictures");
	    
	    filmarkiv.leggTilFilm(film1);
	    filmarkiv.leggTilFilm(film2);
	    filmarkiv.leggTilFilm(film3);
	    filmarkiv.leggTilFilm(film4);
	    
	    skrivUtAlleFilmer();
	}

	public void skrivUtAlleFilmer() {
	    StringBuilder melding = new StringBuilder();
	    for (Film film : filmarkiv.hentAlleFilmer()) { 
	        melding.append(film.toString()).append("\n");
	    }
	    
	    JOptionPane.showMessageDialog(null, melding.toString());
	}

}