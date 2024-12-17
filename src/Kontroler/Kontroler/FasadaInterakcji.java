package Kontroler.Kontroler;

import Model.Model.Rola;

import java.time.LocalTime;
import java.util.Scanner;

public class FasadaInterakcji implements InterakcjeZUzytkownikiem {

	private final Scanner scanner = new Scanner(System.in);

	@Override
	public int podajNrBiletu() {
		int nrBiletu = 0;
		boolean poprawneDane = false;

		while (!poprawneDane) {
			System.out.print("Podaj numer biletu: ");
			if (scanner.hasNextInt()) {
				nrBiletu = scanner.nextInt();
				poprawneDane = true;
			} else {
				System.out.println("Nieprawidłowy numer. Spróbuj ponownie.");
				scanner.next(); // Wyczyść nieprawidłowe dane
			}
		}
		return nrBiletu;
	}

	@Override
	public boolean zatwierdzZgodnoscOsoby() {
		System.out.print("Czy dane osoby są zgodne? (tak/nie): ");
		String odpowiedz;

		do {
			odpowiedz = scanner.next().trim().toLowerCase();
			if (odpowiedz.equals("tak")) {
				return true;
			} else if (odpowiedz.equals("nie")) {
				return false;
			} else {
				System.out.println("Nieprawidłowa odpowiedź. Podaj 'tak' lub 'nie'.");
			}
		} while (true);
	}

	@Override
	public int podajNrLinii() {
		int nrLinii = 0;
		boolean poprawneDane = false;

		while (!poprawneDane) {
			System.out.print("Podaj numer linii: ");
			if (scanner.hasNextInt()) {
				nrLinii = scanner.nextInt();
				poprawneDane = true;
			} else {
				System.out.println("Nieprawidłowy numer. Spróbuj ponownie.");
				scanner.next(); // Wyczyść nieprawidłowe dane
			}
		}
		return nrLinii;
	}

	@Override
	public String podajNazwePrzystanku() {
		System.out.print("Podaj nazwę przystanku: ");
		return scanner.next();
	}

	@Override
	public String podajNrRejesstracyjny() {
		System.out.print("Podaj numer rejestracyjny pojazdu: ");
		return scanner.next();
	}

	@Override
	public LocalTime podajGodzineOdjazdu() {
		LocalTime godzinaOdjazdu = null;
		boolean poprawneDane = false;

		while (!poprawneDane) {
			System.out.print("Podaj godzinę odjazdu (HH:mm): ");
			String input = scanner.next();
			try {
				godzinaOdjazdu = LocalTime.parse(input);
				poprawneDane = true;
			} catch (Exception e) {
				System.out.println("Nieprawidłowy format godziny. Spróbuj ponownie (HH:mm).");
			}
		}
		return godzinaOdjazdu;
	}

	public Rola podajSwojaRole() {
		System.out.println("Wybierz swoją rolę:");
		System.out.println("1 - Klient");
		System.out.println("2 - Kierowca");
		System.out.println("3 - Kontroler biletów");
		System.out.println("4 - Koordynator");

		while (true) {
			String wybor = scanner.next();
			switch (wybor) {
				case "1":
					return Rola.Klient;
				case "2":
					return Rola.Kierowca;
				case "3":
					return Rola.Kontroler_biletow;
				case "4":
					return Rola.Koordynator;
				default:
					System.out.println("Nieprawidłowy wybór. Wybierz ponownie (1-4): ");
			}
		}
	}

	@Override
	public int podajWyborMenu() {
		int wybor = -1;
		boolean poprawneDane = false;

		while (!poprawneDane) {
			System.out.print("Wybierz opcję z menu: ");
			if (scanner.hasNextInt()) {
				wybor = scanner.nextInt();
				if (wybor >= 1 && wybor <= 5) { // Zakładamy, że mamy 5 opcji w menu
					poprawneDane = true;
				} else {
					System.out.println("Opcja spoza zakresu. Wprowadź liczbę od 1 do 5.");
				}
			} else {
				System.out.println("Nieprawidłowy wybór. Wprowadź liczbę od 1 do 5.");
				scanner.next(); // Wyczyść nieprawidłowe dane
			}
		}
		return wybor;
	}

	@Override
	public int podajIle(String komunikat) {
		int liczba = 0;
		boolean poprawneDane = false;

		while (!poprawneDane) {
			System.out.print(komunikat);
			if (scanner.hasNextInt()) {
				liczba = scanner.nextInt();
				if (liczba > 0) { // Sprawdzamy, czy liczba jest dodatnia
					poprawneDane = true;
				} else {
					System.out.println("Liczba musi być większa niż 0. Spróbuj ponownie.");
				}
			} else {
				System.out.println("Nieprawidłowy format liczby. Spróbuj ponownie.");
				scanner.next();
			}
		}
		return liczba;
	}
}
