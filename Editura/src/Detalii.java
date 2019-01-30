import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Detalii extends JDialog {

	private static final long serialVersionUID = 1L;

	public Detalii(Carte carte) {
		setBounds(400, 400, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 5, 5));

		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(carte.getPicPath()));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(170, 204, 255));
		textArea.setBackground(new Color(34, 34, 51));
		panel_1.add(textArea);
		panel_1.setBackground(new Color(34, 34, 51));
		textArea.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setRows(8);
		textArea.setColumns(20);
		textArea.append("Titlu: " + carte.getTitlu() + "\nAutor: " + carte.getNumeAutor() + "\nNr pagini: "
				+ carte.getNrPag() + "\nPret: " + carte.getPret() + " Lei");

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Script MT Bold", Font.PLAIN, 13));
		textArea_1.setForeground(new Color(170, 204, 255));
		textArea_1.setBackground(new Color(34, 34, 51));
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setRows(17);
		textArea_1.setColumns(40);
		textArea_1.setEditable(false);
		panel_1.add(textArea_1);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
