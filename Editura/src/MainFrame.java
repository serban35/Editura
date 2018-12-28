import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class MainFrame {

	private JFrame frame;
	private JTextField txtSearch;
	private DefaultListModel<Carte> model = new DefaultListModel<>();
	private JList<Carte> list = new JList<>();
	private Carte carte;
	private CosCumparaturi cos = new CosCumparaturi();

	public MainFrame() {
		initialize();
	}

	public void populeazaLibrarie() {

		try {
			BufferedReader buf = new BufferedReader(
					new FileReader("C:\\Users\\serba\\git\\repository\\Editura\\Editura\\src\\carti.txt"));
			while (true) {
				String linie = buf.readLine();
				if (linie == null) {
					break;
				} else {
					String tablou[] = linie.split("; ");
					carte = new Carte(tablou[0], tablou[1], tablou[2], tablou[3], tablou[4]);
					model.addElement(carte);

				}
			}
			buf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 2));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.getSelectionModel().addListSelectionListener(e -> {
			carte = list.getSelectedValue();
		});

		list.setModel(model);
		scrollPane.setViewportView(list);

		populeazaLibrarie();

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

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nume Autor");
		panel_3.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Titlu Carte");
		panel_3.add(rdbtnNewRadioButton_1);

		ButtonGroup search = new ButtonGroup();
		search.add(rdbtnNewRadioButton);
		search.add(rdbtnNewRadioButton_1);

		Border searchBorder = BorderFactory.createTitledBorder("Criterii Cautare");
		panel_3.setBorder(searchBorder);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignOnBaseline(true);
		panel_1.add(panel_4);

		JButton btnNewButton = new JButton("Cauta");
		panel_4.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JButton btnNewButton_1 = new JButton("Adauga Cos");
		panel_2.add(btnNewButton_1);

		JButton btnNewButton_5 = new JButton("Detalii Carte");
		panel_2.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					new Detalii(carte, cos);

				} catch (Exception f) {
					f.printStackTrace();
				}

			}

		});

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);

		JButton btnNewButton_3 = new JButton("Finalizare Comanda");
		panel_6.add(btnNewButton_3);

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					new Cos(cos);

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

		JButton btnNewButton_4 = new JButton("Adauga Recenzie");
		panel_5.add(btnNewButton_4);
		frame.setVisible(true);
	}

}
