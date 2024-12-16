package Model.Model;

import java.util.Objects;

public class Pojazd {
	private String nrRejestracyjny = "";

	public String getNrRejestracyjny() {
		return nrRejestracyjny;
	}

	public void setNrRejestracyjny(String nrRejestracyjny) {
		this.nrRejestracyjny = nrRejestracyjny;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Pojazd pojazd = (Pojazd) obj;
		return Objects.equals(nrRejestracyjny, pojazd.nrRejestracyjny);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nrRejestracyjny);
	}
}
