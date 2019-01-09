import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateUser extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsername = new JTextField();
	private JTextField txtNume = new JTextField();
	private JTextField txtPrenume = new JTextField();
	private JTextField txtAdresaLivrare = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtNrTelefon = new JTextField();
	private JTextField txtPassword = new JTextField();
	private String nume, prenume, pass, adrLiv, nrTel, email, user;
	private Client client;

	public void createElement(JTextField textField, String text) {
		JPanel panel = new JPanel();
		add(panel);

		panel.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));

		JLabel lblNewLabel = new JLabel(text);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		textField.setToolTipText(text);
		panel.add(textField);
		textField.setColumns(20);
		textField.selectAll();
	}

	public void creazaClient() {
		this.nume = txtNume.getText();
		this.prenume = txtPrenume.getText();
		this.adrLiv = txtAdresaLivrare.getText();
		this.email = txtEmail.getText();
		this.user = txtUsername.getText();
		this.pass = txtPassword.getText();
		this.nrTel = txtNrTelefon.getText();
		this.client = new Client(nume, prenume, adrLiv, email, user, pass, nrTel);
		client.salveazaListaClienti(client);

	}

	public CreateUser() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 400, 400);
		setLayout(new GridLayout(8, 1, 0, 0));

		createElement(txtUsername, "username");
		createElement(txtPassword, "parola");
		createElement(txtNume, "nume");
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

				creazaClient();
				setVisible(false);
				try {
					new MainFrame(client);

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
