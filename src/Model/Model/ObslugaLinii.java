package Model.Model;

import java.util.Collection;

public interface ObslugaLinii {

	/**
	 * 
	 * @param nrLinii
	 */
	void dodajLinie(int nrLinii);

	LiniaAutobusowa znajdzLinie(int nrLinii);

	Collection<LiniaAutobusowa> getLinie();

}