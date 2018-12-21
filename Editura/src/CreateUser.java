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
	private String nume, prenume, pass, adrLiv, nrTel, user, email;
	private ListaClienti lista = new ListaClienti();
	private Client client;

	public CreateUser() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 400, 400);
		getContentPane().setLayout(new GridLayout(8, 1, 0, 0));
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			FlowLayout fl_panel = new FlowLayout(FlowLayout.LEADING, 5, 5);
			panel.setLayout(fl_panel);
			{
				txtUsername = new JTextField();
				txtUsername.setText("Username");
				panel.add(txtUsername);
				txtUsername.setColumns(20);
				txtUsername.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						user = txtUsername.getText();
					}
				});
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout fl_panel = (FlowLayout) panel.getLayout();
			fl_panel.setAlignment(FlowLayout.LEADING);
			getContentPane().add(panel);
			{
				txtPassword = new JTextField();
				txtPassword.setText("Password");
				panel.add(txtPassword);
				txtPassword.setColumns(20);
				txtPassword.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pass = txtPassword.getText();
					}
				});
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
			{
				txtNume = new JTextField();
				txtNume.setText("Nume");
				panel.add(txtNume);
				txtNume.setColumns(20);
				txtNume.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nume = txtNume.getText();
					}
				});
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
			{
				txtPrenume = new JTextField();
				txtPrenume.setText("Prenume");
				panel.add(txtPrenume);
				txtPrenume.setColumns(20);
				txtPrenume.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						prenume = txtPrenume.getText();
					}
				});
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
			{
				txtAdresaLivrare = new JTextField();
				txtAdresaLivrare.setText("Adresa Livrare");
				panel.add(txtAdresaLivrare);
				txtAdresaLivrare.setColumns(20);
				txtAdresaLivrare.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						adrLiv = txtAdresaLivrare.getText();
					}
				});
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
			{
				txtEmail = new JTextField();
				txtEmail.setText("E-Mail");
				panel.add(txtEmail);
				txtEmail.setColumns(20);
				txtEmail.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						email = txtEmail.getText();
					}
				});
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
			{
				txtNrTelefon = new JTextField();
				txtNrTelefon.setText("Nr Telefon");
				panel.add(txtNrTelefon);
				txtNrTelefon.setColumns(20);
				txtNrTelefon.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nrTel = txtNrTelefon.getText();
					}
				});
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton btnNewButton = new JButton("Create User");
				panel.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// creaza user cu delatiile aferente si ma trimite in panoul principal
						client = new Client(nume, prenume, adrLiv, email, user, pass, nrTel);
						lista.adaugaClient(client);
						client.setCod(client.hashCode());
						lista.salveazaListaClienti();
						setVisible(false);
						try {
							new MainFrame();

						} catch (Exception f) {
							f.printStackTrace();
						}

					}

				});
			}
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
		}
		setVisible(true);
	}

}
