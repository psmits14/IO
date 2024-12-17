package Kontroler.Kontroler;

import Widok.Widok.*;
import Model.Model.*;

public class StrategiaSprawdzaniaKlienta implements StrategiaSprawdzaniaBiletow {

	@Override
	public void wykonajStrategie(InterakcjeZUzytkownikiem interakcje, ObslugaBiletow obslugaBiletow) {
		System.out.println("Strategia dla Klienta: Sprawdzanie biletu...");

		int nrBiletu = interakcje.podajNrBiletu();
		Bilet bilet = obslugaBiletow.pobierzBilet(nrBiletu);

		if (bilet != null && obslugaBiletow.sprawdzWaznosc(nrBiletu)) {
			System.out.println("Bilet nr " + nrBiletu + " jest ważny.");
			System.out.println("Bilet ważny do: " + bilet.getDataWaznosci());
		} else {
			System.out.println("Bilet nr " + nrBiletu + " jest nieważny.");
		}
	}
}
