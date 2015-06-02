package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ImportManager.*;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Death extends JPanel {

	private JLabel meme;
	private JButton btnWannaTryAgain;
	private JLabel YouLose;
	/**
	 * Create the panel.
	 */
	public Death() {
		setBackground(Color.BLACK);
		ImportManager.loadFiles();
		setLayout(null);
		YouLose = new JLabel("You Lose. \r\n");
		YouLose.setBounds(161, 57, 437, 119);
		YouLose.setForeground(Color.WHITE);
		YouLose.setFont(new Font("Press Start", Font.PLAIN, 35));
		add(YouLose);

		btnWannaTryAgain = new JButton("Wanna Try Again?");
		btnWannaTryAgain.setBounds(228, 240, 271, 119);
		btnWannaTryAgain.addActionListener(new TryAgainHandler());
		add(btnWannaTryAgain);

		meme = new JLabel();
		meme.setBounds(58, 26, 664, 411);
		add(meme);
		meme.setIcon(new ImageIcon(ImportManager.meme));
		this.setBounds(0, 0, 600, 600);
		meme.setVisible(false);

	}

	public static void main(String []args){
		Death panel = new Death();
		JFrame frame = new JFrame();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		panel.setBounds(0,0,1000,1000);
	}

	private class TryAgainHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			meme.setVisible(true);
			YouLose.setVisible(false);
			btnWannaTryAgain.setVisible(false);
		}

	}
}
