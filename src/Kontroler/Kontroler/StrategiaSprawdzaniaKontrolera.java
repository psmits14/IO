package Kontroler.Kontroler;

import Widok.Widok.*;
import Model.Model.*;

public class StrategiaSprawdzaniaKontrolera implements StrategiaSprawdzaniaBiletow {

	private WyswietlanieInformacji wyswietlanieInformacji;

	public StrategiaSprawdzaniaKontrolera(WyswietlanieInformacji wyswietlanieInformacji) {
		this.wyswietlanieInformacji = wyswietlanieInformacji;
	}

	@Override
	public void wykonajStrategie(FasadaInterakcji fasadaInterakcji, ObslugaBiletow obslugaBiletow) {
		System.out.println("Strategia dla Kontrolera: Dokładne sprawdzanie biletu...");

		// Pobieranie numeru biletu od użytkownika
		int nrBiletu = fasadaInterakcji.podajNrBiletu();
		Bilet bilet = obslugaBiletow.pobierzBilet(nrBiletu);

		if (bilet != null && obslugaBiletow.sprawdzWaznosc(nrBiletu)) {
			System.out.println("Bilet nr " + nrBiletu + " jest ważny.");

			// Wyświetlanie danych osoby przypisanej do biletu
			Osoba osoba = bilet.getOsoba();
			if (osoba != null) {
				wyswietlanieInformacji.wyswietlDaneDoWeryfikacji(osoba);

				// Weryfikacja zgodności danych
				if (fasadaInterakcji.zatwierdzZgodnoscOsoby()) {
					System.out.println("Zgodność danych została potwierdzona.");
				} else {
					System.out.println("Zgodność danych nie została potwierdzona. Bilet jest nieważny.");
				}
			} else {
				System.out.println("Brak danych osoby przypisanej do biletu.");
			}
		} else {
			System.out.println("Bilet nr " + nrBiletu + " jest nieważny lub nie istnieje.");
			System.out.println("Proszę o przedstawienie ważnego biletu.");
		}
	}
}
