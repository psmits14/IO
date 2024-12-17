package Kontroler.Kontroler;

import Model.Model.*;
import Widok.Widok.*;

public class StrategiaSprawdzaniaKlienta implements StrategiaSprawdzaniaBiletow {

	private final WyswietlanieInformacji wyswietlanieInformacji;

	// Konstruktor do przekazania obiektu WyswietlanieInformacji
	public StrategiaSprawdzaniaKlienta(WyswietlanieInformacji wyswietlanieInformacji) {
		this.wyswietlanieInformacji = wyswietlanieInformacji;
	}

	@Override
	public void wykonajStrategie(InterakcjeZUzytkownikiem interakcjeZUzytkownikiem, ObslugaBiletow obslugaBiletow) {
		System.out.println("Strategia dla Klienta: Sprawdzanie biletu...");

		// Pobieranie numeru biletu od użytkownika
		int nrBiletu = interakcjeZUzytkownikiem.podajNrBiletu();
		Bilet bilet = obslugaBiletow.pobierzBilet(nrBiletu);

		if (bilet != null) {
			// Sprawdzenie ważności biletu
			boolean czyWazny = obslugaBiletow.sprawdzWaznosc(nrBiletu);
			wyswietlanieInformacji.wyswietlInfoWaznoscBiletu(czyWazny);

			if (czyWazny) {
				System.out.println("Bilet ważny do: " + bilet.getDataWaznosci());
			}
		} else {
			System.out.println("Bilet nr " + nrBiletu + " nie istnieje.");
		}
	}
}
