package menjacnica.gui.modeli;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import menjacnica.logika.Kurs;

public class TableModelGUI extends AbstractTableModel {

	private final String[] kolone = new String[]{"Sifra" , "Skraceni naziv" , "Prodajni" , "Srednji" , "Kupovni" , "Naziv"};
	private LinkedList<Kurs> kursevi;
	
	public TableModelGUI(LinkedList<Kurs> kursevi) {
		if (kursevi == null) {
			this.kursevi = new LinkedList<>();
		} else {
			this.kursevi = kursevi;
		}
	}
	
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return kursevi.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Kurs k = kursevi.get(rowIndex);
		switch(columnIndex){
		case 0:
				return k.getSifra();
		case 1:
				return k.getSkraceniNaziv();
		case 2:
				return k.getProdajniKurs();
		case 3:
				return k.getSrednjiKurs();
		case 4:
				return k.getKupovniKurs();
		case 5:
				return k.getNaziv();
		default:
			return "";
		}
	
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public void ucitajKurseve(LinkedList<Kurs> kursevi) {
		this.kursevi = kursevi;
		fireTableDataChanged();
	}
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	public Kurs getKurs(int indeks){
		return kursevi.get(indeks);
	}
}
