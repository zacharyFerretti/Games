package mainGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

    BufferedImage img;

    public ImagePanel() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        try {
        	File temp = new File("C:/Users/Owner/Documents/GitHub/Games/Wasteland-Survival Game Prototype/src/mainGame/cowboy.png");
        	img = ImageIO.read(temp);
        } catch (IOException ex) {
            ex.getStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
}