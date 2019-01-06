package tiles;
import gfx.Assets;

public class PitTile extends Tile {

	public PitTile(int id) {
		super(Assets.PitScene, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
