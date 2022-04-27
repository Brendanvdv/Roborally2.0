package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rebuild.Tile;

public class TileView extends JPanel {
    
    public static final int PIXEL_SIZE = 64;

    private boolean containsRobot = false;
    private BufferedImage image;
    private BufferedImage imageRobot;
    private int direction = 0;
    
    
    
    public TileView(Tile row) {

	assignImage(row);
    }

    private void assignImage(Tile tile) {
	String path = tile.getType().getPictureFile();
	File file = new File(path);
	
	String pathR = "src/test/resources/images/acid.png";
	File fileR = new File(pathR);
	    
	    

	try {
	    this.image = ImageIO.read(file);
	    this.imageRobot = ImageIO.read(fileR);
	} catch (IOException e) {
	    this.image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	    this.imageRobot = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	    
	}
    }
    
    @Override
    public void paint(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;

	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2d.drawImage(image, 0, 0, null);
	
	if (containsRobot) {
	    AffineTransform old2 = g2d.getTransform();
	    g2d.rotate(Math.toRadians((direction+1)*90), 32, 32);
	    g2d.drawImage(imageRobot, 0, 0, null);
	    g2d.setTransform(old2);
	}
    }
}
