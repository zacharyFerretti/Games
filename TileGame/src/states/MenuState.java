package states;

import java.awt.Graphics;

import gfx.Assets;
import tilegame.Handler;

public class MenuState extends State {
	public MenuState(Handler handler) {
		super(handler);
	}
	
	public void update() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.Logo, 16, 0, null);
	}
}
