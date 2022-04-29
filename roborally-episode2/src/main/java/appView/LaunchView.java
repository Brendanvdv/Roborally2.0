package appView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import appControl.LaunchControl;

public class LaunchView extends JFrame {
    private int playerAmount;
    private int difficulty;
    private LaunchControl launchControl;


    public LaunchView(LaunchControl launchControl) {
	this.launchControl = launchControl;
	initGUI();
    }


    private void initGUI() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setSize(300,300);
	setTitle("Setting up ROBORALLY 2.0");

	setLayout(new FlowLayout());

	add(new JLabel("Please select the difficulty:"));

	configureDiff();
	
	add(new JLabel("Please select the number of players:"));
	
	configurePlayers();
	
	configureStart();
    }

    private void configureStart() {
	JButton startButton = new JButton("START");

	
	startButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		if(playerAmount != 0 && difficulty != 0) {
		    launchControl.startGame(playerAmount,difficulty);
		}
	    }
	});
	
	add(startButton);
    }


    private void configureDiff() {
	JPanel diffButtons = new JPanel();

	diffButtons.setLayout(new FlowLayout());

	JButton easy = new JButton("easy");

	JButton medium = new JButton("medium");

	JButton hard = new JButton("hard");


	easy.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		difficulty = 1;
		
	    }
	});
	medium.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		difficulty = 2;
	    }
	});
	hard.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		difficulty = 3;
	    }
	});

	diffButtons.add(easy);
	diffButtons.add(medium);
	diffButtons.add(hard);

	add(diffButtons);
    }

    private void configurePlayers() {
   	JPanel playersButtons = new JPanel();

   	playersButtons.setLayout(new FlowLayout());

   	JButton two = new JButton("2");

   	JButton three = new JButton("3");

   	JButton four = new JButton("4");


   	two.addActionListener(new ActionListener() {
   	    @Override
   	    public void actionPerformed(ActionEvent e) {
   		playerAmount = 2;
   	    }
   	});
   	three.addActionListener(new ActionListener() {
   	    @Override
   	    public void actionPerformed(ActionEvent e) {
   		playerAmount = 3;
   	    }
   	});
   	four.addActionListener(new ActionListener() {
   	    @Override
   	    public void actionPerformed(ActionEvent e) {
   		playerAmount = 4;
   	    }
   	});

   	playersButtons.add(two);
   	playersButtons.add(three);
   	playersButtons.add(four);

   	add(playersButtons);
       }

}	
