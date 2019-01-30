import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Detalii extends JDialog {

	private static final long serialVersionUID = 1L;

	public Detalii(Carte carte) {
		setBounds(400, 400, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 5, 5));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(carte.getPicPath()));

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1);
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(170, 204, 255));
		textArea.setBackground(new Color(34, 34, 51));
		panel_1.add(textArea);
		panel_1.setBackground(new Color(220, 220, 220));
		textArea.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setRows(7);
		textArea.setColumns(20);
		textArea.append(
				"Titlu: " + carte.getTitlu() + "\nAutor: " + carte.getNumeAutor() + "\nNr pagini: " + carte.getNrPag()
						+ "\nPret: " + carte.getPret() + " Lei" + "\nPerioada Livrare:\n" + carte.getPerLiv());

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Script MT Bold", Font.PLAIN, 15));
		textArea_1.setForeground(new Color(0, 0, 0));
		textArea_1.setBackground(new Color(255, 255, 255));
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setRows(16);
		textArea_1.setColumns(34);
		textArea_1.setEditable(false);
		try {
			BufferedReader buf = new BufferedReader(new FileReader("txt\\" + carte.getTitlu() + ".txt"));
			while (true) {
				String linie = buf.readLine();
				if (linie == null) {
					break;
				} else {
					String tablou[] = linie.split("\n");
					for (String s : tablou)
						textArea_1.append(s + "\n");

				}
			}

			buf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel_1 = new JLabel("Recenzii");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel_1.add(lblNewLabel_1);

		panel_1.add(textArea_1);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
