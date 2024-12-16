package Model.Model;
public class Osoba {

	private String Imie = "";
	private String Nazwisko = "";
	private int Pesel;
	private String NrDokumentu = "";
	private Rola Rola = Model.Model.Rola.Klient;

	public Osoba(String imie, String nazwisko, int pesel, String nrDokumentu, Rola rola) {
		this.Imie = imie;
		this.Nazwisko = nazwisko;
		this.Pesel = pesel;
		this.NrDokumentu = nrDokumentu;
		this.Rola = rola;
	}

	public String getImie() {
		return Imie;
	}

	public void setImie(String imie) {
		this.Imie = imie;
	}

	public String getNazwisko() {
		return Nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.Nazwisko = nazwisko;
	}

	public int getPesel() {
		return Pesel;
	}

	public void setPesel(int pesel) {
		this.Pesel = pesel;
	}

	public String getNrDokumentu() {
		return NrDokumentu;
	}

	public void setNrDokumentu(String nrDokumentu) {
		this.NrDokumentu = nrDokumentu;
	}

	public Rola getRola() {
		return Rola;
	}

	public void setRola(Rola rola) {
		this.Rola = rola;
	}
}
