package menjacnica.logika;

public class Kurs {
	private String sifra;
	private String skraceniNaziv;
	private String prodajniKurs;
	private String srednjiKurs;
	private String kupovniKurs;
	private String naziv;

	public Kurs(String sifra, String naziv, double prodajniKurs, double kupovniKurs,
			double srednjiKurs, String skraceniNaziv) {
		this.sifra = sifra;
		this.skraceniNaziv = skraceniNaziv;
		this.prodajniKurs = prodajniKurs + "";
		this.srednjiKurs = srednjiKurs + "";
		this.kupovniKurs = kupovniKurs + "";
		this.naziv = naziv;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	public String getProdajniKurs() {
		return prodajniKurs;
	}

	public void setProdajniKurs(String prodajniKurs) {
		this.prodajniKurs = prodajniKurs;
	}

	public String getSrednjiKurs() {
		return srednjiKurs;
	}

	public void setSrednjiKurs(String srednjiKurs) {
		this.srednjiKurs = srednjiKurs;
	}

	public String getKupovniKurs() {
		return kupovniKurs;
	}

	public void setKupovniKurs(String kupovniKurs) {
		this.kupovniKurs = kupovniKurs;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}
