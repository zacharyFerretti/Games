package tiles;

import gfx.Assets;

public class SouthWallTile extends Tile {
	public SouthWallTile(int id) {
		super(Assets.SouthWall, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
