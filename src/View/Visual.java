package View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Visual {

	private JFrame frame;
	private JPanel splash;
	private JPanel instructions;
	private boolean panelIsOn = false;
	private JLabel logoImage;
	private JButton btnInstructions;
	private JButton start;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visual window = new Visual();
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
	public Visual() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Mario's Revenge");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 949, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

		ImageIcon icon = new ImageIcon("C:\\Users\\Ronak Shah\\Documents\\School\\AP Computer Science\\MariosRevenge\\res\\logo.png");
		Image scaled = icon.getImage().getScaledInstance(779, 214, Image.SCALE_DEFAULT);

	

		/*Below is JPanel code for instruction screen*/
		instructions = new JPanel();
		instructions.setLocation(0, 0);
		instructions.setBackground(Color.black);
		instructions.setSize(949, 513);
		//frame.getContentPane().add(instructions);
		instructions.setVisible(false);
		panelIsOn = false;
		JLabel insContent = new JLabel();
		insContent.setIcon(new ImageIcon("C:\\Users\\Ronak Shah\\Documents\\School\\AP Computer Science\\MariosRevenge\\res\\instructions.png"));
		instructions.add(insContent);
		/*End of JPanel code*/


		btnInstructions = new JButton("Instructions");
		btnInstructions.setBounds(10, 526, 146, 30);

		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(panelIsOn);
				if(panelIsOn){
					panelIsOn = false;
					instructions.setVisible(false);
					splash.setVisible(true);
					
				}
				else{
					panelIsOn = true;
					instructions.setVisible(true);
					splash.setVisible(false);

				}
			}
		});;

		splash = new JPanel();
		splash.setBackground(Color.BLACK);
		splash.setLayout(null);


		logoImage = new JLabel();
		logoImage.setIcon(new ImageIcon(scaled));
		logoImage.setBounds(77, 33, 818, 245);
		splash.add(logoImage);

		start = new JButton("");
		start.setSize(50, 8);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		icon = new ImageIcon("C:\\Users\\Ronak Shah\\Documents\\School\\AP Computer Science\\MariosRevenge\\res\\start.png");
		scaled = icon.getImage().getScaledInstance(320, 150, Image.SCALE_DEFAULT);
		start.setIcon(new ImageIcon(scaled));
		start.setBounds(307, 289, 320, 120);
		splash.add(start);

		splash.setBounds(0, 0, 949, 513);
		frame.getContentPane().add(splash);
		frame.getContentPane().add(instructions);
		frame.getContentPane().add(btnInstructions);
		
		splash.setVisible(true);
		instructions.setVisible(false);
		//adding to main so that it remains constant for instructions and splash
		//button.
	}
}
