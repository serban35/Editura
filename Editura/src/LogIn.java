import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LogIn extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	public LogIn() {
		setSize(450, 300);
		setLocationRelativeTo(null);
		setTitle("E-Editura SERBAN");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(new GridLayout(6, 1, 0, 0));
		{
			JPanel panel = new JPanel();

			panel.setLayout(new FlowLayout());
			getContentPane().add(panel);
		}
		{
			JPanel panel = new JPanel();

			panel.setLayout(new FlowLayout());
			getContentPane().add(panel);
			{
				txtUsername = new JTextField();
				txtUsername.setText("Username");
				panel.add(txtUsername);
				txtUsername.setColumns(20);
			}
		}
		{
			JPanel panel = new JPanel();

			panel.setLayout(new FlowLayout());
			getContentPane().add(panel);
			{
				passwordField = new JPasswordField();
				panel.add(passwordField);
				passwordField.setColumns(20);
			}
		}
		{
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

					}

				});
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
		}
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
									new MainFrame();
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
