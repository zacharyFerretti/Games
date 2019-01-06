package states;

import java.awt.Graphics;

import gfx.Assets;

public class GameState extends State {
	
	public GameState() {
		
	}
	
	public void update() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.River, 0, 0, null);
	}

}
//Entity: Anything in the game that is not a tile
//	-Any Item, NPC, Enemy, Player, Clickable Locations.
//	-Entity based system in our game.