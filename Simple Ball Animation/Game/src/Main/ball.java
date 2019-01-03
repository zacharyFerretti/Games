package Main;

import java.awt.Color;
import java.awt.Graphics2D;

public class ball {
	
	//Ball Variables
	
	private int x, y;
	private int xVel, yVel;
	private Color c;
	private int size;
	
	public ball() {
		x = GameWindow.WIDTH/2;
		y = GameWindow.HEIGHT/2;
		
		xVel = 15;
		yVel = 25;
		
		c = new Color(179,240,255);
		size = 20;
	}
	
	public void update() {
		x += xVel;
		y += yVel;
		
		//If Ball Coordinates Hit Any of the game walls.
		if(x<0) {xVel = -xVel;	}
		if(x>GameWindow.WIDTH) {xVel=-xVel;	}
		
		if(y<0) {yVel = -yVel;	}
		if(y>GameWindow.HEIGHT) {yVel=-yVel;	}
	}
	
	public void draw(Graphics2D graphics2) {
		graphics2.setColor(c);
		graphics2.fillOval(x, y, size, size);
	}
}
