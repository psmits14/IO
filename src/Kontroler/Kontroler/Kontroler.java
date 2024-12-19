package Kontroler.Kontroler;

import Model.Model.*;
import Widok.Widok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

public class Kontroler {

	private WyswietlanieInformacji wyswietlanieInformacji;
	private Kontekst kontekst;
	private ObslugaLinii obslugaLinii;
	private ObslugaBiletow obslugaBiletow;
	private InterakcjeZUzytkownikiem interakcjeZUzytkownikiem;

	/**
	 * Konstruktor klasy Kontroler.
	 *
	 * @param obslugaLinii           interfejs obsługi linii
	 * @param obslugaBiletow         interfejs obsługi biletów
	 * @param wyswietlanieInformacji interfejs do wyświetlania informacji
	 * @param interakcjeZUzytkownikiem interfejs do interakcji z użytkownikiem
	 */
	public Kontroler(ObslugaLinii obslugaLinii, ObslugaBiletow obslugaBiletow, WyswietlanieInformacji wyswietlanieInformacji, InterakcjeZUzytkownikiem interakcjeZUzytkownikiem) {
		this.obslugaLinii = obslugaLinii;
		this.obslugaBiletow = obslugaBiletow;
		this.wyswietlanieInformacji = wyswietlanieInformacji;
		this.interakcjeZUzytkownikiem = interakcjeZUzytkownikiem;
		this.kontekst = new Kontekst();
	}

	/**
	 * Wyświetla menu główne aplikacji i obsługuje wybór użytkownika.
	 */
	public void pokazMenu() {
		boolean running = true;
		while (running) {
			wyswietlanieInformacji.wyswietlOpcje();
			int opcja = interakcjeZUzytkownikiem.podajWyborMenu(); // Wykorzystanie metody do pobrania liczby

			switch (opcja) {
				case 1:	//dodaj linie
					dodawanieLinii();
					break;
				case 2:	//info linia
					informacjeLinia();
					break;
				case 3:	//info przystanek
					informacjePrzystanek();
					break;
				case 4:	//sprawdz waznosc
					sprawdzanieWaznosci();
					break;
				case 5:	//koniec
					wyswietlanieInformacji.wyswietlInformacje("Zamykanie aplikacji...");
					running = false;
					break;
				default:
					wyswietlanieInformacji.wyswietlBlad("Nieprawidłowa opcja. ");
			}
		}
	}

	/**
	 * Dodaje nową linię autobusową, pojazdy oraz przystanki wraz z godzinami odjazdów.
	 */
	public void dodawanieLinii() {

		int nrLinii = interakcjeZUzytkownikiem.podajNrLinii();

		boolean liniaDodana = obslugaLinii.dodajLinie(nrLinii);

		if (liniaDodana) {
			LiniaAutobusowa nowaLinia = obslugaLinii.znajdzLinie(nrLinii);

			int liczbaPojazdow = interakcjeZUzytkownikiem.podajIle("Ile pojazdów chcesz dodać do linii? ");
			for (int i = 1; i <= liczbaPojazdow; i++) {
				String nrRejestracyjny = interakcjeZUzytkownikiem.podajNrRejesstracyjny();
				boolean pojazdDodany = nowaLinia.dodajPojazdDoLinii(nrRejestracyjny);
				if (pojazdDodany) {
					wyswietlanieInformacji.wyswietlPowodzenie("Dodano pojazd");
				} else {
					wyswietlanieInformacji.wyswietlBlad("Pojazd o tym numerze już istnieje.");
				}
			}

			int liczbaPrzystankow = interakcjeZUzytkownikiem.podajIle("Ile przystanków chcesz dodać do linii? ");
			for (int i = 1; i <= liczbaPrzystankow; i++) {
				String nazwaPrzystanku = interakcjeZUzytkownikiem.podajNazwePrzystanku();
				boolean przystanekDodany = nowaLinia.dodajPrzystanekDoLinii(nazwaPrzystanku);

				if (przystanekDodany) {
					wyswietlanieInformacji.wyswietlPowodzenie("Dodano przystanek. ");

					// Ustawianie godzin odjazdów dla przystanku
					int liczbaGodzin = interakcjeZUzytkownikiem.podajIle("Ile godzin odjazdów chcesz dodać dla przystanku \"" + nazwaPrzystanku + "\"? ");
					Collection<LocalTime> godzinyOdjazdow = new ArrayList<>();
					for (int j = 1; j <= liczbaGodzin; j++) {
						LocalTime godzina = interakcjeZUzytkownikiem.podajGodzineOdjazdu();
						godzinyOdjazdow.add(godzina);
					}
					boolean godzinyDodane = nowaLinia.dodajGodzinyOdjazdowPrzystanku(nazwaPrzystanku, godzinyOdjazdow);
					if (godzinyDodane) {
						wyswietlanieInformacji.wyswietlPowodzenie("Dodano godziny odjazdów.");
					} else {
						wyswietlanieInformacji.wyswietlBlad("Nie udało się dodać godzin odjazdów. ");
					}
				} else {
					wyswietlanieInformacji.wyswietlBlad("Przystanek już istnieje w tej linii.");
				}
			}
			wyswietlanieInformacji.wyswietlPowodzenie("Linia autobusowa nr " + nrLinii + " została pomyślnie utworzona i skonfigurowana.");
		} else {
			wyswietlanieInformacji.wyswietlBlad("Linia autobusowa już istnieje.");
		}
	}

