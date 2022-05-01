package appControl;

import appView.LaunchView;

public class LaunchControl {

	private AppControl app;
	private LaunchView launchView;

	public LaunchControl(AppControl appControl) {
		app = appControl;
		launchView = new LaunchView(this);
	}

	public void display() {
		launchView.setVisible(true);
	}

	public void startGame(int playerAmount, int difficulty) {
		launchView.dispose();
		app.setUp(playerAmount, difficulty);
	}

}
