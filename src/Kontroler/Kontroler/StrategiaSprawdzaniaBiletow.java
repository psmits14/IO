package Kontroler.Kontroler;

import Model.Model.ObslugaBiletow;

public interface StrategiaSprawdzaniaBiletow {

	public void wykonajStrategie(InterakcjeZUzytkownikiem interakcjeZUzytkownikiem, ObslugaBiletow obslugaBiletow);
}