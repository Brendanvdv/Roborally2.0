package appView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import appControl.LaunchControl;
import appControl.SoundPlayer;

public class LaunchView extends JFrame {
    private int playerAmount;
    private int difficulty;
    private LaunchControl launchControl;
    private String[] sounds = new String[] {"button1","button2","button3","button4","button5","button6"};
    private Image image;
    private JPanel panel;
    GridBagConstraints c;


    public LaunchView(LaunchControl launchControl) {
	image = Toolkit.getDefaultToolkit().createImage("src/test/resources/images/splashScreen.gif");
	this.launchControl = launchControl;
	initGUI();
	SoundPlayer.playSound("welcome");


    }


    private void initGUI() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setSize(700,700);
	setTitle("Setting up ROBORALLY 2.0");
	setLayout(new BorderLayout());

	this.setContentPane(panel = new JPanel() {
	    @Override
	    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	    }});

	panel.setSize(300, 400);
	panel.setLayout(new FlowLayout());

	{
	    String text = "<html><b>Please select the difficulty:</b></html>";
	    JLabel fline = new JLabel(text);
	    fline.setForeground(Color.WHITE);
	    fline.setFont(new Font("Serif", Font.PLAIN, 20));
	    panel.add(fline);
	}


	configureDiff();

	{
	    String text = "<html><b>Please select the number of players:</b></html>";
	    JLabel sline = new JLabel(text);
	    sline.setForeground(Color.WHITE);
	    sline.setFont(new Font("Serif", Font.PLAIN, 20));
	    panel.add(sline);
	}
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
		    SoundPlayer.startSoundTrack();
		}
	    }
	});

	startButton.addMouseListener(new MouseAdapter() 
	{
	    public void mouseEntered(MouseEvent evt) 
	    {
		SoundPlayer.playRandomSound(sounds);

	    }
	});

	startButton.setFocusPainted(false);
	startButton.setBackground(new Color(86,19,186));
	startButton.setForeground(new Color(220,0,176));
	startButton.setBounds(275,330,150,35); 


	panel.add(startButton);
    }


    private void configureDiff() {

	JButton easy = new JButton("easy");

	JButton medium = new JButton("medium");

	JButton hard = new JButton("hard");


	easy.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		difficulty = 1;

	    }
	});
	easy.addMouseListener(new MouseAdapter() 
	{
	    public void mouseEntered(MouseEvent evt) 
	    {
		SoundPlayer.playRandomSound(sounds);

	    }
	});

	medium.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		difficulty = 2;
	    }
	});
	medium.addMouseListener(new MouseAdapter() 
	{
	    public void mouseEntered(MouseEvent evt) 
	    {
		SoundPlayer.playRandomSound(sounds);

	    }
	});

	hard.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		difficulty = 3;
	    }
	});
	hard.addMouseListener(new MouseAdapter() 
	{
	    public void mouseEntered(MouseEvent evt) 
	    {
		SoundPlayer.playRandomSound(sounds);

	    }
	});

	panel.add(easy);
	panel.add(medium);
	panel.add(hard);
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
	two.addMouseListener(new MouseAdapter() 
	{
	    public void mouseEntered(MouseEvent evt) 
	    {
		SoundPlayer.playRandomSound(sounds);

	    }
	});

	three.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		playerAmount = 3;
	    }
	});
	three.addMouseListener(new MouseAdapter() 
	{
	    public void mouseEntered(MouseEvent evt) 
	    {
		SoundPlayer.playRandomSound(sounds);

	    }
	});

	four.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		playerAmount = 4;
	    }
	});
	four.addMouseListener(new MouseAdapter() 
	{
	    public void mouseEntered(MouseEvent evt) 
	    {
		SoundPlayer.playRandomSound(sounds);

	    }
	});

	panel.add(two);
	panel.add(three);
	panel.add(four);
    }

}	
