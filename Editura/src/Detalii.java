import java.awt.BorderLayout;
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
		panel_1.add(textArea);
		textArea.setFont(new Font("Georgia", Font.BOLD, 25));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setRows(15);
		textArea.setColumns(15);
		textArea.append("Titlu:" + carte.getTitlu() + "\nAutor: " + carte.getNumeAutor() + "\nNr pagini: "
				+ carte.getNrPag() + "\nPret: " + carte.getPret());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
