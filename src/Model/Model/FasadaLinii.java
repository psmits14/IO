package Model.Model;

import java.util.ArrayList;
import java.util.Collection;

public class FasadaLinii implements ObslugaLinii {

	private Collection<LiniaAutobusowa> LinieAutobusowe = new ArrayList<>();

	@Override
	public void dodajLinie(int nrLinii) {
		if (LinieAutobusowe.stream().noneMatch(linia -> linia.getNrLinii() == nrLinii)) {
			LiniaAutobusowa nowaLinia = new LiniaAutobusowa(nrLinii);
			LinieAutobusowe.add(nowaLinia);
			System.out.println("Dodano linię o numerze: " + nrLinii);
		} else {
			System.out.println("Linia o numerze " + nrLinii + " już istnieje.");
		}
	}

	@Override
	public LiniaAutobusowa znajdzLinie(int nrLinii) {
		return LinieAutobusowe.stream()
				.filter(linia -> linia.getNrLinii() == nrLinii)
				.findFirst()
				.orElse(null);
	}

	// Dodatkowa metoda do uzyskania listy linii, jeśli jest potrzebna w innych miejscach
	public Collection<LiniaAutobusowa> getLinie() {
		return LinieAutobusowe;
	}
}
