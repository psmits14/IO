package Widok.Widok;

import java.util.*;

import Kontroler.Kontroler.InterakcjeZUzytkownikiem;
import Model.Model.*;

public class FasadaFabrykaWidoku implements WyswietlanieInformacji {

	public FasadaFabrykaWidoku() {
	}

	@Override
	public void wyswietlOpcje() {
		System.out.println("1. Dodaj linie autobusowa.");
		System.out.println("2. Wyświetl informacje o linii autobusowej.");
		System.out.println("3. Wyświetl informacje o przystanku.");
		System.out.println("4. Sprawdź ważność biletu.");
		System.out.println("5. Zakończ.");
	}

	@Override
	public void wyswietlInfoLinia(LiniaAutobusowa liniaAutobusowa) {
		if (liniaAutobusowa != null) {
			System.out.println("Numer linii: " + liniaAutobusowa.getNrLinii());

			// Sprawdzanie przystanków
			System.out.println("Przystanki na linii:");
			if (liniaAutobusowa.getPrzystanki().isEmpty()) {
				wyswietlBlad("Brak przystanków przypisanych do tej linii.");
			} else {
				liniaAutobusowa.getPrzystanki().forEach(przystanek ->
						System.out.println("- " + przystanek.getPrzystanek().getNazwa())
				);
			}

			// Sprawdzanie pojazdów
			System.out.println("Pojazdy przypisane do linii:");
			if (liniaAutobusowa.getPojazdy().isEmpty()) {
				System.out.println("Brak pojazdów przypisanych do tej linii.");
			} else {
				liniaAutobusowa.getPojazdy().forEach(pojazd ->
						System.out.println("- Numer rejestracyjny: " + pojazd.getNrRejestracyjny())
				);
			}
		} else {
			wyswietlBlad("Brak danych o linii autobusowej.");
		}
	}


	@Override
	public void wyswietlInfoPrzystanek(PrzystanekLinii przystanekLinii) {
		if (przystanekLinii != null) {
			System.out.println("Przystanek: " + przystanekLinii.getPrzystanek().getNazwa());
			System.out.println("Numer linii: " + przystanekLinii.getLinia().getNrLinii());
			System.out.println("Godziny odjazdów:");
			przystanekLinii.getGodzinyOdjazdow().forEach(godzina ->
					System.out.println("- " + godzina)
			);
		} else {
			wyswietlBlad("Brak danych o przystanku.");
		}
	}


	@Override
	public void wyswietlInfoWaznoscBiletu(boolean waznosc) {
		if (waznosc == true){
			System.out.println("Bilet jest ważny. :) ");
		}
		else {
			System.out.println("Bilet jest nieważny. :( ");
		}
	}

	@Override
	public void wyswietlDaneDoWeryfikacji(Osoba osoba) {
		if (osoba != null) {
			System.out.println("Imię: " + osoba.getImie());
			System.out.println("Nazwisko: " + osoba.getNazwisko());
			System.out.println("PESEL: " + osoba.getPesel());
			System.out.println("Nr Dokumentu: " + osoba.getNrDokumentu());
			System.out.println("Rola: " + osoba.getRola());
		} else {
			System.out.println("Brak danych o osobie.");
		}
	}

	@Override
	public void wyswietlBlad(String komunikat) {
		System.out.println("Błąd! " + komunikat);
	}

	@Override
	public void wyswietlPowodzenie(String komunikat) {
		System.out.println("Powodzenie! " + komunikat);
	}
}
