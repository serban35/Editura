import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.JDialog;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;

public class Cos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cos(CosCumparaturi cos) {
		setType(Type.UTILITY);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane);

		TextArea textArea = new TextArea();
		textArea.setColumns(3);
		splitPane.setLeftComponent(textArea);

		JTextPane txtpnTotalPret = new JTextPane();
		splitPane.setRightComponent(txtpnTotalPret);
		setVisible(true);
	}

}
