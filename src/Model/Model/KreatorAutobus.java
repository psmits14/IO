package Model.Model;

public class KreatorAutobus extends KreatorPojazdow {
    /**
     * Tworzy nowy pojazd z podanym numerem rejestracyjnym.
     *
     * @param nrRejestracyjny Numer rejestracyjny pojazdu, który ma zostać utworzony.
     * @return Obiekt {@link Pojazd} z ustawionym numerem rejestracyjnym.
     */
    public Pojazd stworzPojazd(String nrRejestracyjny) {
        Pojazd pojazd = new Autobus();
        pojazd.setNrRejestracyjny(nrRejestracyjny);
        return pojazd;
    }
}