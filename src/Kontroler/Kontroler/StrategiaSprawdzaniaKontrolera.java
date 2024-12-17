package Kontroler.Kontroler;

import Widok.Widok.*;
import Model.Model.*;

public class StrategiaSprawdzaniaKontrolera implements StrategiaSprawdzaniaBiletow {

	private final WyswietlanieInformacji wyswietlanieInformacji;

	// Konstruktor przyjmujący WyswietlanieInformacji
	public StrategiaSprawdzaniaKontrolera(WyswietlanieInformacji wyswietlanieInformacji) {
		this.wyswietlanieInformacji = wyswietlanieInformacji;
	}

	@Override
	public void wykonajStrategie(InterakcjeZUzytkownikiem interakcjeZUzytkownikiem, ObslugaBiletow obslugaBiletow) {
		System.out.println("Strategia dla Kontrolera: Dokładne sprawdzanie biletu...");

		// Pobieranie numeru biletu od użytkownika
		int nrBiletu = interakcjeZUzytkownikiem.podajNrBiletu();
		Bilet bilet = obslugaBiletow.pobierzBilet(nrBiletu);

		if (bilet != null) {
			boolean czyWazny = obslugaBiletow.sprawdzWaznosc(nrBiletu);

			// Użycie metody wyswietlInfoWaznoscBiletu
			wyswietlanieInformacji.wyswietlInfoWaznoscBiletu(czyWazny);

			// Dodatkowa logika dla biletów imiennych
			if (bilet.getImiennosc()) {
				System.out.println("Bilet jest imienny. Weryfikacja danych osoby...");

				Osoba osoba = bilet.getOsoba();
				if (osoba != null) {
					wyswietlanieInformacji.wyswietlDaneDoWeryfikacji(osoba);

					// Weryfikacja zgodności danych
					if (interakcjeZUzytkownikiem.zatwierdzZgodnoscOsoby()) {
						System.out.println("Zgodność danych została potwierdzona.");
					} else {
						System.out.println("Zgodność danych nie została potwierdzona. Bilet jest nieważny. Wystawianie mandatu.");
					}
				} else {
					System.out.println("Brak danych osoby przypisanej do biletu.");
				}
			}
		} else {
			System.out.println("Bilet nr " + nrBiletu + " nie istnieje. Proszę o przedstawienie ważnego biletu, inaczej konieczne bedzie wystawienie mandatu");
		}
	}
}
