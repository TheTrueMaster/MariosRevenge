package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class GUI {

	private JFrame frame;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Mario's Revenge");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 949, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("C:\\Users\\Ronak Shah\\Documents\\School\\AP Computer Science\\MariosRevenge\\res\\logo.png");
		Image logo = icon.getImage().getScaledInstance(779, 214, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(logo));
		label.setBounds(57, 42, 779, 239);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("");
		button.setAction(action);
		button.setIcon(new ImageIcon("C:\\Users\\Ronak Shah\\Documents\\School\\AP Computer Science\\MariosRevenge\\res\\start.png"));
		button.setBounds(310, 291, 312, 89);
		frame.getContentPane().add(button);
		
		JButton btnInstructions = new JButton("Instructions");
		btnInstructions.setBounds(10, 526, 89, 23);
		frame.getContentPane().add(btnInstructions);
		
		//button.
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Level1.run();
		}
	}
}
