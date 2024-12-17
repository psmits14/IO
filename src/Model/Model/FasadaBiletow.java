package Model.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class FasadaBiletow implements ObslugaBiletow {

	private Collection<Bilet> Bilety = new ArrayList<>();

	public boolean sprawdzWaznosc(int nrBiletu) {
		for (Bilet bilet : Bilety) {
			if (bilet.SprawdzWaznosc(nrBiletu)) {
				return true; // Bilet jest ważny
			}
		}
		return false; // Nie znaleziono ważnego biletu
	}

	@Override
	public Bilet pobierzBilet(int nrBiletu) {
		for (Bilet bilet : Bilety) {
			if (bilet.getNrBiletu() == nrBiletu) {
				return bilet; // Zwraca bilet o podanym numerze
			}
		}
		return null; // Jeśli bilet o podanym numerze nie istnieje
	}

	public void dodajBilet(Bilet bilet) {
		if (bilet != null) {
			Bilety.add(bilet);
		}
	}

	public void dodajPrzykladoweBilety() {

		// Przykładowe bilety
		Bilet bilet1 = new Bilet(1, true, false, new Osoba("Jan", "Kowalski", 123456789, "AB123456", Rola.Klient), LocalDateTime.now().plusDays(5));
		Bilet bilet2 = new Bilet(2, true, true, new Osoba("Anna", "Nowak", 987654321, "CD987654", Rola.Klient), LocalDateTime.now().plusDays(3));
		Bilet bilet3 = new Bilet(3, false, false, null, LocalDateTime.now().minusDays(1)); // Nieważny bilet
		Bilet bilet4 = new Bilet(4, false, false, null, LocalDateTime.now().plusDays(10));

		// Dodanie biletów do kolekcji
		dodajBilet(bilet1);
		dodajBilet(bilet2);
		dodajBilet(bilet3);
		dodajBilet(bilet4);

		System.out.println("Przykładowe bilety zostały dodane do systemu.");
	}
}
