package menjacnica.gui;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import menjacnica.gui.modeli.TableModelGUI;
import menjacnica.logika.Kurs;

public class GUIKontroler {
	private static MenjacnicaGUI glavniProzor;
	private static DodajKursGUI dodajKursProzor;
	private static LinkedList<Kurs> kursevi;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new MenjacnicaGUI();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
					dodajKursProzor = new DodajKursGUI();
					kursevi = new LinkedList<Kurs>();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void zatvoriGlavniProzor() {
		int izbor = JOptionPane.showConfirmDialog(null, "Da li zelite da izadjete iz programa?");
		if(izbor == JOptionPane.YES_OPTION){
			glavniProzor.dispose();
		}
	}
	
	public static void ucitavanjeFajla(){
		JFileChooser fc = new JFileChooser();
		int povratnaVrednost = fc.showOpenDialog(null);
		if(povratnaVrednost == JFileChooser.APPROVE_OPTION){
			if(glavniProzor.getJtaStatus().getText().isEmpty())
				glavniProzor.getJtaStatus().setText("Ucitan fajl: " + fc.getSelectedFile().getAbsolutePath());
			else
				glavniProzor.getJtaStatus().setText(glavniProzor.getJtaStatus().getText() +'\n' + "Ucitan fajl: " + fc.getSelectedFile().getAbsolutePath());
		}
	}
	public static void sacuvavanjeFajla() {
		JFileChooser fc = new JFileChooser();
		int povratnaVrednost = fc.showSaveDialog(null);
		if(povratnaVrednost == JFileChooser.APPROVE_OPTION){
			if(glavniProzor.getJtaStatus().getText().isEmpty()) 
				glavniProzor.getJtaStatus().setText("Sacuvan fajl: " + fc.getSelectedFile().getAbsolutePath());
			else
				glavniProzor.getJtaStatus().setText(glavniProzor.getJtaStatus().getText() +'\n' + "Sacuvan fajl: " + fc.getSelectedFile().getAbsolutePath());
		}
	}
	public static void prikaziDodajKursProzor(){
		dodajKursProzor.setVisible(true);
		dodajKursProzor.setLocationRelativeTo(null);
	}
	public static void unosKursa() {
		Kurs k = new Kurs();
		String sifra = dodajKursProzor.getJtfSifra().getText();
		String naziv = dodajKursProzor.getJtfNaziv().getText();
		String prodajniKurs  = dodajKursProzor.getJtfProdajniKurs().getText();
		String kupovniKurs = dodajKursProzor.getJtfKupovniKurs().getText();
		String srednjiKurs = dodajKursProzor.getJtfSrednjiKurs().getText();
		String skraceniNaziv = dodajKursProzor.getJtfSkraceniNaziv().getText();
		k.setKupovniKurs(Integer.parseInt(kupovniKurs));
		k.setNaziv(naziv);
		k.setProdajniKurs(Integer.parseInt(prodajniKurs));
		k.setSrednjiKurs(Integer.parseInt(srednjiKurs));
		k.setSkraceniNaziv(skraceniNaziv);
		k.setSifra(sifra);
		kursevi.add(k);
		String spojeno = "Sifra: " +sifra + " Naziv: " +naziv + " Prodajni kurs: " +prodajniKurs
				+ " Kupovni kurs: " +kupovniKurs + " Srednji kurs: " +srednjiKurs + " Skraceni naziv: " +skraceniNaziv;
		if(glavniProzor.getJtaStatus().getText().equals(""))
			glavniProzor.getJtaStatus().setText(spojeno);
		else
			glavniProzor.getJtaStatus().setText(glavniProzor.getJtaStatus().getText()+'\n'+spojeno);
		
		glavniProzor.osveziTabelu();
	}
	public static TableModel postaviModelZaTabelu() {
		TableModelGUI model = new TableModelGUI(kursevi);
		return model;
	}
	public static LinkedList<Kurs> vratiSveKurseve() {
		return kursevi;
	}

	public static void izbrisiKurs(Kurs k, int index) {
		try {
			kursevi.remove(k);
			glavniProzor.osveziTabelu();
			if(glavniProzor.getJtaStatus().getText().isEmpty())
				glavniProzor.getJtaStatus().setText("Izbrisan je red sa indeksom: " + (index+1));
			else
				glavniProzor.getJtaStatus().setText(glavniProzor.getJtaStatus().getText() +'\n'
						+ "Izbrisan je red sa indeksom: " + (index+1));

			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Uspesno ste izbrisali kurs.",
					"Uspesno brisanje", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Doslo je do greske",
					"Greska prilikom brisanja", JOptionPane.ERROR_MESSAGE);
		}
	}
}
