package appControl;


import appModel.Board;
import appModel.GameInstance;
import appModel.GameMaster;
import appView.ModelView;

public class ModelControl {

    private GameMaster gm;
    private ModelView modelView;


    public ModelControl(GameMaster gameMaster) {
	gm = gameMaster;
    }



    public void setView(ModelView modelView) {
	this.modelView = modelView;
    }

    public void display() {
	modelView.setVisible(true);
    }
    
    public Board getBoard() {
	return gm.getBoard();
    }
}

