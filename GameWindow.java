package snake;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	public static final int LEFT_X = 0;
	public static final int TOP_Y = 0;

	// A constructor 
	public GameWindow() {		
//		JFrame frame  = new JFrame("Project Game: Snake");
		super("Project Game: Snake");
		setLayout(new BorderLayout());
		setSize(WIDTH, HEIGHT);
		
		GamePanel p = new GamePanel();
		getContentPane().add(p, BorderLayout.CENTER);
		setLocation(LEFT_X, TOP_Y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);

	}

		

	
	// Running the program
	public static void main(String[] args) {
		new GameWindow();
	}
}

