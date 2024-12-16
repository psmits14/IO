package Kontroler.Kontroler;

import Widok.Widok.*;
import Model.Model.*;

public class StrategiaSprawdzaniaKlienta implements StrategiaSprawdzaniaBiletow {

	@Override
	public void wykonajStrategie(FasadaInterakcji fasadaInterakcji, ObslugaBiletow obslugaBiletow) {
		System.out.println("Strategia dla Klienta: Sprawdzanie biletu...");

		int nrBiletu = fasadaInterakcji.podajNrBiletu();
		boolean czyWazny = obslugaBiletow.sprawdzWaznosc(nrBiletu);

		if (czyWazny) {
			System.out.println("Bilet nr " + nrBiletu + " jest ważny.");
		} else {
			System.out.println("Bilet nr " + nrBiletu + " jest nieważny.");
		}
	}
}
