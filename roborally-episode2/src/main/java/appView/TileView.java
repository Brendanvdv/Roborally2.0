package appView;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import appModel.Tile;

public class TileView extends JPanel {

    private boolean containsRobot = false;
    private Image image;
    private Image imageRobot;
    private int direction;
    private int robot;
    private int difficulty;



    public TileView(Tile row, int difficulty) {
	this.difficulty = difficulty;
	assignImage(row);
	containsRobot = row.isContainsRobot();
	direction = row.getDir();

	if(containsRobot) {
	    robot = row.getRbt();
	}


    }

    private void assignImage(Tile tile) {
	String path = tile.getType().getPictureFile();
	File file = new File(path);

	try {
	    this.image = ImageIO.read(file);

	    if(difficulty == 2) {
		this.image = image.getScaledInstance(41, 41, Image.SCALE_SMOOTH);
	    } else if(difficulty == 3) {
		this.image = image.getScaledInstance(28, 28, Image.SCALE_SMOOTH);
	    }

	} catch (IOException e) {
	    this.image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	}
    }

    @Override
    public void paint(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;

	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2d.drawImage(image, 0, 0, null);

	if (containsRobot) {

	    String pathR = null;


	    if(robot == 1) {
		pathR = "src/test/resources/images/Player1.png";
	    } else if(robot == 2) {
		pathR = "src/test/resources/images/Player2.png";
	    } else if(robot == 3) {
		pathR = "src/test/resources/images/Player3.png";
	    } else {
		pathR = "src/test/resources/images/Player4.png";
	    }

	    File fileR = new File(pathR);


	    try {
		this.imageRobot = ImageIO.read(fileR);
		if(difficulty == 2) {
		    this.imageRobot = imageRobot.getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		} else if(difficulty == 3) {
		    this.imageRobot = imageRobot.getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		}
	    } catch (IOException e) {
		this.imageRobot = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	    }

	    AffineTransform old2 = g2d.getTransform();
	    
	    if(difficulty == 1) {
		g2d.rotate(Math.toRadians((direction)*45), 32, 32);
	    } else if(difficulty == 2) {
		g2d.rotate(Math.toRadians((direction)*45), 20.5, 20.5);
	    } else if(difficulty == 3) {
		g2d.rotate(Math.toRadians((direction)*45), 14, 14);
	    }
	    
	    g2d.drawImage(imageRobot, 0, 0, null);
	    g2d.setTransform(old2);
	}
    }
}
