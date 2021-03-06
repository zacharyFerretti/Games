package tilegame;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Display;
import gfx.Assets;
import gfx.GameCamera;
import input.KeyManager;
import states.GameState;
import states.MenuState;
import states.State;

public class Game implements Runnable {
	
	
	private Display display;
	private int width,height;
	public String title;
	
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	@SuppressWarnings("unused")
	private State menuState;
	
	//Input
	private KeyManager keyManager;
	
	private GameCamera gameCamera;
	
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		System.out.println(this.width);
		keyManager = new KeyManager();
		
	}
	//This method initializes the graphics of our game and gets things ready to game.
	private void init() {
		display = new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		System.out.println(this);
		gameCamera = new GameCamera(this,0,0);
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		
		State.setState(gameState);
	}
	
	
	
	
	private void update() {
		keyManager.tick();
		
		if(State.getState()!= null) {
			State.getState().update();
		}
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
		
		if(State.getState()!= null) {
			State.getState().render(g);
		}
		
		//End Drawing
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		int fps = 60; //How many times every second that tick and render should be called.
		double timePerTick = 1000000000/fps; //Maximum amount of time we are allowed to run tick and render
											 //for to still get 60 fps.
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		@SuppressWarnings("unused")
		long timer = 0;
		@SuppressWarnings("unused")
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += (now - lastTime);
			lastTime = now;
			
			//This means if the time accumulated since the last tick and render is greater than one
			//(longer than one second) then we will run this again.
			if(delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			
			/**if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks=0;
				timer=0;
			}**/
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
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
