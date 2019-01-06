package display;

import java.awt.*;

import javax.swing.JFrame;

public class Display {
	private JFrame frame; //This is where the images will be displayed.
	private Canvas canvas; //This is where all of the graphics will be drawn.
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height=height;
		createDisplay();
	}

	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack(); //This makes the frame be able to display the canvas fully.
	}
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
