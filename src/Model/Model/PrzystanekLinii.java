package Model.Model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

public class PrzystanekLinii extends Przystanek {

	private LiniaAutobusowa linia;
	private Collection<LocalTime> godzinyOdjazdow = new ArrayList<>();

	// Konstruktor z nazwą przystanku, linią autobusową i opcjonalnymi godzinami odjazdów
	public PrzystanekLinii(String nazwaPrzystanku, LiniaAutobusowa linia, Collection<LocalTime> godzinyOdjazdow) {
		super(nazwaPrzystanku); // Wywołanie konstruktora klasy nadrzędnej (Przystanek)
		this.linia = linia;
		if (godzinyOdjazdow != null) {
			this.godzinyOdjazdow = godzinyOdjazdow;
		}
	}

	// Getter dla linii
	public LiniaAutobusowa getLinia() {
		return linia;
	}

	// Setter dla linii
	public void setLinia(LiniaAutobusowa linia) {
		this.linia = linia;
	}

	// Getter dla godzin odjazdów
	public Collection<LocalTime> getGodzinyOdjazdow() {
		return godzinyOdjazdow;
	}

	// Setter dla godzin odjazdów
	public void setGodzinyOdjazdow(Collection<LocalTime> godzinyOdjazdow) {
		if (godzinyOdjazdow != null) {
			this.godzinyOdjazdow = godzinyOdjazdow;
		}
	}

	// Getter dla przystanku
	public Przystanek getPrzystanek() {
		return this; // Ponieważ dziedziczy po Przystanku, można zwrócić "this"
	}
}
