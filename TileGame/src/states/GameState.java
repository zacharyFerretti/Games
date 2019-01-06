package states;

import java.awt.Graphics;

import TileGame.Game;
import entities.creatures.Player;
import gfx.Assets;

public class GameState extends State {
	
	private Player player;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 108,108);
	}
	
	public void update() {
		player.tick();
	}

	public void render(Graphics g) {
		player.render(g);
	}

}
/**Entity: Anything in the game that is not a tile
	-Any Item, NPC, Enemy, Player, Clickable Locations.
	-Entity based system in our game.

Classes we will need for an entity based system
	Entity
	|---Creature Class extends Entity
	|	|---Player Class extends Creature
	|
	|---Item Class Extends Entity
		|---Arrow extends Item


Entity Requirements:
	1.Position
	2.Tick
	3.Render
	
	Creature Requirements:
		4.Health
		
		Player Requirements:
			5.Texture
			6.Input
	
**/
