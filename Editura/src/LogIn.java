import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LogIn extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtUser = new JTextField();
	private JPasswordField txtPass = new JPasswordField();

	public void adaugaPanou() {

		JPanel panel = new JPanel();
		getContentPane().add(panel);

	}

	public void adaugaPanou(JTextField txt, String text) {

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		txt.setText(text);
		panel.add(txt);
		txt.setColumns(20);

	}

	public void verifica(String user, char[] p) {

		String pass = "";
		for (int i = 0; i < p.length; i++) {
			pass = pass + p[i];
		}
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
					System.out.println(user);
					System.out.println(client.getUsername());
					System.out.println(pass);
					System.out.println(client.getParola());
					if (user.equals(client.getUsername()) && pass.equals(client.getParola())) {
						setVisible(false);
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									new MainFrame(client);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}

				}

			}

			buf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void adaugaButoane() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		{
			JButton btnNewButton_1 = new JButton("Create User");
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
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			FlowLayout fl_panel = new FlowLayout(FlowLayout.RIGHT, 5, 5);
			panel.setLayout(fl_panel);
			{
				JButton btnNewButton = new JButton("Continue as Guest");
				panel.add(btnNewButton);
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
