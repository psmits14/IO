package Kontroler.Kontroler;

import Model.Model.Rola;
import Widok.Widok.*;

import java.time.LocalTime;

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
		return interakcje.podajNrBiletu();
	}

	public int podajNrLinii() {
		return interakcje.podajNrLinii();
	}

	public void podajGodzineOdjazdu() {
		LocalTime godzina = interakcje.podajGodzineOdjazdu();
		System.out.println("Godzina odjazdu: " + godzina);
	}

	public void podajNazwePrzystanku() {
		String przystanek = interakcje.podajNazwePrzystanku();
		System.out.println("Nazwa przystanku: " + przystanek);
	}

	/**
	 * Pobiera numer rejestracyjny pojazdu.
	 */
	public void podajNrRejestracyjny() {
		String nrRejestracyjny = interakcje.podajNrRejesstracyjny();
		System.out.println("Numer rejestracyjny: " + nrRejestracyjny);
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
		Rola rolaUzytkownika = fasadaInterakcji.podajSwojaRole();

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
		kontekst.wykonajStrategie(fasadaInterakcji, obslugaBiletow);
	}


}