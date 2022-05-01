package appModel;

public enum TyleType {
	Acid("src/test/resources/images/acid.png"), Pit("src/test/resources/images/pit.png"),
	Barrel("src/test/resources/images/barrel.png"), LaserV("src/test/resources/images/LaserV.png"),
	LaserH("src/test/resources/images/LaserH.png"), Floor("src/test/resources/images/floor.png"),
	Health("src/test/resources/images/health.png"), ConveyorN("src/test/resources/images/ConveyorN.png"),
	ConveyorS("src/test/resources/images/ConveyorS.png"), ConveyorW("src/test/resources/images/ConveyorW.png"),
	ConveyorE("src/test/resources/images/ConveyorE.png"), GearL("src/test/resources/images/gearL.png"),
	GearR("src/test/resources/images/gearR.png"), Checkpoint("src/test/resources/images/checkpoint.png");

	private String pictureFile;

	private TyleType(String pictureFile) {
		this.pictureFile = pictureFile;
	}

	public String getPictureFile() {
		return pictureFile;
	}
}
