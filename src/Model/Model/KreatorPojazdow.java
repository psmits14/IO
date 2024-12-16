package Model.Model;

public class KreatorPojazdow {

	// Metoda tworząca pojazd z podanym numerem rejestracyjnym
	public Pojazd stworzPojazd(String nrRejestracyjny) {
		if (nrRejestracyjny == null || nrRejestracyjny.isEmpty()) {
			throw new IllegalArgumentException("Numer rejestracyjny nie może być pusty.");
		}
		Pojazd pojazd = new Pojazd();
		pojazd.setNrRejestracyjny(nrRejestracyjny);
		return pojazd;
	}
}
