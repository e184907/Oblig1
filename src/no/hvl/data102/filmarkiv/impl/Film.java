package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
    private int filmnr;
    private String filmskaper;
    private String tittel;
    private int aar;
    private Sjanger sjanger;
    private String selskap;
	private String filmselskap;

    // Konstruktør
    public Film(int filmnr, String filmskaper, String tittel, int aar, Sjanger sjanger, String selskap) {
        this.filmnr = filmnr;
        this.filmskaper = filmskaper;
        this.tittel = tittel;
        this.aar = aar;
        this.sjanger = sjanger;
        this.selskap = selskap;
    }
    @Override
    public String toString() {
        return "Filmnr: " + filmnr +
               "\nFilmskaper: " + filmskaper +
               "\nTittel: " + tittel +
               "\nÅr: " + aar +
               "\nSjanger: " + sjanger +
               "\nSelskap: " + selskap + "\n";
    }
	
	public int getFilmnr() {
		return filmnr;
	}
	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getFilmskaper() {
		return filmskaper;
	}

	public void setFilmskaper(String filmskaper) {
		this.filmskaper = filmskaper;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getAar() {
		return aar;
	}

	public void setAar(int aar) {
		this.aar = aar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselskap() {
		return getFilmselskap();
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aar, filmnr, filmselskap, filmskaper, sjanger, tittel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Film other = (Film) obj;
		return aar == other.aar && filmnr == other.filmnr && Objects.equals(getFilmselskap(), other.getFilmselskap())
				&& Objects.equals(filmskaper, other.filmskaper) && sjanger == other.sjanger
				&& Objects.equals(tittel, other.tittel);

		
	}

	
}
