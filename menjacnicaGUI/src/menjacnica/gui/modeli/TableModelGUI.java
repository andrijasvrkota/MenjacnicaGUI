package menjacnica.gui.modeli;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import menjacnica.logika.Kurs;

public class TableModelGUI extends AbstractTableModel {

	private final String[] kolone = new String[] { "Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"};
	LinkedList<Kurs> kursevi;
	
	public TableModelGUI(LinkedList<Kurs> kursevi) {
		this.kursevi = kursevi;
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

}
