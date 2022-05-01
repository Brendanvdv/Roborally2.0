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
	modelView.setNumber((modelView.getNumber())%model.getNumberOfPlayers());
	model.setView(modelView);
	model.display();
	model.play();
    }

    private void loadHand(int i) {
	model.setHand(model.getCardView().getHand(),i);
    }
}
