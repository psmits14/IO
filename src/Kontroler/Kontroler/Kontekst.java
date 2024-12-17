package Kontroler.Kontroler;

import Widok.Widok.InterakcjeZUzytkownikiem;

public class Kontekst {

	private StrategiaSprawdzaniaBiletow strategia;

	/**
	 * Ustawia strategię sprawdzania biletów.
	 *
	 * @param strategia implementacja interfejsu StrategiaSprawdzaniaBiletow
	 */
	public void setStrategia(StrategiaSprawdzaniaBiletow strategia) {
		this.strategia = strategia;
	}

	/**
	 * Wykonuje aktualnie ustawioną strategię sprawdzania biletów.
	 *
	 * @param interakcje   interfejs do interakcji z użytkownikiem
	 * @param obslugaBiletow interfejs do sprawdzania biletów
	 */
	public void wykonajStrategie(InterakcjeZUzytkownikiem interakcje, ObslugaBiletow obslugaBiletow) {
		if (strategia != null) {
			strategia.wykonajStrategie(interakcje, obslugaBiletow);
		} else {
			System.out.println("Nie ustawiono strategii sprawdzania biletów.");
		}
	}
}
