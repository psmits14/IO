package Kontroler.Kontroler;

import Model.Model.*;
import Widok.Widok.*;

import java.time.LocalDateTime;

/**
 * Klasa implementująca interfejs {@link StrategiaSprawdzaniaBiletow}.
 * Klasa implementująca strategię sprawdzania ważności biletu dla klienta.
 */
public class StrategiaSprawdzaniaKlienta implements StrategiaSprawdzaniaBiletow {

	private final WyswietlanieInformacji wyswietlanieInformacji;

	/**
	 * Konstruktor klasy StrategiaSprawdzaniaKlienta.
	 *
	 * @param wyswietlanieInformacji interfejs do wyświetlania informacji
	 */
	public StrategiaSprawdzaniaKlienta(WyswietlanieInformacji wyswietlanieInformacji) {
		this.wyswietlanieInformacji = wyswietlanieInformacji;
	}

	/**
	 * Wykonuje strategię sprawdzania ważności biletu.
	 *
	 * @param interakcjeZUzytkownikiem interfejs do interakcji z użytkownikiem
	 * @param obslugaBiletow           interfejs do obsługi biletów
	 */
	@Override
	public void wykonajStrategie(InterakcjeZUzytkownikiem interakcjeZUzytkownikiem, ObslugaBiletow obslugaBiletow) {
		int nrBiletu = interakcjeZUzytkownikiem.podajNrBiletu();
		Bilet bilet = obslugaBiletow.pobierzBilet(nrBiletu);

		if (bilet != null) {
			boolean czyWazny = obslugaBiletow.sprawdzWaznosc(nrBiletu);
			wyswietlanieInformacji.wyswietlInfoWaznoscBiletu(czyWazny);

			if (czyWazny) {
				LocalDateTime data = bilet.getDataWaznosci();
				wyswietlanieInformacji.wyswietlInformacje("Bilet ważny do: " + data);
			}
		} else {
			wyswietlanieInformacji.wyswietlBlad("Bilet nie istnieje.");
		}
	}
}
