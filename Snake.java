package snake;


import java.awt.Rectangle;

import java.util.ArrayList;
import javax.swing.Timer;


public class Snake {
	public Listener listener;
	public ArrayList<BodyPart> snakeBody = new ArrayList<BodyPart>();
	public boolean elongate;
	public static int SIDE = 6;

	
	public Snake(Food food) {
		make();
	}
	
	public void make() {
		for (int i = 0; i <= 5; i++) {
			snakeBody.add( new BodyPart((500 + 2*i * SIDE),400,SIDE,SIDE));
		}
		elongate = false;
	}
	
	public void move(Food food, Timer timer) {
		
		if (getX() <= SIDE || getX() >= (GameWindow.WIDTH - 2*SIDE) || 
				getY() <= SIDE || getY() >= (GameWindow.HEIGHT - 2*SIDE)) {
			System.out.println("Game Over");
			timer.stop();
		}
		
		for(int i = snakeBody.size()-1; i > 0; i--) {
			snakeBody.get(i).setLocation(snakeBody.get(i-1).getLocation());
		}
		snakeBody.get(0).movePart();

		checkSelfCollision(timer);
						
		if (elongate == true) {
			grow();
		}
	}

	
	public void checkSelfCollision(Timer timer) {
		for(int i = 1; i < snakeBody.size()-1; i++ ) {
			if( getX() == snakeBody.get(i).getX() && getY() == snakeBody.get(i).getY()) {
				System.out.println("Game Over");
				timer.stop();
			}
		}
	}
	
	public int getX() {
		return (int) snakeBody.get(0).getX();
	}
	
	public int getY() {
		return (int) snakeBody.get(0).getY();
	}
	
	public void grow() {
		if (elongate == true) {
			snakeBody.add( new BodyPart((int) snakeBody.get(snakeBody.size()-1).getX(),
					(int) snakeBody.get(snakeBody.size()-1).getY(),SIDE,SIDE));
			elongate = false;
		}
	}


}