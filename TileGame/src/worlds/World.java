package worlds;

import java.awt.Graphics;

import tiles.PitTile;
import tiles.Tile;

public class World {
	private int width, height;
	private int [][] tiles;
	
	public World(String path) {
		loadWorld(path);
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		for(int j = 0; j<width; j++) {
			for (int i = 0; i<height; i++) {
				getTile(i,j).render(g,i*Tile.TILEWIDTH,j*Tile.TILEHEIGHT);
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
		width = 5; 
		height = 5;
		tiles = new int [width][height];
		for(int i = 0; i<width; i++) {
			for (int j = 0; j<height; j++) {
				tiles[i][j] = 1;
			}
		}
	}
}
