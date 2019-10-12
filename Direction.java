package snake;


enum Direction {
	UP(0,-Snake.SIDE), DOWN(0,Snake.SIDE), LEFT(-Snake.SIDE,0), RIGHT(Snake.SIDE,0);
	
	public int dx,dy;
	
	Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public int getDx(){
		return dx;
	}
	
	public int getDy() {
		return dy;
	}
}

//public class Direction {
//	
//	public int dx;
//	public int dy;
//	
//	public Direction () {
//		this.dx = -1;
//		this.dy = 0;
//	}
//	
//	public void setDirection(int keyTyped) {
//		if (keyTyped == KeyEvent.VK_UP) {
//			this.dx = 0;
//			this.dy = -1;
//		}else if (keyTyped == KeyEvent.VK_DOWN) {
//			this.dx = 0;
//			this.dy = 1;
//		}else if (keyTyped == KeyEvent.VK_LEFT) {
//			this.dx = -1;
//			this.dy = 0;
//		}else if (keyTyped == KeyEvent.VK_RIGHT){
//			this.dx = 1;
//			this.dy = 0;
//		}
//	}
//
//	public int getDx() {
//		return dx;
//	}
//
//	public int getDy() {
//		return dy;
//	}
//	
//}
