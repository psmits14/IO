package Kontroler.Kontroler;

import Widok.Widok.InterakcjeZUzytkownikiem;

public interface StrategiaSprawdzaniaBiletow {

	public void wykonajStrategie(InterakcjeZUzytkownikiem interakcje, ObslugaBiletow obslugaBiletow);// czy korzystać z interfejsow czy klas ktore je implementuja
}