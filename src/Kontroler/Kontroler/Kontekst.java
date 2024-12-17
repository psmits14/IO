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
	 * @param fasadaInterakcji fasada do interakcji z użytkownikiem
	 * @param obslugaBiletow interfejs do sprawdzania biletów
	 */
	public void wykonajStrategie(FasadaInterakcji fasadaInterakcji, ObslugaBiletow obslugaBiletow) {
		if (strategia != null) {
			strategia.wykonajStrategie(fasadaInterakcji, obslugaBiletow);
		} else {
			System.out.println("Nie ustawiono strategii sprawdzania biletów.");
		}
	}
}
