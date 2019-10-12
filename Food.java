package snake;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
public class Food extends Rectangle {
	
	private static final long serialVersionUID = 1L;
	public Color color = Color.RED;
	
	public Food(Point p) {
		super(p.x, p.y, 6,6);
	}

	
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Graphics2D g2D = (Graphics2D) g;
//		g2D.setColor(Color.RED);
//		Rectangle food = new Rectangle(x, y, 6, 6);
//		g2D.fill(food);
//	}
	
}
