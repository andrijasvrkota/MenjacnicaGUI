package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import menjacnica.gui.modeli.TableModelGUI;
import menjacnica.logika.Kurs;

import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel eastPanel;
	private JPanel southPanel;
	private JPanel panel;
	private JButton btnDodajKurs;
	private JButton btnIzbrisiKurs;
	private JButton btnIzvrsiZamenu;
	private JTextArea jtaStatus;
	private JScrollPane scrollPane;
	private JTable tableMenjacnica;
	private JScrollPane scrollPane_1;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmIzbrisiKurs;
	private JMenuItem mntmIzvrsiZamenu;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JPopupMenu popupMenu;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MenjacnicaGUI frame = new MenjacnicaGUI();
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
	public MenjacnicaGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				GUIKontroler.zatvoriGlavniProzor();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/resources/paree.png")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 386);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getEastPanel(), BorderLayout.EAST);
		contentPane.add(getSouthPanel(), BorderLayout.SOUTH);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getEastPanel() {
		if (eastPanel == null) {
			eastPanel = new JPanel();
			eastPanel.setPreferredSize(new Dimension(110, 10));
			eastPanel.add(getBtnDodajKurs());
			eastPanel.add(getBtnIzbrisiKurs());
			eastPanel.add(getBtnIzvrsiZamenu());
		}
		return eastPanel;
	}
	private JPanel getSouthPanel() {
		if (southPanel == null) {
			southPanel = new JPanel();
			southPanel.setPreferredSize(new Dimension(10, 100));
			southPanel.setLayout(new BorderLayout(0, 0));
			southPanel.add(getScrollPane());
		}
		return southPanel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getScrollPane_1());
		}
		return panel;
	}
	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj Kurs");
			btnDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziDodajKursProzor();
				}
			});
			btnDodajKurs.setPreferredSize(new Dimension(100, 23));
		}
		return btnDodajKurs;
	}
	private JButton getBtnIzbrisiKurs() {
		if (btnIzbrisiKurs == null) {
			btnIzbrisiKurs = new JButton("Izbrisi Kurs");
			btnIzbrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int indeks = tableMenjacnica.getSelectedRow();
					if(indeks == -1){
						JOptionPane.showMessageDialog(null, "Izaberite red koji zelite da izbrisete");
					}else{
						int opcija = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da izbrisete " 
					+(tableMenjacnica.getSelectedRow()+1) + ". red?");
						if(opcija == JOptionPane.YES_OPTION){
							TableModelGUI tm  = (TableModelGUI) tableMenjacnica.getModel();
							Kurs k = tm.getKurs(indeks);
							GUIKontroler.izbrisiKurs(k,indeks);
						}
					}
				}
			});
			btnIzbrisiKurs.setPreferredSize(new Dimension(100, 23));
		}
		return btnIzbrisiKurs;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi Zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzvrsiZamenuGUI zamenaProzor = new IzvrsiZamenuGUI();
					zamenaProzor.setVisible(true);
					zamenaProzor.setLocationRelativeTo(null);
				}
			});
			btnIzvrsiZamenu.setPreferredSize(new Dimension(100, 23));
		}
		return btnIzvrsiZamenu;
	}
	public JTextArea getJtaStatus() {
		if (jtaStatus == null) {
			jtaStatus = new JTextArea();
			jtaStatus.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		return jtaStatus;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getJtaStatus());
		}
		return scrollPane;
	}
	private JTable getTableMenjacnica() {
		if (tableMenjacnica == null) {
			tableMenjacnica = new JTable();
			tableMenjacnica.setModel(GUIKontroler.postaviModelZaTabelu());
//			tableMenjacnica.setFillsViewportHeight(true);
		}
		return tableMenjacnica;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			addPopup(scrollPane_1, getPopupMenu_1());
			scrollPane_1.setViewportView(getTableMenjacnica());
		}
		return scrollPane_1;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("File");
			mnNewMenu.add(getMntmOpen());
			mnNewMenu.addSeparator();
			mnNewMenu.add(getMntmSave());
			mnNewMenu.addSeparator();
			mnNewMenu.add(getMntmExit());
		}
		return mnNewMenu;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("Help");
			mnNewMenu_1.add(getMntmAbout());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.ucitavanjeFajla();
				}
			});
			mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.sacuvavanjeFajla();
				}
			});
			mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvoriGlavniProzor();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(getContentPane(), "Autor: Andrija Svrkota");
				}
			});
		}
		return mntmAbout;
	}
//	public void osveziTabelu(){
//		TableModelGUI tm = (TableModelGUI) getTableMenjacnica().getModel();
//		tm.staviSveKnjigeUModel(DodajKursGUI.getKursevi());
//	}
	public void osveziTabelu() {
		TableModelGUI model = (TableModelGUI) tableMenjacnica.getModel();
		model.ucitajKurseve(GUIKontroler.vratiSveKurseve());
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JPopupMenu getPopupMenu_1() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmIzbrisiKurs());
			popupMenu.add(getMntmIzvrsiZamenu());
		}
		return popupMenu;
	}
	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziDodajKursProzor();
				}
			});
		}
		return mntmDodajKurs;
	}
	private JMenuItem getMntmIzbrisiKurs() {
		if (mntmIzbrisiKurs == null) {
			mntmIzbrisiKurs = new JMenuItem("Izbrisi kurs");
			mntmIzbrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = tableMenjacnica.getSelectedRow();
					if(index == -1){
						JOptionPane.showMessageDialog(null, "Izaberite red za brisanje",
								"Greska prilikom brisanja", JOptionPane.WARNING_MESSAGE);
					}else{
						int opcija = JOptionPane.showConfirmDialog(getContentPane(), "Da li ste sigurni da zelite da obrisete selektovani red?"
							, "Upozorenje za brisanje", JOptionPane.YES_NO_CANCEL_OPTION);
						if(opcija == JOptionPane.YES_OPTION){
						TableModelGUI model = (TableModelGUI) tableMenjacnica.getModel();
						Kurs k = model.getKurs(index);
						GUIKontroler.izbrisiKurs(k, index); 
						}
					}
				}
			});
		}
		return mntmIzbrisiKurs;
	}
	private JMenuItem getMntmIzvrsiZamenu() {
		if (mntmIzvrsiZamenu == null) {
			mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
			mntmIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziZamenuProzor();
				}
			});
		}
		return mntmIzvrsiZamenu;
	}
}
