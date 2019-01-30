import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainFrame {

	private JFrame frame;
	private JTextField txtSearch = new JTextField();
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> list = new JList<>(model);
	private Carte carte;
	private CosCumparaturi cos = new CosCumparaturi();
	private ArrayList<String> nume = new ArrayList<String>();
	final private ArrayList<Carte> carti = new ArrayList<Carte>();
	private int nr;

	public void setNR() {

		list.getSelectionModel().addListSelectionListener(f -> {
			nr = list.getSelectedIndex();
		});
	}

	public void setColor(JPanel panel) {
		panel.setBackground(new Color(34, 34, 51));
		panel.setForeground(new Color(170, 204, 255));
	}

	public void setColor(JButton buton) {
		buton.setBackground(new Color(255, 255, 100));
	}

	public void adaugaPanou() {
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setBackground(new Color(34, 34, 51));
		panel.setForeground(new Color(170, 204, 255));
	}

	public void adaugaPanou(LayoutManager layout) {
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(layout);
		panel.setBackground(new Color(34, 34, 51));
		panel.setForeground(new Color(170, 204, 255));

	}

	public void cauta(String cuvant) {
		for (Carte c : carti) {
			if (c.toString().toLowerCase().contains(cuvant)) {
				model.addElement(c.toString());
			}
		}
	}

	public Carte selected(int nr) {
		// System.out.println(nr);
		for (Carte tmp : carti) {
			if (carti.indexOf(tmp) == nr) {
				return tmp;
			}
		}
		return null;
	}

	public void populeazaLibrarie() {

		try {
			BufferedReader buf = new BufferedReader(new FileReader("txt\\carti.txt"));
			while (true) {
				String linie = buf.readLine();
				if (linie == null) {
					break;
				} else {
					String tablou[] = linie.split("; ");
					carte = new Carte(tablou[0], tablou[1], tablou[2], tablou[3], tablou[4], tablou[5]);
					carti.add(carte);
					model.addElement(carte.toString());
					nume.add(carte.toString());

				}
			}

			buf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initialize(Client client) {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 2));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		list.setModel(model);
		scrollPane.setViewportView(list);

		list.setForeground(new Color(170, 204, 255));
		list.setBackground(new Color(34, 34, 51));

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);

		panel_1.setLayout(new GridLayout(6, 1, 0, 0));

		JPanel panel_3 = new JPanel();

		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignOnBaseline(true);
		panel_1.add(panel_3);

		txtSearch = new JTextField();

		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setText("Cautare");
		panel_3.add(txtSearch);
		txtSearch.setColumns(35);

		setNR();

		populeazaLibrarie();

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nume Autor");
		panel_3.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Titlu Carte");
		panel_3.add(rdbtnNewRadioButton_1);

		ButtonGroup search = new ButtonGroup();
		search.add(rdbtnNewRadioButton);
		search.add(rdbtnNewRadioButton_1);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignOnBaseline(true);
		panel_1.add(panel_4);

		JButton btnNewButton = new JButton("Cauta");
		btnNewButton.setBackground(new Color(255, 255, 100));
		panel_4.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeAllElements();
				cauta(txtSearch.getText());
			}

		});

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JButton btnNewButton_1 = new JButton("Adauga Cos");
		setColor(btnNewButton_1);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cos.adaugaCarte(selected(nr));
				cos.detaliiCos();
			}

		});

		JButton btnNewButton_5 = new JButton("Detalii Carte");
		setColor(btnNewButton_5);
		panel_2.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Detalii(selected(nr));

				} catch (Exception f) {
					f.printStackTrace();
				}

			}

		});

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);

		JButton btnNewButton_3 = new JButton("Finalizare Comanda");
		setColor(btnNewButton_3);
		panel_6.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					new Cos(cos, client);

				} catch (Exception f) {
					f.printStackTrace();
				}
			}

		});

		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		TextArea textArea_1 = new TextArea();
		textArea_1.setText("Recenzii");
		panel_7.add(textArea_1, BorderLayout.CENTER);

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setColor(panel_1);
		setColor(panel_2);
		setColor(panel_3);
		setColor(panel_4);
		setColor(panel_5);
		panel_7.setBackground(new Color(34, 34, 51));
		setColor(panel_6);
		JButton btnNewButton_4 = new JButton("Adauga Recenzie");
		setColor(btnNewButton_4);
		panel_5.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected(nr).setRecenzii(textArea_1.getText());
				// System.out.println(textArea_1.getText());
				selected(nr).salveazaRecenzii(selected(nr));
			}

		});
		frame.setVisible(true);
	}

	public MainFrame(Client client) {
		initialize(client);

	}

}
