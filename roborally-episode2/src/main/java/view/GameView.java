package view;

import javax.swing.JFrame;

import controls.ControlPanel;

public class GameView extends JFrame {
    
    ControlPanel cPanel;
    BoardView bView;
    Buttons buttons;
    
    public GameView() {
	cPanel = new ControlPanel();
	bView = new BoardView(cPanel.getGame().askMaster().getBoard());
	add(bView);
    }


    
}
