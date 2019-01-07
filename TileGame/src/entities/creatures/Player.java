package entities.creatures;

import java.awt.Graphics;

import gfx.Assets;
import tilegame.Game;

public class Player extends Creature {
	
	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
	}

	public void tick() {
		getInput();
		move();
		game.getGameCamera().centerOnEntity(this);
	}
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up)
			yMove = -speed;
		if(game.getKeyManager().down)
			yMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
	}
	public void render(Graphics g) {
		g.drawImage(Assets.Abel, (int)(x-game.getGameCamera().getxOffSet()),
				                 (int) (y-game.getGameCamera().getyOffSet()),
				                 width, height, null);
	}

}