	/**
	 * Wyświetla informacje o linii autobusowej.
	 */
	public void informacjeLinia() {
		wyswietlanieInformacji.wyswietlInformacje("--- Wyświetlanie informacji o linii autobusowej ---");
		int nrLinii = interakcjeZUzytkownikiem.podajNrLinii();
		LiniaAutobusowa linia = obslugaLinii.znajdzLinie(nrLinii);

		if (linia != null) {
			wyswietlanieInformacji.wyswietlInfoLinia(linia);
		} else {
			wyswietlanieInformacji.wyswietlBlad("Linia o numerze " + nrLinii + " nie istnieje.");
		}
	}

	/**
	 * Wyświetla informacje o przystanku w linii autobusowej.
	 */
	public void informacjePrzystanek() {
		wyswietlanieInformacji.wyswietlInformacje("--- Wyświetlanie informacji o przystanku w linii autobusowej ---");

		int nrLinii = interakcjeZUzytkownikiem.podajNrLinii();
		LiniaAutobusowa linia = obslugaLinii.znajdzLinie(nrLinii);

		if (linia != null) {
			String nazwaPrzystanku = interakcjeZUzytkownikiem.podajNazwePrzystanku();
			PrzystanekLinii przystanek = linia.znajdzPrzystanek(nazwaPrzystanku);

			if (przystanek != null) {
				wyswietlanieInformacji.wyswietlInfoPrzystanek(przystanek);
			} else {
				wyswietlanieInformacji.wyswietlBlad("Przystanek \"" + nazwaPrzystanku + "\" nie istnieje w linii nr " + nrLinii + ".");
			}
		} else {
			wyswietlanieInformacji.wyswietlBlad("Linia o numerze " + nrLinii + " nie istnieje.");
		}
	}

	/**
	 * Sprawdza ważność biletu na podstawie wybranej strategii.
	 */
	public void sprawdzanieWaznosci() {
		// Pobieranie roli użytkownika
		Rola rolaUzytkownika = interakcjeZUzytkownikiem.podajSwojaRole();

		// Wybór strategii na podstawie roli
		if (rolaUzytkownika == null) {
			wyswietlanieInformacji.wyswietlBlad("Nie udało się określić roli użytkownika.");
			return;
		}

		switch (rolaUzytkownika) {
			case Klient:
				kontekst.setStrategia(new StrategiaSprawdzaniaKlienta(wyswietlanieInformacji));
				break;
			case Kontroler_biletow:
				kontekst.setStrategia(new StrategiaSprawdzaniaKontrolera(wyswietlanieInformacji));
				break;
			default:
				wyswietlanieInformacji.wyswietlInformacje("Brak możliwości sprawdzenia biletów dla roli: " + rolaUzytkownika);
				return;
		}

		// Przekazanie zależności do strategii i jej wykonanie
		kontekst.wykonajStrategie(interakcjeZUzytkownikiem, obslugaBiletow);
	}


	/**
	 * Główna metoda uruchamiająca program.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		InterakcjeZUzytkownikiem interakcje = new FasadaInterakcji();
		WyswietlanieInformacji widok = new FasadaFabrykaWidoku();
		ObslugaLinii obslugaLinii = new FasadaLinii();
		ObslugaBiletow obslugaBiletow = new FasadaBiletow();

		obslugaBiletow.dodajPrzykladoweBilety();

		Kontroler kontroler = new Kontroler(obslugaLinii, obslugaBiletow, widok, interakcje);

		kontroler.pokazMenu();
	}

}