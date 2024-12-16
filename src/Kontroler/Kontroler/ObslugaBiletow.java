package Kontroler.Kontroler;

import Model.Model.Bilet;

public interface ObslugaBiletow {
	boolean sprawdzWaznosc(int nrBiletu);
	Bilet pobierzBilet(int nrBiletu); // Pobiera bilet na podstawie numeru
}
