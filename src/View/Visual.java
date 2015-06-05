package View;

import java.awt.*;

import javax.swing.*;
import ImportManager.ImportManager;//pun intented

import java.awt.event.*;

public class Visual implements KeyListener {

	private JFrame frame;
	private JPanel splash;
	private JPanel instructions;
	private Level level;
	private boolean panelIsOn = false;
	private JLabel logoImage;
	private JButton btnInstructions;
	private JButton start;
	private int screen = 0;//0 -> splash ; 1 -> instructions ; 2->Level
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					ImportManager.loadFiles();
					Visual window = new Visual();
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
	public Visual() {
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
		frame.setBounds(100, 100, 1800, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		ImageIcon icon = new ImageIcon(ImportManager.title);
		Image scaled = icon.getImage().getScaledInstance(779, 214, Image.SCALE_DEFAULT);
		
		
		level = new Level(frame.getHeight() - 30, frame.getWidth());
		
		/*Below is JPanel code for instruction screen*/
		instructions = new JPanel();
		instructions.setLocation(0, 0);
		instructions.setBackground(Color.black);
		instructions.setSize(1352, 513);
		//frame.getContentPane().add(instructions);
		instructions.setVisible(false);
		panelIsOn = false;
		JLabel insContent = new JLabel();
		insContent.setIcon(new ImageIcon(ImportManager.instructions));
		instructions.add(insContent);
		/*End of JPanel code*/
		
		
		btnInstructions = new JButton("Instructions");
		btnInstructions.setBorder(null);
		btnInstructions.setBorderPainted(false);
		btnInstructions.setBackground(Color.BLACK);
		btnInstructions.setFont(new Font("SWSimp", Font.PLAIN, 80));
		btnInstructions.setBounds(10, 526, 1326, 168);
		btnInstructions.setForeground(Color.white);
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
					level.setVisible(false);
					splash.setVisible(true);
					Level.paintable = false;
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
		logoImage.setBounds(265, 43, 818, 245);
		splash.add(logoImage);

		start = new JButton("");
		start.setSize(50, 8);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//level = new Level(frame.getWidth(), frame.getHeight());
				JPanel p = (JPanel)level;
				frame.getContentPane().add(p);
				splash.setVisible(false);
				level.setSize(frame.getWidth(), frame.getHeight());
				btnInstructions.setText("Back to Main");
				screen = 2;
				Level.paintable = true;
				level.start();
			}
		});
		
		icon = new ImageIcon(ImportManager.startLogo);
		scaled = icon.getImage().getScaledInstance(320, 150, Image.SCALE_DEFAULT);
		start.setIcon(new ImageIcon(scaled));
		start.setBounds(454, 282, 320, 120);
		splash.add(start);
		
		//temp code
		splash.setBounds(0, 0, 1352, 513);
		frame.getContentPane().add(splash);
		frame.getContentPane().add(instructions);

		frame.getContentPane().add(btnInstructions);
		
		

		
		splash.setVisible(true);
		instructions.setVisible(false);
		//adding to main so that it remains constant for instructions and splash
		//button.
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Visual");
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
