package no.hvl.data102.filmarkiv.impl;

import java.util.ArrayList;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT	{
	
	private int antall;
	private LinearNode<Film> start;
    private int nesteledig;

	public Filmarkiv2(){
		
	}
    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < nesteledig; i++) { // Endret fra filmer.length til nesteledig
            if (filmer[i] != null && filmer[i].getFilmnr() == nr) { // Sjekker om filmen ikke er null
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
            utvidKapasitet(); // Utvider tabellen dynamisk
            filmer[nesteledig] = nyFilm;
            nesteledig++;
        }
    }

    private void utvidKapasitet() {
        Film[] nyTabell = new Film[filmer.length * 2]; // Dobler kapasiteten
        for (int i = 0; i < filmer.length; i++) {
            nyTabell[i] = filmer[i];
        }
        filmer = nyTabell;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < nesteledig; i++) {
            if (filmer[i] != null && filmer[i].getFilmnr() == filmnr) { // Sjekker at filmen ikke er null
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

        for (int i = 0; i < nesteledig; i++) { // Endret fra filmer.length til nesteledig
            if (filmer[i] != null && filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                resultater.add(filmer[i]);
            }
        }
        return resultater.toArray(new Film[0]);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        ArrayList<Film> resultater = new ArrayList<>();

        for (int i = 0; i < nesteledig; i++) { // Endret fra filmer.length til nesteledig
            if (filmer[i] != null && filmer[i].getFilmskaper().toLowerCase().contains(delstreng.toLowerCase())) {
                resultater.add(filmer[i]);
            }
        }
        return resultater.toArray(new Film[0]);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antall = 0;
        for (int i = 0; i < nesteledig; i++) { 
            if (filmer[i] != null && filmer[i].getSjanger().equals(sjanger)) {
                antall++;
            }
        }
        return antall;
    }

    @Override
    public int antall() {
        return nesteledig;
    }
}
