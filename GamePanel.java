package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	Random rand = new Random();
    Point randomPoint = createFoodLocation();
	Food food = new Food (randomPoint);
	Snake snake = new Snake (food);
	Listener listener;
	Timer timer;


	public GamePanel() {
		setBackground(Color.BLACK);	
		listener = new Listener();
		timer = new Timer(50, listener);
		addKeyListener(listener);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer.start();
	}
	
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(food.color);
        g2.fill(food);
        
        
		for(BodyPart i : snake.snakeBody) {
			g2.setColor(Color.GREEN);			
			g2.fill(i);
		}
	}
	
	public Point createFoodLocation() {
		int x = rand.nextInt(GameWindow.WIDTH - Snake.SIDE);
		int y = rand.nextInt(GameWindow.HEIGHT - Snake.SIDE);
		System.out.println(x+ "," +y);
		return new Point (x,y);
	}
	
	
	public void checkFoodCollision(Food food, Snake snake) {
		if ((snake.getX() <= food.x + Snake.SIDE && snake.getX() >= food.x - Snake.SIDE)
				&& (snake.getY() <= food.y + Snake.SIDE && snake.getY() >= food.y - Snake.SIDE)) {
			food.setLocation(createFoodLocation());
			snake.elongate = true;
			timer.setDelay(timer.getDelay() - 3);
		}
	}
	
	class Listener implements ActionListener, KeyListener {
		public void actionPerformed(ActionEvent event) {
			snake.move(food, timer);
			checkFoodCollision(food,snake);
			repaint();
		}

		@Override
		public void keyTyped(KeyEvent event) {
		}
		@Override
		public void keyPressed(KeyEvent event) {
			int keyTyped = event.getKeyCode();
			if (keyTyped == KeyEvent.VK_UP && snake.snakeBody.get(0).bodyDirc != Direction.DOWN) {
				snake.snakeBody.get(0).bodyDirc = Direction.UP;
			}else if (keyTyped == KeyEvent.VK_DOWN && snake.snakeBody.get(0).bodyDirc != Direction.UP) {
				snake.snakeBody.get(0).bodyDirc = Direction.DOWN;
			}else if (keyTyped == KeyEvent.VK_LEFT && snake.snakeBody.get(0).bodyDirc != Direction.RIGHT) {
				snake.snakeBody.get(0).bodyDirc = Direction.LEFT;
			}else if (keyTyped == KeyEvent.VK_RIGHT && snake.snakeBody.get(0).bodyDirc != Direction.LEFT){
				snake.snakeBody.get(0).bodyDirc = Direction.RIGHT;
			}
		}
		@Override
		public void keyReleased(KeyEvent event) {
			// TODO Auto-generated method stub
			
		}

	}

}
