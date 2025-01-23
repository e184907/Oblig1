package no.hvl.data102.filmarkiv.klient;

import javax.swing.JOptionPane;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;

public class Tekstgrensesnitt {
	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm() {
		String r = JOptionPane.showInputDialog("Skriv inn film nummer");
		String s = JOptionPane.showInputDialog("Skriv inn tittel");
		String h = JOptionPane.showInputDialog("Skriv inn år");
		String b = JOptionPane.showInputDialog("Skriv inn filmskaper");
		String a = JOptionPane.showInputDialog("Skriv inn filmselskap");
		
		Film f = new Film();
		
		int filmnr = Integer.parseInt(r);
		int aar = Integer.parseInt(h);
		f.setFilmnr(filmnr);
		f.setTittel(s);
		f.setFilmskaper(b);
		f.setFilmselskap(a);
		
	}

	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		// TODO
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