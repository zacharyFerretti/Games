package gfx;

import entities.Entity;
import tilegame.Game;

public class GameCamera {
	private Game game;
	private float xOffSet, yOffSet;
	
	public GameCamera(Game game, float xOffSet, float yOffSet) {
		this.xOffSet = xOffSet; 
		this.yOffSet = yOffSet;
		this.game = game;
	}
	public void centerOnEntity(Entity e) {
		xOffSet = e.getX() - game.getWidth() / 2 + e.getWidth()/2; 
		yOffSet = e.getY() - game.getHeight() / 2 + e.getHeight()/2;
	}
	public void move (float xAmt, float yAmt) {
		xOffSet += xAmt;
		yOffSet += yAmt;
	}
	public float getxOffSet() {
		return xOffSet;
	}

	public void setxOffSet(float xOffSet) {
		this.xOffSet = xOffSet;
	}

	public float getyOffSet() {
		return yOffSet;
	}

	public void setyOffSet(float yOffSet) {
		this.yOffSet = yOffSet;
	}
}
