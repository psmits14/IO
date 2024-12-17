package Kontroler.Kontroler;

import Model.Model.*;

public class StrategiaSprawdzaniaKlienta implements StrategiaSprawdzaniaBiletow {

	@Override
	public void wykonajStrategie(InterakcjeZUzytkownikiem interakcjeZUzytkownikiem, ObslugaBiletow obslugaBiletow) {
		System.out.println("Strategia dla Klienta: Sprawdzanie biletu...");

		int nrBiletu = interakcjeZUzytkownikiem.podajNrBiletu();
		Bilet bilet = obslugaBiletow.pobierzBilet(nrBiletu);

		if (bilet != null && obslugaBiletow.sprawdzWaznosc(nrBiletu)) {
			System.out.println("Bilet nr " + nrBiletu + " jest ważny.");
			System.out.println("Bilet ważny do: " + bilet.getDataWaznosci());
		} else {
			System.out.println("Bilet nr " + nrBiletu + " jest nieważny.");
		}
	}
}
