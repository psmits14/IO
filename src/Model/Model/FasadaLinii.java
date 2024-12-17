package Model.Model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Klasa implementująca interfejs {@link ObslugaLinii}.
 * Zarządza kolekcją linii autobusowych, umożliwia ich dodawanie i wyszukiwanie.
 */
public class FasadaLinii implements ObslugaLinii {

	private Collection<LiniaAutobusowa> LinieAutobusowe = new ArrayList<>();

	/**
	 * Dodaje nową linię autobusową, jeśli linia o podanym numerze nie istnieje.
	 *
	 * @param nrLinii Numer linii do dodania.
	 * @return True, jeśli linia została dodana; false, jeśli linia o takim numerze już istnieje.
	 */
	@Override
	public boolean dodajLinie(int nrLinii) {
		boolean czyIstnieje = LinieAutobusowe.stream()
				.anyMatch(linia -> linia.getNrLinii() == nrLinii);

		if (!czyIstnieje) {
			LiniaAutobusowa nowaLinia = new LiniaAutobusowa(nrLinii);
			LinieAutobusowe.add(nowaLinia);
			return true;
		}
		return false;
	}

	/**
	 * Wyszukuje linię autobusową na podstawie numeru linii.
	 *
	 * @param nrLinii Numer linii do wyszukania.
	 * @return Obiekt {@link LiniaAutobusowa}, jeśli linia istnieje; null, jeśli nie znaleziono linii.
	 */
	@Override
	public LiniaAutobusowa znajdzLinie(int nrLinii) {
		return LinieAutobusowe.stream()
				.filter(linia -> linia.getNrLinii() == nrLinii)
				.findFirst()
				.orElse(null);
	}
}
