package states;

import java.awt.Graphics;

import gfx.Assets;

public class MenuState extends State {
	public MenuState() {
		
	}
	
	public void update() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.Logo, 16, 0, null);
	}
}
