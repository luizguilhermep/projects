package br.com.rectangles;

public class Rectangle {
	private Point bottomLeft;
	private Point topRight;

	public Rectangle(Point bottomLeft, Point topRight) {
		super();
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}
	

	public Point getBottomLeft() {
		return bottomLeft;
	}


	public void setBottomLeft(Point bottomLeft) {
		this.bottomLeft = bottomLeft;
	}


	public Point getTopRight() {
		return topRight;
	}


	public void setTopRight(Point topRight) {
		this.topRight = topRight;
	}


	boolean isOverlapping(Rectangle other) {
		if (this.topRight.getY() < other.bottomLeft.getY() 
				|| this.bottomLeft.getY() > other.topRight.getY()) {
			return false;
		}
		if (this.topRight.getX() < other.bottomLeft.getX() 
				|| this.bottomLeft.getX() > other.topRight.getX()) {
			return false;
		}
		return true;
	}


}
