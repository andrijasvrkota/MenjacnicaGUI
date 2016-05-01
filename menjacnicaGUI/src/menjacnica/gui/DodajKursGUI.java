package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.logika.Kurs;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSifra;
	private JLabel lblProdajniKurs;
	private JLabel lblSrednjiKurs;
	private JLabel lblNaziv;
	private JLabel lblKupovniKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField jtfSifra;
	private JTextField jtfNaziv;
	private JTextField jtfKupovniKurs;
	private JTextField jtfProdajniKurs;
	private JTextField jtfSrednjiKurs;
	private JTextField jtfSkraceniNaziv;
	private JButton btnDodaj;
	private JButton btnOdustani;
	public static LinkedList<Kurs> kursevi = new LinkedList<>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DodajKursGUI frame = new DodajKursGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DodajKursGUI() {
		setResizable(false);
		setTitle("Dodaj Kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblSifra());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getLblSrednjiKurs());
		contentPane.add(getLblNaziv());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getLblSkraceniNaziv());
		contentPane.add(getJtfSifra());
		contentPane.add(getJtfNaziv());
		contentPane.add(getJtfKupovniKurs());
		contentPane.add(getJtfProdajniKurs());
		contentPane.add(getJtfSrednjiKurs());
		contentPane.add(getJtfSkraceniNaziv());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
			lblSifra.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSifra.setBounds(10, 21, 46, 14);
		}
		return lblSifra;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblProdajniKurs.setBounds(10, 77, 96, 14);
		}
		return lblProdajniKurs;
	}
	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
			lblSrednjiKurs.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSrednjiKurs.setBounds(10, 138, 96, 14);
		}
		return lblSrednjiKurs;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNaziv.setBounds(188, 21, 46, 14);
		}
		return lblNaziv;
	}
	public JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblKupovniKurs.setBounds(188, 77, 96, 14);
		}
		return lblKupovniKurs;
	}
	public JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
			lblSkraceniNaziv.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSkraceniNaziv.setBounds(188, 138, 96, 14);
		}
		return lblSkraceniNaziv;
	}
	public JTextField getJtfSifra() {
		if (jtfSifra == null) {
			jtfSifra = new JTextField();
			jtfSifra.setBounds(10, 46, 145, 20);
			jtfSifra.setColumns(10);
		}
		return jtfSifra;
	}
	public JTextField getJtfNaziv() {
		if (jtfNaziv == null) {
			jtfNaziv = new JTextField();
			jtfNaziv.setColumns(10);
			jtfNaziv.setBounds(188, 46, 145, 20);
		}
		return jtfNaziv;
	}
	public JTextField getJtfKupovniKurs() {
		if (jtfKupovniKurs == null) {
			jtfKupovniKurs = new JTextField();
			jtfKupovniKurs.setColumns(10);
			jtfKupovniKurs.setBounds(188, 102, 145, 20);
		}
		return jtfKupovniKurs;
	}
	public JTextField getJtfProdajniKurs() {
		if (jtfProdajniKurs == null) {
			jtfProdajniKurs = new JTextField();
			jtfProdajniKurs.setColumns(10);
			jtfProdajniKurs.setBounds(10, 102, 145, 20);
		}
		return jtfProdajniKurs;
	}
	public JTextField getJtfSrednjiKurs() {
		if (jtfSrednjiKurs == null) {
			jtfSrednjiKurs = new JTextField();
			jtfSrednjiKurs.setColumns(10);
			jtfSrednjiKurs.setBounds(10, 163, 145, 20);
		}
		return jtfSrednjiKurs;
	}
	public JTextField getJtfSkraceniNaziv() {
		if (jtfSkraceniNaziv == null) {
			jtfSkraceniNaziv = new JTextField();
			jtfSkraceniNaziv.setColumns(10);
			jtfSkraceniNaziv.setBounds(188, 163, 145, 20);
		}
		return jtfSkraceniNaziv;
	}
	public JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.unosKursa();
					
				}
			});
			btnDodaj.setBounds(10, 206, 145, 31);
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(188, 206, 145, 31);
		}
		return btnOdustani;
	}
	
	public static LinkedList<Kurs> getKursevi(){
		return kursevi;
	}
}
