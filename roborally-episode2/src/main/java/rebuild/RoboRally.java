package rebuild;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;


import javax.swing.JFrame;

import org.json.simple.parser.ParseException;

import view.GameView;

public class RoboRally {


    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	GameView g = new GameView();

	g.setTitle("RoboRally 4.3");
	g.setSize(new Dimension(1000,1000));
	g.setLayout(new FlowLayout(FlowLayout.CENTER));
	g.setVisible(true);
	g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	while(true) {
	    g.turn(0);
	    g.turn(1);
	    g.turn(2);
	    g.turn(3);

	    g.execM();

	    g.getContentPane().removeAll();
	    g.repaint();
	    g.init();
	    g.repaint();
	}




    }
}

