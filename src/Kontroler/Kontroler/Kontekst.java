package Kontroler.Kontroler;

public class Kontekst {

	private StrategiaSprawdzaniaBiletow strategia;

	/**
	 * Ustawia strategię sprawdzania biletów
	 * @param strategia - implementacja interfejsu StrategiaSprawdzaniaBiletow
	 */
	public void setStrategia(StrategiaSprawdzaniaBiletow strategia) {
		this.strategia = strategia;
	}

	/**
	 * Wykonuje aktualnie ustawioną strategię
	 */
	public void wykonajStrategie(FasadaInterakcji fasadaInterakcji, ObslugaBiletow obslugaBiletow) {
		if (strategia != null) {
			strategia.wykonajStrategie(fasadaInterakcji, obslugaBiletow);
		} else {
			System.out.println("Nie ustawiono strategii sprawdzania biletów.");
		}
	}

}
