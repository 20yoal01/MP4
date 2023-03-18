package MP4;

import java.awt.Graphics;

public class Rectangle implements Shape{
	
	private Point coordinates;
	private double height, width;
	
	public Rectangle(Point coordinates, int height, int width) {
		this.height = height;
		this.width = width;
		this.coordinates = coordinates;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect((int) ((int) coordinates.getX() - (width / 2)), (int) ((int) coordinates.getY() - (height / 2)), (int) width, (int) height);
	}

	@Override
	public Point getPosition() {
		return coordinates;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public boolean intersects(Point point) {
		double x1 = coordinates.getX() - (width / 2);
		double x2 = coordinates.getX() + (width / 2);
		double y1 = coordinates.getY() - (height / 2);
		double y2 = coordinates.getY() + (height / 2);

		return point.getX() >= x1 && point.getX() <= x2 && point.getY() >= y1 && point.getY() <= y2;
	}

	@Override
	public void moveTo(Point point) {
		coordinates.moveTo(point);
	}

	@Override
	public void move(double dx, double dy) {
		coordinates.move(dx, dy);
	}

	@Override
	public void resizeTo(Point point) {
		height = coordinates.distanceTo(point);
	 	 width = coordinates.distanceTo(point); 
	}

	@Override
	public Shape peel() {
		return this;
	}

}
