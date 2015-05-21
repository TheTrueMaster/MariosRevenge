package View;

import java.awt.*;

import javax.swing.*;

import Controller.Game;

import java.awt.event.*;

public class Visual {

	private JFrame frame;
	private JPanel splash;
	private JPanel instructions;
	private JPanel level;
	private boolean panelIsOn = false;
	private JLabel logoImage;
	private JButton btnInstructions;
	private JButton start;
	private Game game;
	private int screen = 0;//0 -> splash ; 1 -> instructions ; 2->Level
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassLoader cldr = this.getClass().getClassLoader();
					Game game = new Game(cldr);
					Visual window = new Visual(game);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*
	 * JPanel instructions dkfdsf 
	 * */


	/**
	 * Create the application.
	 */
	public Visual(Game g) {
		game = g;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Mario's Revenge");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBackground(Color.BLACK);
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
				if(screen == 0){
					instructions.setVisible(true);
					splash.setVisible(false);
					screen = 1;
					btnInstructions.setText("Main Menu");
				}
				else if (screen == 1){
					instructions.setVisible(false);
					splash.setVisible(true);
					screen = 0;
					btnInstructions.setText("Instructions");
				}
				else if(screen == 2){
					splash.setVisible(true);
					screen = 0;
					btnInstructions.setText("Instructions");
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
				Level lev = new Level(frame.getHeight(), frame.getWidth(), game);
				JPanel p = (JPanel)lev;
				frame.getContentPane().add(p);
				splash.setVisible(false);
				lev.setSize(949, 513);
				btnInstructions.setText("Back to Main");
				screen = 2;
			}
		});
		
		icon = new ImageIcon("C:\\Users\\Ronak Shah\\Documents\\School\\AP Computer Science\\MariosRevenge\\res\\start.png");
		scaled = icon.getImage().getScaledInstance(320, 150, Image.SCALE_DEFAULT);
		start.setIcon(new ImageIcon(scaled));
		start.setBounds(307, 289, 320, 120);
		splash.add(start);
		
		//temp code
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
