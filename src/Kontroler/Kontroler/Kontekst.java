package Kontroler.Kontroler;

import Model.Model.ObslugaBiletow;

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
	 * @param interakcjeZUzytkownikiem interfejs do interakcji z użytkownikiem
	 * @param obslugaBiletow interfejs do sprawdzania biletów
	 */
	public void wykonajStrategie(InterakcjeZUzytkownikiem interakcjeZUzytkownikiem, ObslugaBiletow obslugaBiletow) {
			strategia.wykonajStrategie(interakcjeZUzytkownikiem, obslugaBiletow);
	}
}
