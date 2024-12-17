package Widok.Widok;

import java.util.*;

import Kontroler.Kontroler.InterakcjeZUzytkownikiem;
import Model.Model.*;

public class FasadaFabrykaWidoku implements WyswietlanieInformacji {

	private Collection<Integer> idAplikacji = new ArrayList<>();
	private InterakcjeZUzytkownikiem interakcjaZUzytkownikiem;

	public FasadaFabrykaWidoku(InterakcjeZUzytkownikiem interakcjaZUzytkownikiem) {
		this.interakcjaZUzytkownikiem = interakcjaZUzytkownikiem;
		System.out.println("Fabryka widoku zainicjalizowana.");
	}

	@Override
	public void wyswietlOpcje() {
		System.out.println("1. Dodaj linie autobusowa.");
		System.out.println("2. Wyswietl informacje o linii autobusowej.");
		System.out.println("3. Wyświetl informacje o przystanku.");
		System.out.println("4. Sprawdź ważność biletu.");
		System.out.println("5. Zakończ.");
	}

	@Override
	public void wyswietlInfoLinia(LiniaAutobusowa liniaAutobusowa) {
		if (liniaAutobusowa != null) {
			System.out.println("Numer linii: " + liniaAutobusowa.getNrLinii());
			System.out.println("Przystanki na linii:");
			liniaAutobusowa.getPrzystanki().forEach(przystanek ->
					System.out.println("- " + przystanek.getPrzystanek().getNazwa())
			);
		} else {
			System.out.println("Brak danych o linii autobusowej.");
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
			System.out.println("Brak danych o przystanku.");
		}
	}


	@Override
	public void wyswietlInfoWaznoscBiletu(Bilet bilet) {
		if (bilet != null) {
			boolean wazny = bilet.SprawdzWaznosc(bilet.getNrBiletu());
			System.out.println("Bilet nr " + bilet.getNrBiletu() + " jest " +
					(wazny ? "ważny." : "nieważny."));
		} else {
			System.out.println("Bilet nie istnieje.");
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
}
