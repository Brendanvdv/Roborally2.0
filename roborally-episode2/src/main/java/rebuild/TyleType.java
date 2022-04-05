package rebuild;

public enum TyleType {
    Acid("src/test/resources/images/acid.png"),
    Pit("src/test/resources/images/pit.png"),
    Barrel("src/test/resources/images/barrel.png"),
    Laser("src/test/resources/images/laser.png"),
    Floor("src/test/resources/images/floor.png"),
    Health("src/test/resources/images/health.png"),
    Conveyor1("src/test/resources/images/conveyor1.png"),
    Conveyor2("src/test/resources/images/conveyor2.png"),
    Conveyor3("src/test/resources/images/conveyor3.png"),
    GearL("src/test/resources/images/gearL.png"),
    GearR("src/test/resources/images/gearR.png"),
    Checkpoint("src/test/resources/images/checkpoint.png");
    
    private String pictureFile;

    private TyleType(String pictureFile) {
	this.pictureFile = pictureFile;
    }

    public String getPictureFile() {
	return pictureFile;
    }
}
