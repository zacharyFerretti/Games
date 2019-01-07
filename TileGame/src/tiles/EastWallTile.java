package tiles;

import gfx.Assets;

public class EastWallTile extends Tile {
	public EastWallTile(int id) {
		super(Assets.EastWall, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
