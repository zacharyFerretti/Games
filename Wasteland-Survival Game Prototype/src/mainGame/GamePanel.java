package mainGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	
	private BufferedImage image;
	private Graphics2D graphics2;
	private boolean running;
	public JLabel label;
	public JLabel cowboyLabel;
	public GamePanel(String arg) {
		
		if (arg==null) { arg = "C:/Users/Owner/Documents/GitHub/Games/Wasteland-Survival Game Prototype/src/mainGame/testSprite.png"; }
		ImageIcon sprite = new ImageIcon(arg);
		label = new JLabel();
		label.setIcon(sprite);
		ImageIcon cowboy = new ImageIcon("C:/Users/Owner/Documents/GitHub/Games/Wasteland-Survival Game Prototype/src/mainGame/cowboy.png");
		cowboyLabel = new JLabel();
		cowboyLabel.setIcon(cowboy);
		
		running=true;
		image = new BufferedImage(MainWindow.WIDTH, MainWindow.HEIGHT,BufferedImage.TYPE_INT_RGB);
		graphics2 = (Graphics2D)image.getGraphics();
		
		
	}
	public void playGame() {
		draw();
	}
	//Game Loop.
	/*public void playGame() {
		//Main Game Loop
		while(running) {
			update();
			
			draw();
			
			repaint();
			
			try {
				Thread.sleep(40);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}*/
	
	//Create Image in Memory.
	public void draw() {
		
//		Color col = new Color(140,242,242);
//		//Background Layer
//		graphics2.setColor(Color.ORANGE);
//		graphics2.fillRect(0,0,MainWindow.WIDTH,MainWindow.HEIGHT);
		
	}
	
	//Updates Game Components over time.
	public void update() {
			
	}
	
	//Over-rides JPanel paintComponent Method. Place the image that pops up on the window.
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
}
