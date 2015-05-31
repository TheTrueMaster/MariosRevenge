package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Death extends JPanel {

	/**
	 * Create the panel.
	 */
	public Death() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel lblYouLoseToph = new JLabel("You Lose. \r\n");
		lblYouLoseToph.setForeground(Color.WHITE);
		lblYouLoseToph.setFont(new Font("Press Start", Font.PLAIN, 28));
		lblYouLoseToph.setBounds(75, 75, 334, 119);
		add(lblYouLoseToph);

	}
}
