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

public class GUI {

	private JFrame frame;

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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Ronak Shah\\Documents\\School\\AP Computer Science\\MariosRevenge\\res\\start.png"));
		btnNewButton.setBounds(312, 292, 270, 57);
		frame.getContentPane().add(btnNewButton);
	}
}
