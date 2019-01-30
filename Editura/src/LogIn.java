import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LogIn extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtUser = new JTextField();
	private JPasswordField txtPass = new JPasswordField();
	private ArrayList<Client> listaClient = new ArrayList<Client>();

	public void adaugaPanou() {

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setBackground(new Color(34, 34, 51));

	}

	public void adaugaPanou(JTextField txt, String text) {

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		txt.setText(text);
		panel.add(txt);
		txt.setColumns(20);
		panel.setBackground(new Color(34, 34, 51));

	}

	public void verifica(String user, char[] p) {
		String pass = "";
		for (int i = 0; i < p.length; i++) {
			pass = pass + p[i];
		}

		for (Client c : listaClient) {
			System.out.println(c.getUsername() + c.getParola());
			System.out.println(user + " " + pass);
			if (user.equals(c.getUsername()) && pass.equals(c.getParola())) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new MainFrame(c);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			} else {
				JOptionPane.showMessageDialog(null, "UserName/Parola gresit", "Acces Denied",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

	public void adaugaButoane() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setBackground(new Color(34, 34, 51));
		{
			JButton btnNewButton_1 = new JButton("Create User");
			btnNewButton_1.setBackground(new Color(255, 255, 100));
			panel.add(btnNewButton_1);
			btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// ma trimite la creere user nou
					setVisible(false);
					try {
						new CreateUser();

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			});
		}
		{
			JButton btnNewButton_2 = new JButton("Log In");
			btnNewButton_2.setBackground(new Color(255, 255, 100));
			panel.add(btnNewButton_2);
			btnNewButton_2.setHorizontalAlignment(SwingConstants.RIGHT);
			btnNewButton_2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					// ma trimite in panoul principal dupa verificare
					verifica(txtUser.getText(), txtPass.getPassword());
				}

			});
		}
	}

	public LogIn() {
		setSize(450, 300);
		setLocationRelativeTo(null);
		setTitle("E-Editura SERBAN");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(new GridLayout(6, 1, 0, 0));
		adaugaPanou();
		adaugaPanou(txtUser, "Username");
		adaugaPanou(txtPass, "");
		adaugaButoane();
		adaugaPanou();
		try {
			BufferedReader buf = new BufferedReader(new FileReader("txt\\clienti.txt"));
			while (true) {
				String linie = buf.readLine();
				if (linie == null) {
					break;
				} else {
					String tablou[] = linie.split(" ");
					Client client = new Client(tablou[0], tablou[1], tablou[2], tablou[3], tablou[4], tablou[5],
							tablou[6]);
					listaClient.add(client);
					System.out.println(client.toString());
				}

			}
			buf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			FlowLayout fl_panel = new FlowLayout(FlowLayout.RIGHT, 5, 5);
			panel.setLayout(fl_panel);
			panel.setBackground(new Color(34, 34, 51));
			{
				JButton btnNewButton = new JButton("Continue as Guest");
				btnNewButton.setBackground(new Color(255, 255, 100));
				panel.add(btnNewButton);
				panel.setBackground(new Color(34, 34, 51));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// ma trimite in panoul principal
						setVisible(false);
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Client client = new Client(null, null, null, null, null, null, null);
									new MainFrame(client);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});

					}

				});
			}

			setVisible(true);

		}

	}

}
