package snake;

import java.awt.Rectangle;

public class BodyPart extends Rectangle{
	public Direction bodyDirc = Direction.LEFT;
	
	public BodyPart(int x, int y, int side1, int side2) {
		super(x,y,side1,side2);
	}
	
	public void movePart() {
		this.setLocation((int) this.getX() + bodyDirc.getDx(),(int) this.getY() + bodyDirc.getDy());
	}
}
