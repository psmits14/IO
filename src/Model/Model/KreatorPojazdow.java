package Model.Model;

/**
 * Klasa KreatorPojazdow odpowiedzialna za tworzenie obiektów {@link Pojazd}.
 */
public class KreatorPojazdow {

	/**
	 * Tworzy nowy pojazd z podanym numerem rejestracyjnym.
	 *
	 * @param nrRejestracyjny Numer rejestracyjny pojazdu, który ma zostać utworzony.
	 * @return Obiekt {@link Pojazd} z ustawionym numerem rejestracyjnym.
	 */
	public Pojazd stworzPojazd(String nrRejestracyjny) {
		Pojazd pojazd = new Pojazd();
		pojazd.setNrRejestracyjny(nrRejestracyjny);
		return pojazd;
	}
}
