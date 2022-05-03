package appView;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VictoryView extends JFrame {
	public VictoryView(String i) {
		add(new JLabel("Game Over, " + i + " has won the game!"));
		setSize(new Dimension(300, 100));
		setTitle("Victory!");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
