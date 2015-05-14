package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	private JPanel ins;
	private boolean panelIsOn = false;
	private final Action action_1 = new SwingAction_1();
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
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//
		logoImage = new JLabel();
		ImageIcon icon = new ImageIcon("C:\\Users\\Ronak Shah\\Documents\\School\\AP Computer Science\\MariosRevenge\\res\\logo.png");
		Image logo = icon.getImage().getScaledInstance(779, 214, Image.SCALE_DEFAULT);
		logoImage.setIcon(new ImageIcon(logo));
		logoImage.setBounds(57, 42, 779, 239);
		frame.getContentPane().add(logoImage);

		/*Below is JPanel code for instruction screen*/
		ins = new JPanel();
		ins.setBackground(Color.black);
		ins.setSize(949, 599);
		frame.getContentPane().add(ins);
		ins.setVisible(false);
		
		JLabel insContent = new JLabel();
		insContent.setIcon(new ImageIcon("C:\\Users\\Ronak Shah\\Documents\\School\\AP Computer Science\\MariosRevenge\\res\\instructions.png"));
		ins.add(insContent);
		/*End of JPanel code*/
		
		start = new JButton("");
		start.setAction(action);
		start.setIcon(new ImageIcon("C:\\Users\\Ronak Shah\\Documents\\School\\AP Computer Science\\MariosRevenge\\res\\start.png"));
		start.setBounds(310, 291, 312, 89);
		frame.getContentPane().add(start);

		btnInstructions = new JButton("Instructions");
		btnInstructions.setAction(action_1);
		btnInstructions.setBounds(10, 526, 146, 30);
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
	
	/**
	 * 
	 * @author Ronak Shah
	 *	INSTRUCTIONS BUTTON HANDLER
	 */
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Instructions");
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(panelIsOn){
				ins.setVisible(false);
				panelIsOn = false;
				logoImage.setVisible(true);
				start.setVisible(true);
				putValue(NAME, "Instructions");
			}
			else{
				putValue(NAME, "Back to main");
				ins.setVisible(true);
				panelIsOn = true;
				logoImage.setVisible(false);
				start.setVisible(false);
			    
			}
		}
	}
}
