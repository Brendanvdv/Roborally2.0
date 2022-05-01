package appControl;

import javax.swing.JFrame;

import appModel.GameMaster;
import appView.LaunchView;
import appView.ModelView;

public class AppControl {

    private LaunchControl launch;
    private ModelControl model;





    private void launch() {
	launch = new LaunchControl(this);
	launch.display();
    }


    public static void main(String[] args) {
	AppControl app = new AppControl();
	app.launch();
    }


    public void setUp(int playerAmount, int difficulty) {
	model = new ModelControl(new GameMaster(playerAmount,difficulty));

	ModelView modelView = new ModelView(model);
	model.setView(modelView);
	model.display();

	play();
    }


    public void play() {

	model.startRunning();

	for(int i = 0; i < model.numberOfPlayers(); i++) {
	    model.getCommand().setText("Player " + (i+1) + " select your cards:");
	    model.getCardView().boot(model.getCards(i));
	    model.getCardView().setActive(true);

//	    do {
//		System.out.print("");;
//	    } while(!model.getCardView().isActive());
	    
	}


	//	    for(int i = 0; i < model.numberOfPlayers(); i++) {
	//		model.getCommand().setText("Player " + (i+1) + " select your cards:");
	//		model.getCardView().boot(model.getCards(i));
	//
	//		while(true) {
	//    
	//		    if(!model.getCardView().isActive()) {
	//			loadHand(i);
	//			break;	
	//		    } 
	//		}
	//	    }

	//	    model.nextTurn();

    }


    private void loadHand(int i) {
	model.setHand(model.getCardView().getHand(),i);
    }
}
