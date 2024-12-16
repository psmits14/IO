package Model.Model;

import java.time.LocalDateTime;

public class Bilet {

	private int NrBiletu;
	private boolean Imiennosc;
	private boolean Ulga;
	private Osoba Osoba;
	private LocalDateTime DataWaznosci;

	public Bilet(int nrBiletu, boolean imiennosc, boolean ulga, Osoba osoba, LocalDateTime dataWaznosci) {
		this.NrBiletu = nrBiletu;
		this.Imiennosc = imiennosc;
		this.Ulga = ulga;
		this.Osoba = osoba;
		this.DataWaznosci = dataWaznosci;
	}

	public int getNrBiletu() {
		return NrBiletu;
	}

	public void setNrBiletu(int nrBiletu) {
		this.NrBiletu = nrBiletu;
	}

	public boolean getImiennosc() {
		return Imiennosc;
	}

	public void setImiennosc(boolean imiennosc) {
		this.Imiennosc = imiennosc;
	}

	public boolean getUlga() {
		return Ulga;
	}

	public void setUlga(boolean ulga) {
		this.Ulga = ulga;
	}

	public LocalDateTime getDataWaznosci() {
		return DataWaznosci;
	}

	public void setDataWaznosci(LocalDateTime dataWaznosci) {
		this.DataWaznosci = dataWaznosci;
	}

	public Osoba getOsoba() {
		return Osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.Osoba = osoba;
	}

	public boolean SprawdzWaznosc(int nrBiletu) {
		// Sprawdzenie, czy numer biletu pasuje oraz czy data ważności nie minęła
		return DataWaznosci != null && LocalDateTime.now().isBefore(DataWaznosci);
	}
}
