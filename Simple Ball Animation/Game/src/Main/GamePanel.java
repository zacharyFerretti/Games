package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	
	private BufferedImage image;
	private Graphics2D graphics2;
	private boolean running;
	private ball theBall;
	public GamePanel() {
		
		running=true;
		theBall = new ball();
		image = new BufferedImage(GameWindow.WIDTH, GameWindow.HEIGHT,BufferedImage.TYPE_INT_RGB);
		graphics2 = (Graphics2D)image.getGraphics();
		
	}
	
	//Game Loop.
	public void playGame() {
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
	}
	
	//Create Image in Memory.
	public void draw() {
		
		Color col = new Color(255,153,0);
		//Background Layer
		graphics2.setColor(col);
		graphics2.fillRect(0,0,GameWindow.WIDTH,GameWindow.HEIGHT);
		theBall.draw(graphics2);
		
	}
	
	//Updates Game Components over time.
	public void update() {
		theBall.update();
	}
	
	//Over-rides JPanel paintComponent Method. Place the image that pops up on the window.
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
}
