import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class Cos extends JDialog {
	private static final long serialVersionUID = 1L;

	public String print(ArrayList<Carte> lista) {
		String cap = "SC EdituraSerban SRL						\r\n" + "nr ord reg com:RO 1111\r\n"
				+ "Adresa: str Soarelui nr 8,Constanta\r\n" + "Telefon: 071 111 222\r\n"
				+ "Email:office@edituraserban.ro\r\n" + "\r\n"
				+ "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\r\n"
				+ "\r\n" + "\r\n" + "Factura nr: 							Cumparator:\r\n"
				+ "Data Facturare: azi 							Detalii:\r\n" + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "";
		for (Carte c : lista) {
			cap += c.toString();
		}
		cap += "\r\n" + "\r\n" + "Date privind expediția\r\n" + "Numele delegatului: ..............................\r\n"
				+ "Act de identitate(BI/CI): .........................\r\n"
				+ "Serie: ............ număr: ......................... emis de: ..............................\r\n"
				+ "Mijlocul de transport: VW Crafter\r\n" + "nr.: SB-15-FCT\r\n"
				+ "Expediția s-a efectuat în prezența noastră la data de: ..............................\r\n"
				+ "ora: ..............................\r\n" + "\r\n" + "\r\n" + "Semnaturile:\r\n"
				+ "									Semnatura de primire:\r\n" + "\r\n" + "\r\n" + "\r\n" + "\r\n"
				+ "\r\n" + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "Speram intr-o colaborare fructoasa si pe viitor.\r\n"
				+ "Cu stima maxima si virtute absoluta, Ion Pop S.C. EdituraSerban S.R.L.\r\n" + "";
		return cap;
	}

	public Cos(CosCumparaturi cos, Client client) {
		ArrayList<Carte> lista = cos.getLista();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(34, 34, 51));
		setType(Type.UTILITY);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		TextArea textArea = new TextArea();
		textArea.setBounds(0, 0, 434, 177);
		textArea.setForeground(new Color(255, 255, 255));
		getContentPane().add(textArea);
		textArea.setEditable(false);
		textArea.setBackground(new Color(34, 34, 51));
		textArea.setColumns(10);

		JTextPane txtpnTotalPret = new JTextPane();
		txtpnTotalPret.setEnabled(false);
		txtpnTotalPret.setBounds(0, 177, 434, 41);
		getContentPane().add(txtpnTotalPret);
		txtpnTotalPret.setForeground(new Color(170, 204, 255));
		txtpnTotalPret.setBackground(new Color(34, 34, 51));
		txtpnTotalPret.setEditable(false);
		txtpnTotalPret.setText(cos.getPretTotal());

		JButton btnNewButton = new JButton("Cumpara");
		btnNewButton.setBounds(281, 219, 108, 31);
		btnNewButton.setBackground(new Color(255, 255, 100));
		getContentPane().add(btnNewButton);
		String inceput;
		String sfarsit;
		for (Carte c : lista) {
			textArea.append(c.toString());
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, print(lista), "Factura", JOptionPane.INFORMATION_MESSAGE);

			}

		});
		setVisible(true);
	}

}
