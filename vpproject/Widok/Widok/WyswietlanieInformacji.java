package Widok.Widok;

import Model.Model.*;

public interface WyswietlanieInformacji {

	void wyswietlOpcje();

	/**
	 * 
	 * @param liniaAutobusowa
	 */
	void wyswietlInfoLinia(LiniaAutobusowa liniaAutobusowa);

	/**
	 * 
	 * @param przystanekLinii
	 */
	void wyswietlInfoPrzystanek(PrzystanekLinii przystanekLinii);

	/**
	 * 
	 * @param bilet
	 */
	void wyswietlInfoWaznoscBiletu(Bilet bilet);

	/**
	 * 
	 * @param osoba
	 */
	void wyswietlDaneDoWeryfikacji(Osoba osoba);

}