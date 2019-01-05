package mainGame;

import java.awt.Color;

import javax.swing.JFrame;


public class MainWindow {
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	public static void main(String[] args) {
//		JFrame theWindow = new JFrame("Game");
//		GamePanel thePanel = new GamePanel(args.length==0 ? null : args[0]);
//		thePanel.setBackground(Color.RED);
//		ImagePanel thePanel = new ImagePanel();
//		thePanel.setBackground(Color.RED);
//		theWindow.getContentPane().add(thePanel);
//		theWindow.setSize(WIDTH, HEIGHT);
//		theWindow.setResizable(false);
//		theWindow.setLocationRelativeTo(null);
//		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		thePanel.setBackground(Color.ORANGE);
//		theWindow.add(thePanel.label);
//		theWindow.add(thePanel.cowboyLabel);
//		theWindow.setVisible(true);
//		
//		thePanel.playGame();
		
		JFrame frame = new JFrame(); //Initialize the Frame
		ImagePanel thePanel = new ImagePanel(); //Initialize the ImagePanel
		thePanel.setOpaque(false);
		thePanel.setBackground(Color.blue);
        frame.getContentPane().add(thePanel); //Get the contentpane and add the image panel to it 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(67, 134, 242));
        frame.setVisible(true);
		
	}

}
