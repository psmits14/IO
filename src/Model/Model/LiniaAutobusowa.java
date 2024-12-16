package Model.Model;

import java.time.LocalTime;
import java.util.*;

public class LiniaAutobusowa {

	private final int nrLinii; // Poprawione z nrLnii
	private Collection<PrzystanekLinii> przystanki = new ArrayList<>();
	private Collection<Pojazd> pojazdy = new ArrayList<>();

	public LiniaAutobusowa(int nrLinii) {
		this.nrLinii = nrLinii;
	}

	public int getNrLinii() {
		return nrLinii; // Poprawione odwołanie do pola
	}

	public boolean dodajPrzystanekDoLinii(String nazwaPrzystanku) {
		if (nazwaPrzystanku != null && !nazwaPrzystanku.isEmpty()) {
			Przystanek przystanek = new Przystanek(nazwaPrzystanku);
			PrzystanekLinii przystanekLinii = new PrzystanekLinii(nazwaPrzystanku, this, new ArrayList<>());
			if (!przystanki.contains(przystanekLinii)) {
				przystanki.add(przystanekLinii);
				return true;
			}
		}
		return false;
	}

	public void dodajPojazdDoLinii(String nrRejestracyjny) {
		if (nrRejestracyjny == null || nrRejestracyjny.isEmpty()) {
			System.out.println("Numer rejestracyjny pojazdu nie może być pusty.");
			return;
		}
		// Tworzenie nowego pojazdu za pomocą KreatoraPojazdow
		KreatorPojazdow kreator = new KreatorPojazdow();
		Pojazd nowyPojazd = kreator.stworzPojazd(nrRejestracyjny);

		// Dodanie pojazdu do listy, jeśli nie istnieje
		if (!pojazdy.contains(nowyPojazd)) {
			pojazdy.add(nowyPojazd);
			System.out.println("Dodano pojazd o numerze rejestracyjnym: " + nrRejestracyjny + " do linii: " + nrLinii);
		} else {
			System.out.println("Pojazd o numerze rejestracyjnym: " + nrRejestracyjny + " już istnieje w linii.");
		}
	}



	public void dodajGodzinyOdjazdowPrzystanku(String nazwaPrzystanku, Collection<LocalTime> godzinyOdjazdow) {
		if (nazwaPrzystanku == null || godzinyOdjazdow == null || godzinyOdjazdow.isEmpty()) {
			throw new IllegalArgumentException("Nazwa przystanku i godziny odjazdów nie mogą być puste.");
		}

		// Szukamy przystanku w kolekcji Przystanki
		for (PrzystanekLinii przystanekLinii : przystanki) {
			if (przystanekLinii.getPrzystanek().getNazwa().equals(nazwaPrzystanku)) {
				// Ustawiamy godziny odjazdów dla znalezionego przystanku
				przystanekLinii.setGodzinyOdjazdow(godzinyOdjazdow);
				System.out.println("Godziny odjazdów zostały dodane dla przystanku: " + nazwaPrzystanku);
				return;
			}
		}

		// Jeśli nie znaleziono przystanku
		System.out.println("Przystanek o nazwie '" + nazwaPrzystanku + "' nie istnieje w tej linii.");
	}


}