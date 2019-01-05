package mainGame;

import javax.swing.JFrame;

public class MainWindow {
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	public static void main(String[] args) {
		JFrame theWindow = new JFrame("Game");
		GamePanel thePanel = new GamePanel(args.length==0 ? null : args[0]);
		theWindow.setSize(WIDTH, HEIGHT);
		theWindow.setResizable(false);
		theWindow.setLocationRelativeTo(null);
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theWindow.add(thePanel);
		theWindow.add(thePanel.label);
		theWindow.setVisible(true);
		
		thePanel.playGame();
		
	}

}
