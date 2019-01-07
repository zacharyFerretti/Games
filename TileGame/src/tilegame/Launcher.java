package tilegame;

public class Launcher {
	public static void main(String[] args) {
		//768,1024
		Game game = new Game("Zachs Frame!", 512, 512);
		game.start();
	}
}
