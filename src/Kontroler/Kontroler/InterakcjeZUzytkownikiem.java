	package Kontroler.Kontroler;

	import Model.Model.Rola;

	import java.time.LocalTime;

	public interface InterakcjeZUzytkownikiem {

	int podajNrBiletu();

	boolean zatwierdzZgodnoscOsoby();

	int podajNrLinii();

	String podajNrRejestracyjny();

	String podajNazwePrzystanku();

	LocalTime podajGodzineOdjazdu();

	Rola podajSwojaRole();

	int podajWyborMenu();

	int podajIle(String komunikat);
}