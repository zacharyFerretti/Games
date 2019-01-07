package worlds;

import java.awt.Graphics;
import java.util.Arrays;

import tilegame.Game;
import tiles.PitTile;
import tiles.Tile;
import utils.Utilities;

public class World {
	
	private Game game;
	private int width, height, spawnX, spawnY;
	private int [][] tiles;
	
	public World(Game game, String path) {
		this.game = game;
		loadWorld(path);
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		for(int j = 0; j<width; j++) {
			for (int i = 0; i<height; i++) {
				getTile(i,j).render(g,(int)(i*Tile.TILEWIDTH-game.getGameCamera().getxOffSet()),
								      (int) (j*Tile.TILEHEIGHT-game.getGameCamera().getyOffSet()));
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.treeTile;
		}else return t;
	}
	
	private void loadWorld(String path) {
		String loadedFile = Utilities.loadFileAsString(path);
		String [] tokens = loadedFile.split("\\s+");
		width = Utilities.parseInt(tokens[0]);
		height = Utilities.parseInt(tokens[1]);
		spawnX = Utilities.parseInt(tokens[2]);
		spawnY = Utilities.parseInt(tokens[3]);
		tiles = new int [width][height];
		
		for (int y = 0; y<height; y++) {   //This is wrong I shouldn't have to stop counting early.
			for (int x = 0; x<width; x++) {
				tiles[x][y] = Utilities.parseInt(tokens[(x+y * width) + 4]);
				//System.out.println(Utilities.parseInt(tokens[(x+y * width) + 4]));
			}
		}
	}
}
