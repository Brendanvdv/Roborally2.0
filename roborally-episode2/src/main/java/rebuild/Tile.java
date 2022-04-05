package rebuild;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Tile extends JPanel{
    private static final long serialVersionUID = -179870080053807113L;

    public static final int PIXEL_SIZE = 64;

    private TyleType type;
    private int diff;
    private Obstacle obstacle;
    private BufferedImage image;

    public Tile(int difficulty) {
	diff = difficulty;
	init();
	String path = this.type.getPictureFile();
	    File file = new File(path);

//	try {
//	    this.image = ImageIO.read(file);
//	} catch (IOException e) {
//	    this.image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
//	}
	
	setMinimumSize(new Dimension(PIXEL_SIZE, PIXEL_SIZE));
	setMaximumSize(getMinimumSize());
	setPreferredSize(getMinimumSize());
    }

    public void init() {
	double val = Math.random();
	double x = 0.65 - diff*0.1;
	double y = (1 - x)/11;


	if(val < x) {
	    type = TyleType.Floor;
	    obstacle = new Obstacle("Floor");
	} else if(val < x+y) {
	    type = TyleType.Pit;
	    obstacle = new Obstacle("Pit");
	} else if(val < x+3*y) {
	    type = TyleType.Barrel;
	    obstacle = new Obstacle("Barrel");
	} else if(val < x+3.5*y) {
	    type = TyleType.Laser;
	    obstacle = new Obstacle("Laser");
	} else if(val < x+5*y) {
	    type = TyleType.Acid;
	    obstacle = new Obstacle("Acid");
	} else if(val < x+6*y) {
	    type = TyleType.Health;
	    obstacle = new Obstacle("Health");
	} else if(val < x+7*y) {
	    type = TyleType.Conveyor1;
	    obstacle = new Obstacle("Conveyor1");
	} else if(val < x+8*y) {
	    type = TyleType.Conveyor2;
	    obstacle = new Obstacle("Conveyor2");
	} else if(val < x+9*y) {
	    type = TyleType.Conveyor3;
	    obstacle = new Obstacle("Conveyor3");
	} else if(val < x+10*y) {
	    type = TyleType.GearL;
	    obstacle = new Obstacle("GearL");
	} else {
	    type = TyleType.GearR;
	    obstacle = new Obstacle("GearR");
	}
    }

    public TyleType getType() {
	return type;
    }

    public void setType(TyleType tileType) {
	type = tileType;
    }

    public boolean validObstacle() {
	if(!Objects.isNull(obstacle)) {
	    return true;
	}

	return false;
    }

    public Obstacle getObstacle() {
	return obstacle;
    }

    public void setObstacle(Obstacle obs) {
	obstacle = obs;
    }
    
//    @Override
//    public void paint(Graphics g) {
//	super.paintComponent(g);
//	Graphics2D g2d = (Graphics2D) g;
//
//	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//	g2d.drawImage(image, 0, 0, null);
//    }
}
