package TileGame;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Display.Display;
import gfx.ImageLoader;

public class Game implements Runnable {
	
	
	private Display display;
	public int width,height;
	public String title;
	
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage temp;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	//This method initializes the graphics of our game and gets things ready to game.
	private void init() {
		display = new Display(title,width,height);
		
	}
	
	private void update() {
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height); //Clears the screen.
		//Draw Here!
		
		g.drawImage(ImageLoader.loadImage("/textures/cowboy.png"), 20, 20, null);
		g.drawImage(ImageLoader.loadImage("/textures/testSprite.png"), 40, 40,null);
		//End Drawing
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		while(running) {
			update();
			render();			
		}
		
		stop();
		
	}
	//Threading.
	public synchronized void start() {
		if(running) {return;}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running) {return;}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
