package rebuild;

import java.awt.Dimension;

import javax.swing.JFrame;

import view.GameView;

public class RoboRally {

    public static void main(String[] args) {
	GameView g = new GameView();
	
	g.setTitle("RoboRally 4.3");
	g.setSize(new Dimension(700, 700));
	g.setVisible(true);
	g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
    }
}
