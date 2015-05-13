package View;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.*;
import java.awt.event.ActionEvent;
import Controller.*;

import java.awt.event.ActionListener;

import java.awt.GridLayout;



public class Level1 {

	private JFrame frame;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level1 window = new Level1();
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
	public Level1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 949, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Game game = new Game();
		
		JButton btnMain = new JButton("");
		btnMain.setAction(action);
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ImageIcon icon = new ImageIcon("C:\\Users\\Ronak Shah\\Documents\\School\\AP Computer Science\\MariosRevenge\\res\\mainmenuobj.png");
		Image img = icon.getImage().getScaledInstance(138, 42, Image.SCALE_DEFAULT);
		btnMain.setIcon(new ImageIcon(img));
		btnMain.setBounds(0, 0, 141, 42);
		frame.getContentPane().add(btnMain);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 53, 913, 507);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		//level objects init below
		Render objCreator = new Render();
		objCreator.init(panel, game);
		JMenuItem mntmNewMenuItem = new JMenuItem("Main Menu");
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			//putValue(NAME, "SwingAction");
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			GUI.main(null);
		}
	}
}
