package Model.Model;

import Kontroler.Kontroler.*;
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

		public void dodajBilet(Bilet bilet) {
			if (bilet != null) {
				Bilety.add(bilet);
			}
		}
	}
