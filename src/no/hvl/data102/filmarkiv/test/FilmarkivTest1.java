package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.adt.Sjanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilmarkivTest1 {

    private Filmarkiv filmarkiv;
    private Film film1;
    private Film film2;
    private Film film3;

    @BeforeEach
    void setup() {
        filmarkiv = new Filmarkiv(5);
        
        film1 = new Film();
        film1.setFilmnr(1);
        film1.setTittel("Inception");
        film1.setFilmskaper("Christopher Nolan");
        
        film2 = new Film();
        film2.setFilmnr(2);
        film2.setTittel("Interstellar");
        film2.setFilmskaper("Christopher Nolan");
        
        film3 = new Film();
        film3.setFilmnr(3);
        film3.setTittel("Dunkirk");
        film3.setFilmskaper("Christopher Nolan");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
    }

    @Test
    void testLeggTilFilm() {
        // Test at vi kan legge til film
        filmarkiv.leggTilFilm(film3);
        assertEquals(3, filmarkiv.antall(), "Antallet filmer skal være 3 etter å ha lagt til film3");
    }

    @Test
    void testFinnFilm() {
        // Test finnFilm-metoden
        Film funnetFilm = filmarkiv.finnFilm(1);
        assertNotNull(funnetFilm, "Filmen med filmnummer 1 skal finnes");
        assertEquals("Inception", funnetFilm.getTittel(), "Filmens tittel skal være 'Inception'");
    }

    @Test
    void testSlettFilm() {
        // Test slettFilm-metoden
        boolean slettet = filmarkiv.slettFilm(1);
        assertTrue(slettet, "Filmen med filmnummer 1 skal slettes");
        assertNull(filmarkiv.finnFilm(1), "Filmen med filmnummer 1 skal ikke finnes etter sletting");
        assertEquals(1, filmarkiv.antall(), "Antallet filmer skal være 1 etter sletting");
    }

    @Test
    void testSoekTittel() {
        // Test soekTittel-metoden
        Film[] resultater = filmarkiv.soekTittel("Inception");
        assertEquals(1, resultater.length, "Søket på tittelen 'Inception' skal returnere én film");
        assertEquals("Inception", resultater[0].getTittel(), "Filmens tittel skal være 'Inception'");
    }

    @Test
    void testSoekProdusent() {
        // Test soekProdusent-metoden
        Film[] resultater = filmarkiv.soekProdusent("Christopher Nolan");
        assertEquals(2, resultater.length, "Søket på produsent 'Christopher Nolan' skal returnere to filmer");
    }

    @Test
    void testAntallFilmer() {
        // Test antall-filmer
        assertEquals(2, filmarkiv.antall(), "Antallet filmer i arkivet skal være 2");
    }
}

