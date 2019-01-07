package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	//Static Stuff Here 
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new Grasstile(10);
	public static Tile treeTile = new TreeTile(0);
	public static Tile pitTile = new PitTile(1);
	public static Tile riverTile = new RiverTile(2);
	public static Tile northTile = new NorthWallTile(108);
	public static Tile southTile = new SouthWallTile(109);
	public static Tile eastTile = new EastWallTile(110);
	public static Tile westTile = new WestWallTile(111);
	
	//Class Stuff Here
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	public void tick() {
		
	}
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT,null);
	}
	public boolean isSolid() {
		return false;
	}
	public int getID() {
		return id;
	}
}
