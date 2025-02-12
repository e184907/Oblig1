package no.hvl.data102.filmarkiv.klient;

import javax.swing.JOptionPane;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.*;

public class Tekstgrensesnitt {
	
	public Film lesFilm() {
	    try {
	        String r = JOptionPane.showInputDialog("Skriv inn film nummer");
	        String s = JOptionPane.showInputDialog("Skriv inn tittel");
	        String h = JOptionPane.showInputDialog("Skriv inn år");
	        String b = JOptionPane.showInputDialog("Skriv inn filmskaper");
	        String a = JOptionPane.showInputDialog("Skriv inn filmselskap");
	        String q = JOptionPane.showInputDialog("Skriv inn sjanger, alternativer er ACTION, DRAMA, HISTORY");
	        
	        // Håndterer ugyldige sjangernavn
	        Sjanger sjanger;
	        try {
	            sjanger = Sjanger.valueOf(q.toUpperCase());
	        } catch (IllegalArgumentException e) {
	            JOptionPane.showMessageDialog(null, "Ugyldig sjanger! Vennligst velg mellom ACTION, DRAMA, HISTORY.");
	            return null; // Returnerer null hvis sjangeren er ugyldig
	        }

	        // Håndterer ugyldig numerisk input
	        int filmnr = Integer.parseInt(r);
	        int aar = Integer.parseInt(h);

	        // Oppretter Film-objektet
	        Film f = new Film(filmnr, b, s, aar, sjanger, a);

	        return f;

	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Vennligst skriv inn gyldige tall for filmnummer og år.");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "En feil oppstod. Vennligst prøv igjen.");
	    }
	    
	    return null; // Returnerer null hvis noe gikk galt
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

	    Film[] filmer = arkiv.soekTittel(delstreng);

	    for (int i = 0; i < filmer.length; i++) {
	        Film film = filmer[i]; 
	        System.out.println("Tittel: " + film.getTittel());
	    }
	}

	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		Film[] filmer = arkiv.soekProdusent(delstreng);
		
		for (int i = 0; i < filmer.length; i++) {
			Film film = filmer[i];
			System.out.println("Produsent: " + film.getFilmskaper());
		}
	}

	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		int antall = arkiv.antall();
		
		System.out.println("Antall filmer:" + antall);
		
			Sjanger[] sjangTab = Sjanger.values();
			for(int i = 0; i < sjangTab.length; i++) {
				Sjanger sjanger = sjangTab[i];
				int antallSjanger = arkiv.antall(sjanger);
				System.out.println(sjanger + ": " + antallSjanger);
			}
		}
	}
	// osv ... andre metoder
