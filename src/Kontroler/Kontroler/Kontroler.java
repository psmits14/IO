package Kontroler.Kontroler;

import Model.Model.ObslugaBiletow;
import Model.Model.ObslugaLinii;
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

	public Kontroler(ObslugaLinii obslugaLinii, ObslugaBiletow obslugaBiletow, WyswietlanieInformacji wyswietlanieInformacji,
					 InterakcjeZUzytkownikiem interakcjeZUzytkownikiem) {
		this.obslugaLinii = obslugaLinii;
		this.obslugaBiletow = obslugaBiletow;
		this.wyswietlanieInformacji = wyswietlanieInformacji;
		this.interakcjeZUzytkownikiem = interakcjeZUzytkownikiem;
		this.kontekst = new Kontekst();
	}

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
					System.out.println("Zamykanie aplikacji...");
					running = false;
					break;
				default:
					wyswietlanieInformacji.wyswietlBlad("Nieprawidłowa opcja. ");
			}
		}
	}



	public void dodawanieLinii() {
		System.out.println("--- Dodawanie nowej linii autobusowej ---");
		// Pobranie numeru linii
		int nrLinii = interakcjeZUzytkownikiem.podajNrLinii();

		// Dodanie linii autobusowej do systemu
		obslugaLinii.dodajLinie(nrLinii);
		LiniaAutobusowa nowaLinia = obslugaLinii.znajdzLinie(nrLinii);

		if (nowaLinia != null) {
			// Dodanie pojazdów
			int liczbaPojazdow = interakcjeZUzytkownikiem.podajIle("Ile pojazdów chcesz dodać do linii? "); // Wykorzystując metodę jako input liczbowy
			for (int i = 0; i < liczbaPojazdow; i++) {
				String nrRejestracyjny = interakcjeZUzytkownikiem.podajNrRejesstracyjny();
				nowaLinia.dodajPojazdDoLinii(nrRejestracyjny);
			}

			// Dodanie przystanków
			int liczbaPrzystankow = interakcjeZUzytkownikiem.podajIle("Ile przystanków chcesz dodać do linii? ");
			for (int i = 0; i < liczbaPrzystankow; i++) {
				String nazwaPrzystanku = interakcjeZUzytkownikiem.podajNazwePrzystanku();
				boolean przystanekDodany = nowaLinia.dodajPrzystanekDoLinii(nazwaPrzystanku);
				if (przystanekDodany) {
					// Ustawianie godzin odjazdów
					int liczbaGodzin = interakcjeZUzytkownikiem.podajIle("Ile godzin odjazdów chcesz dodać dla przystanku \"" + nazwaPrzystanku + "\"? ");
					Collection<LocalTime> godzinyOdjazdow = new ArrayList<>();
					for (int j = 0; j < liczbaGodzin; j++) {
						LocalTime godzina = interakcjeZUzytkownikiem.podajGodzineOdjazdu();
						godzinyOdjazdow.add(godzina);
					}
					nowaLinia.dodajGodzinyOdjazdowPrzystanku(nazwaPrzystanku, godzinyOdjazdow);
				} else {
					wyswietlanieInformacji.wyswietlBlad("Przystanek \"" + nazwaPrzystanku + "\" już istnieje.");
				}
			}
			wyswietlanieInformacji.wyswietlPowodzenie("Linia autobusowa nr " + nrLinii + " została pomyślnie utworzona i skonfigurowana.");
		} else {
			wyswietlanieInformacji.wyswietlBlad("Nie udało się dodać linii autobusowej.");
		}
	}


	public void informacjeLinia() {
		System.out.println("--- Wyświetlanie informacji o linii autobusowej ---");

		// Pobieranie numeru linii od użytkownika
		int nrLinii = interakcjeZUzytkownikiem.podajNrLinii();

		// Wyszukiwanie linii autobusowej
		LiniaAutobusowa linia = obslugaLinii.znajdzLinie(nrLinii);

		if (linia != null) {
			// Wyświetlenie informacji o linii za pomocą WyswietlanieInformacji
			wyswietlanieInformacji.wyswietlInfoLinia(linia);
		} else {
			wyswietlanieInformacji.wyswietlBlad("Linia o numerze " + nrLinii + " nie istnieje.");
		}
	}

	public void informacjePrzystanek() {
		System.out.println("--- Wyświetlanie informacji o przystanku w linii autobusowej ---");

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


	public void sprawdzanieWaznosci() {
		// Pobieranie roli użytkownika
		Rola rolaUzytkownika = interakcjeZUzytkownikiem.podajSwojaRole();

		// Wybór strategii na podstawie roli
		if (rolaUzytkownika == null) {
			System.out.println("Nie udało się określić roli użytkownika.");
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
				System.out.println("Brak strategii dla roli: " + rolaUzytkownika);
				return;
		}

		// Przekazanie zależności do strategii i jej wykonanie
		kontekst.wykonajStrategie(interakcjeZUzytkownikiem, obslugaBiletow);
	}


	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		InterakcjeZUzytkownikiem interakcje = new FasadaInterakcji();
		WyswietlanieInformacji widok = new FasadaFabrykaWidoku(interakcje);
		ObslugaLinii obslugaLinii = new FasadaLinii();
		ObslugaBiletow obslugaBiletow = new FasadaBiletow();

		// Dodanie przykładowych biletów
		obslugaBiletow.dodajPrzykladoweBilety();

		// Tworzenie kontrolera z wymaganymi zależnościami
		Kontroler kontroler = new Kontroler(obslugaLinii, obslugaBiletow, widok, interakcje);

		// Uruchomienie menu aplikacji
		kontroler.pokazMenu();
	}

}