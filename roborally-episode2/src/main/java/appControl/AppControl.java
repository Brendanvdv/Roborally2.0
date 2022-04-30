package appControl;

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
    }
}
