package entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import gfx.Assets;
import tilegame.Handler;

public class Player extends Creature {
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	
		bounds.x = 7;
		bounds.y = 19;
		bounds.width = 17;
		bounds.height = 13;
	}

	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}
	public void render(Graphics g) {
		g.drawImage(Assets.Abel, (int)(x-handler.getGameCamera().getxOffSet()),
				                 (int) (y-handler.getGameCamera().getyOffSet()),
				                 width, height, null);
		/*g.setColor(Color.red);
		g.fillRect((int)(x+bounds.x - handler.getGameCamera().getxOffSet()), 
				(int)(y+bounds.y - handler.getGameCamera().getyOffSet()),
				bounds.width, bounds.height);*/
	}

}
