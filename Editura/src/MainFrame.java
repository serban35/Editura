import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class MainFrame {

	private JFrame frame;
	private JTextField txtSearch;
	private TextArea textArea = new TextArea();
	private String linie;
	private Carte carte;

	public MainFrame() {
		initialize();
	}

	public void populeazaLibrarie() {
		try {
			BufferedReader buf = new BufferedReader(
					new FileReader("C:\\Users\\serba\\eclipse-workspace\\Editura\\src\\carti.txt"));
			while (true) {
				linie = buf.readLine();
				if (linie == null) {
					break;
				} else {
					String tablou[] = linie.split("; ");

					carte = new Carte(tablou[0], tablou[1], tablou[2], tablou[3], tablou[4]);
					textArea.append(carte.toString());

				}
			}
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
		textArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

			}
		});

		textArea.setEditable(false);
		textArea.setFont(new Font("Arial Black", Font.BOLD, 14));
		populeazaLibrarie();

		panel.add(textArea, BorderLayout.CENTER);

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

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Nume Carte");
		panel_3.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Cod");
		panel_3.add(rdbtnNewRadioButton_2);

		ButtonGroup search = new ButtonGroup();
		search.add(rdbtnNewRadioButton);
		search.add(rdbtnNewRadioButton_1);
		search.add(rdbtnNewRadioButton_2);

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

		JButton btnNewButton_5 = new JButton("Detalii");
		panel_2.add(btnNewButton_5);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);

		JButton btnNewButton_2 = new JButton("Cos Cumparaturi");
		panel_6.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Finalizare Comanda");
		panel_6.add(btnNewButton_3);

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
