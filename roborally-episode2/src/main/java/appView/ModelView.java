package appView;

import java.awt.Dimension;

import javax.swing.JFrame;

import appControl.ModelControl;

public class ModelView extends JFrame {
    
    ModelControl model;
    BoardView boardView;

    public ModelView(ModelControl model) {
	this.model = model;
	initGUI();
    }

    private void initGUI() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("ROBORALLY 2.0");
	setPreferredSize(new Dimension(1000, 1000));
	
	
	boardView = new BoardView(model.getBoard());
	add(boardView);
    }
    
    

}
