package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import impl.Film;
import impl.Filmarkiv;
import impl.Sjanger;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class FilmarkivTest {
	
	private Filmarkiv arkiv;
	
	void setup() throws Exception {
		arkiv = new Filmarkiv(5);
		
		int filmnr, String filmskaper, String tittel, int aar, Sjanger sjanger, String filmselskap
	}
	@Test
	void testLeggTilOgFjernFilm() {
		Film film1 = new Film(123, "Johnny Depp", "Pirat", 2020, Sjanger.ACTION, "Disney");
		arkiv.leggTilFilm(film1);
		assertEquals(1, arkiv.antall(), "Antall filmer bør være 1 etter å ha lagt til en film.");
	}

} 
