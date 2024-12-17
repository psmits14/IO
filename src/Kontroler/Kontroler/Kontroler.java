package Kontroler.Kontroler;

import Model.Model.ObslugaBiletow;
import Model.Model.ObslugaLinii;
import Model.Model.*;
import Widok.Widok.*;

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
			System.out.print("Wybierz opcję: ");
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
					System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
			}
		}
	}



	public void dodawanieLinii(){

	}

	public void informacjeLinia(){

	}

	public void informacjePrzystanek(){

	}

	public void sprawdzanieWaznosci(){

	}



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

	/**
	 * Pobiera numer rejestracyjny pojazdu.
	 */
	public void podajNrRejestracyjny() {

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

		// Tworzenie kontrolera z wymaganymi zależnościami
		Kontroler kontroler = new Kontroler(obslugaLinii, obslugaBiletow, widok, interakcje);

		// Uruchomienie menu aplikacji
		kontroler.pokazMenu();
	}


	public void wybierzStrategieSprawdzaniaBiletow() {
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


}