package Model.Model;

import java.util.*;

public class FasadaLinii {

	private Collection<LiniaAutobusowa> LinieAutobusowe = new ArrayList<>();

	/**
	 * 
	 * @param nrLinii
	 */
	public void dodajLinie(int nrLinii) {
		if (LinieAutobusowe.stream().noneMatch(linia -> linia.getNrLinii() == nrLinii)) {
			LiniaAutobusowa nowaLinia = new LiniaAutobusowa(nrLinii);
			LinieAutobusowe.add(nowaLinia);
			System.out.println("Dodano linię o numerze: " + nrLinii);
		} else {
			System.out.println("Linia o numerze " + nrLinii + " już istnieje.");
		}
	}

}