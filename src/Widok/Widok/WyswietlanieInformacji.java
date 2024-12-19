package Widok.Widok;

import Model.Model.*;

public interface WyswietlanieInformacji {

	void wyswietlOpcje();

	void wyswietlInfoLinia(LiniaAutobusowa liniaAutobusowa);

	void wyswietlInfoPrzystanek(PrzystanekLinii przystanekLinii);

	void wyswietlInfoWaznoscBiletu(boolean waznosc);

	void wyswietlDaneDoWeryfikacji(Osoba osoba);

	void wyswietlBlad(String komunikat);

	void wyswietlPowodzenie(String komunikat);

	void wyswietlInformacje(String komunikat);
}