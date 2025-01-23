package no.hvl.data102.filmarkiv.klient;

import javax.swing.JOptionPane;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.*;

public class Tekstgrensesnitt {
	
	public Film lesFilm() {
		String r = JOptionPane.showInputDialog("Skriv inn film nummer");
		String s = JOptionPane.showInputDialog("Skriv inn tittel");
		String h = JOptionPane.showInputDialog("Skriv inn år");
		String b = JOptionPane.showInputDialog("Skriv inn filmskaper");
		String a = JOptionPane.showInputDialog("Skriv inn filmselskap");
		String q = JOptionPane.showInputDialog("Skriv inn sjanger, alternativer er ACTION, DRAMA, HISTORY eller DRAMA");
		
		Sjanger sjanger = Sjanger.valueOf(q.toUpperCase());
		int filmnr = Integer.parseInt(r);
		int aar = Integer.parseInt(h);
		
		Film f = new Film(filmnr, b, s, aar, sjanger, a);
		
		return f;
	}

	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		
		int filmnr = film.getFilmnr();
		String tittel = film.getTittel();
		int aar = film.getAar();
		String filmskaper = film.getFilmskaper();
		String filmselskap = film.getFilmselskap();
		Sjanger sjanger = film.getSjanger();
		
		String sj = sjanger.toString();
		
		JOptionPane.showMessageDialog(null, "Filmnummer: " + filmnr + "/n" + "Tittel: " + tittel + "/n" + "År: " + aar + "/n" + "Filmskaper: " + filmskaper + "/n" + "Filmselskap: " + filmselskap + "/n" + "Sjanger: " + sj);
		
	}

	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		// TODO
	}

	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		// TODO
	}

	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		// TODO
	}
	// osv ... andre metoder
}