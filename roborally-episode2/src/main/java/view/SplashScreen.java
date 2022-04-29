package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import rebuild.SoundPlayer;

class SplashScreen extends JPanel {
	
	String[] sounds = new String[] {"button1","button2","button3","button4","button5","button6"};
    Image image;

    public SplashScreen() {
        image = Toolkit.getDefaultToolkit().createImage("src\\test\\resources\\images\\splashScreen.gif");
        setLayout(null);
        
        //Define button
        JButton startGame = new JButton("Start Game!");  
        startGame.setFocusPainted(false);
        startGame.setBackground(new Color(86,19,186));
        startGame.setForeground(new Color(220,0,176));
        startGame.setBounds(275,330,150,35);  
        
        //Play random note in G when hovering over the button
        startGame.addMouseListener(new MouseAdapter() 
        {
           public void mouseEntered(MouseEvent evt) 
           {
        	   SoundPlayer.playRandomSound(sounds);

           }
        });
        
        //Start the game when "Start game" is pressed
        startGame.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
            	//Add function to start the game here
            }  
        }); 
        SoundPlayer.playSound("welcome");
        this.add(startGame);

    }
    
    //Show gif when GUI thread calls to paint object
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
    
    

}