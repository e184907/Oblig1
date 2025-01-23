package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class FilmarkivTest {
	
	private Filmarkiv arkiv;
    
	@BeforeEach
	void setup() throws Exception {
		arkiv = new Filmarkiv(10);
		
	}
	@Test
	void testLeggTilOgFjernFilm() {
		Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, Sjanger.ACTION, "Filmselskap1");
		arkiv.leggTilFilm(film1);
		assertEquals(1, arkiv.antall(), "Antall filmer bør være 1 etter å ha lagt til en film.");
		
		//filmen ble lagt til
		Film funnetFilm = arkiv.finnFilm(1);
		assertNotNull(funnetFilm, "Fant ikke film med nummer 1");
		
		//fjern film
		boolean slettet = arkiv.slettFilm(film1.getFilmnr());
		assertTrue(slettet, "Filmen skal ha blitt slettet");
		assertNull(arkiv.finnFilm(film1.getFilmnr()), "film med nummer 1 bør ikke lenger finnes.");
		assertEquals(0,arkiv.antall(), "antalll filmer bør båre 0 etter fjernet film");
		
		
	}
	@Test
	void testSoekTittel() {
		Film film1=new Film(1, "Produsent1", "Tittel1", 2020, Sjanger.ACTION, "Filmselskap1");
		Film film2=new Film(2, "Produsent2", "Tittel2", 2024, Sjanger.DRAMA, "Filmselskap2");
		arkiv.leggTilFilm(film1);
		arkiv.leggTilFilm(film2);
		
		Film[] result = arkiv.soekTittel("Produsent");
		assertEquals(2, result.length, "skal finne to filmer som matcher delstrengen i tittelen");
		

	}
	@Test
	void testAntallSjanger() {
		Film film1=new Film(1, "Produsent1", "Tittel1", 2020, Sjanger.ACTION, "Filmselskap1");
		Film film2=new Film(2, "Produsent2", "Tittel2", 2024, Sjanger.DRAMA, "Filmselskap2");
		Film film3= new Film(3, "Produsent3", "Tittel3", 2018, Sjanger.ACTION, "Filmselskap3");
		arkiv.leggTilFilm(film1);
		arkiv.leggTilFilm(film2);
		arkiv.leggTilFilm(film3);
		
		assertEquals(2, arkiv.antall(Sjanger.ACTION), "Skal være 2 actionfilmer");
		assertEquals(1, arkiv.antall(Sjanger.DRAMA), "Skal være 1 dramafilm");

	}

} 
