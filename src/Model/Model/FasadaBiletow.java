package Model.Model;

import java.util.*;

public class FasadaBiletow implements ObslugaBiletow {
		private Collection<Bilet> Bilety = new ArrayList<>();

		public boolean sprawdzWaznosc(int nrBiletu) {
			for (Bilet bilet : Bilety) {
				if (bilet.SprawdzWaznosc(nrBiletu)) {
					return true; // Bilet jest ważny
				}
			}
			return false; // Nie znaleziono ważnego biletu
		}

	@Override
	public Bilet pobierzBilet(int nrBiletu) {
		for (Bilet bilet : Bilety) {
			if (bilet.getNrBiletu() == nrBiletu) {
				return bilet; // Zwraca bilet o podanym numerze
			}
		}
		return null; // Jeśli bilet o podanym numerze nie istnieje
	}

	public void dodajBilet(Bilet bilet) {
			if (bilet != null) {
				Bilety.add(bilet);
			}
		}
	}
