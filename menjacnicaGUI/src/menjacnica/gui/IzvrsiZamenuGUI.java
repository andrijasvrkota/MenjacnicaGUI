package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import javax.swing.event.ChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.InputMethodEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblKupovniKurs;
	private JLabel lblProdajniKurs;
	private JTextField jtfKupovni;
	private JTextField jtfProdajni;
	private static JComboBox jcbKursevi;
	private JLabel lblNewLabel;
	private JLabel lblVrstaTransakcije;
	private static JTextField jtfIznos;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;
	private JSlider slider;
	private static JRadioButton rdbtnKupovina;
	private static JRadioButton rdbtnProdaja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvrsiZamenuGUI frame = new IzvrsiZamenuGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				GUIKontroler.zatvoriZamenaProzor();
			}
		});
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getJtfKupovni());
		contentPane.add(getJtfProdajni());
		contentPane.add(getJcbKursevi());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblVrstaTransakcije());
		contentPane.add(getJtfIznos());
		contentPane.add(getBtnIzvrsiZamenu());
		contentPane.add(getBtnOdustani());
		contentPane.add(getSlider());
		contentPane.add(getRdbtnKupovina());
		contentPane.add(getRdbtnProdaja());
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblKupovniKurs.setBounds(10, 11, 102, 14);
		}
		return lblKupovniKurs;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblProdajniKurs.setBounds(285, 11, 102, 14);
		}
		return lblProdajniKurs;
	}
	private JTextField getJtfKupovni() {
		if (jtfKupovni == null) {
			jtfKupovni = new JTextField();
			jtfKupovni.setEditable(false);
			jtfKupovni.setBounds(10, 36, 102, 26);
			jtfKupovni.setColumns(10);
		}
		return jtfKupovni;
	}
	private JTextField getJtfProdajni() {
		if (jtfProdajni == null) {
			jtfProdajni = new JTextField();
			jtfProdajni.setEditable(false);
			jtfProdajni.setColumns(10);
			jtfProdajni.setBounds(285, 36, 102, 26);
		}
		return jtfProdajni;
	}
	public static JComboBox getJcbKursevi() {
		if (jcbKursevi == null) {
			jcbKursevi = new JComboBox();
			jcbKursevi.addItem("EUR");
			jcbKursevi.addItem("USD");
			jcbKursevi.addItem("CHF");
			jcbKursevi.setBounds(160, 36, 93, 26);
		}
		return jcbKursevi;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Iznos");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(10, 89, 46, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblVrstaTransakcije.setBounds(261, 89, 102, 14);
		}
		return lblVrstaTransakcije;
	}
	public static JTextField getJtfIznos() {
		if (jtfIznos == null) {
			jtfIznos = new JTextField();
			
			jtfIznos.setBounds(10, 120, 102, 26);
			jtfIznos.setColumns(10);
		}
		return jtfIznos;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi Zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.ubaciString();
					
				}
			});
			btnIzvrsiZamenu.setBounds(10, 229, 150, 32);
		}
		return btnIzvrsiZamenu;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(237, 229, 150, 32);
		}
		return btnOdustani;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					jtfIznos.setText(slider.getValue()+"");
				}
			});
			slider.setMajorTickSpacing(10);
			slider.setMinorTickSpacing(5);
			slider.setBounds(20, 162, 351, 56);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
		}
		return slider;
	}
	public static JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			rdbtnKupovina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(rdbtnProdaja.isSelected() == true)	rdbtnProdaja.setSelected(false);
					
						rdbtnKupovina.setSelected(true);
				}
			});
			rdbtnKupovina.setBounds(261, 110, 109, 23);
		}
		return rdbtnKupovina;
	}
	public JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			rdbtnProdaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnKupovina.isSelected() == true)	rdbtnKupovina.setSelected(false);
					
					rdbtnProdaja.setSelected(true);
				}
			});
			rdbtnProdaja.setBounds(261, 136, 109, 23);
		}
		return rdbtnProdaja;
	}
}
