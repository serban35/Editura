import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateUser extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JTextField txtNume;
	private JTextField txtPrenume;
	private JTextField txtAdresaLivrare;
	private JTextField txtEmail;
	private JTextField txtNrTelefon;
	private JTextField txtPassword;
	private String nume, prenume, pass, adrLiv, nrTel, email, user;
	private Client client;

	public void createElement(JTextField textField, String text) {
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.LEADING, 5, 5);
		panel.setLayout(fl_panel);
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(20);
		textField.selectAll();
		textField.setText(text);
		// return textField.getText();
	}

	public void getNames() {
		this.nume = txtNume.getText();

	}

	public void creazaClient() {
		client = new Client(nume, prenume, adrLiv, email, user, pass, nrTel);
		System.out.println(client.toString());
		client.setCod(client.hashCode());
		client.salveazaListaClienti(client);

	}

	public CreateUser() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 400, 400);
		getContentPane().setLayout(new GridLayout(8, 1, 0, 0));

		createElement(txtUsername, "username");
		createElement(txtPassword, "parola");
		createElement(txtNume, "nume");
		// this.nume = txtNume.getText();
		createElement(txtPrenume, "prenume");
		createElement(txtAdresaLivrare, "adresa livrare");
		createElement(txtEmail, "email");
		createElement(txtNrTelefon, "nr telefon");

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton = new JButton("Create User");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// creaza user cu delatiile aferente si ma trimite in panoul principal
				getNames();
				creazaClient();
				setVisible(false);
				try {
					new MainFrame();

				} catch (Exception f) {
					f.printStackTrace();
				}

			}

		});

		{
			JButton btnNewButton_1 = new JButton("Back");
			panel.add(btnNewButton_1);

			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ma trimite la creere user nou
					setVisible(false);
					try {
						new LogIn();

					} catch (Exception f) {
						f.printStackTrace();
					}

				}

			});

		}
		setVisible(true);
	}

}
