package Kontroler.Kontroler;

import Model.Model.Rola;
import Widok.Widok.*;

public class Kontroler {

	private WyswietlanieInformacji wyswietlenieInformacji;
	private Kontekst kontekst;
	private ObslugaLinii obslugaLinii;
	private ObslugaBiletow obslugaBiletow;
	private InterakcjeZUzytkownikiem  interakcje;
	private FasadaInterakcji fasadaInterakcji;

	/**
	 *
	 * @param nrBiletu
	 */
	public boolean sprawdzWaznoscBiletu(int nrBiletu) {
		// TODO - implement Kontroler.sprawdzWaznoscBiletu
		return false;
	}

	/**
	 *
	 * @param nrLinii
	 */
	public void dodajLinie(int nrLinii) {
		// TODO - implement Kontroler.dodajLinie
	}

	public boolean zatwierdzZgodnoscOsoby() {
		// TODO - implement Kontroler.zatwierdzZgodnoscOsoby
		return false;
	}

	public int podajNrBiletu() {
		// TODO - implement Kontroler.podajNrBiletu
		return 0;
	}

	public int podajNrLinii() {
		// TODO - implement Kontroler.podajNrLinii
		return 0;
	}

	public void podajGodzineOdjazdu() {
		// TODO - implement Kontroler.podajGodzineOdjazdu
	}

	public void podajNazwePrzystanku() {
		// TODO - implement Kontroler.podajNazwePrzystanku
	}

	public void podajNrRejesstracyjny() {
		// TODO - implement Kontroler.podajNrRejesstracyjny
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO - implement Kontroler.main
	}


	public void wybierzStrategieSprawdzaniaBiletow() {
		// Pobieranie roli użytkownika
		Rola rolaUzytkownika = interakcje.podajSwojaRole();

		// Wybór strategii na podstawie roli
		if (rolaUzytkownika == null) {
			System.out.println("Nie udało się określić roli użytkownika.");
			return;
		}

		switch (rolaUzytkownika) {
			case Klient:
				kontekst.setStrategia(new StrategiaSprawdzaniaKlienta());
				break;
			case Kontroler_biletow:
				kontekst.setStrategia(new StrategiaSprawdzaniaKontrolera());
				break;
			default:
				System.out.println("Brak strategii dla roli: " + rolaUzytkownika);
				return;
		}

		// Przekazanie zależności do strategii i jej wykonanie
		kontekst.wykonajStrategie(interakcje, obslugaBiletow);
	}


}