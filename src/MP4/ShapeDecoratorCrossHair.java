package MP4;

import java.awt.*;

public class ShapeDecoratorCrossHair implements Shape {
    private Shape decoratee;

    public ShapeDecoratorCrossHair(Shape decoratee) {
        this.decoratee = decoratee;
    }
    @Override
    public void draw(Graphics g) {
        decoratee.draw(g);
        Point position = decoratee.getPosition();
        int x = (int) (position.getX() - decoratee.getWidth() / 2.0 + 0.5);
        int y = (int) (position.getY() - decoratee.getHeight() / 2.0 + 0.5);
        if (decoratee instanceof Circle) {
            g.fillOval(x, y, (int) (decoratee.getWidth() + 0.5), (int) (decoratee.getHeight() + 0.5));
            g.setColor(Color.RED);
            g.drawLine((int)position.getX() - 5,(int) position.getY(), (int)position.getX()  + 5,(int) position.getY());
            g.drawLine((int)position.getX(),(int) position.getY() - 5,(int) position.getX(), (int)position.getY() + 5);
            g.setColor(Color.black);
        } else if (decoratee instanceof Rectangle) {
            g.fillRect(x, y, (int) (decoratee.getWidth() + 0.5), (int) (decoratee.getHeight() + 0.5));
            g.setColor(Color.RED);
            int centerX = (int) (position.getX() + 0.5);
            int centerY = (int) (position.getY() + 0.5);
            g.drawLine(centerX - 5, centerY, centerX + 5, centerY);
            g.drawLine(centerX, centerY - 5, centerX, centerY + 5);
            g.setColor(Color.BLACK);
        }
    }
    @Override
    public Point getPosition() {
        return decoratee.getPosition();
    }

    @Override
    public double getWidth() {
        return decoratee.getWidth();
    }

    @Override
    public double getHeight() {
        return decoratee.getHeight();
    }

    @Override
    public boolean intersects(Point point) {
        return decoratee.intersects(point);
    }

    @Override
    public void moveTo(Point point) {
        decoratee.moveTo(point);
    }

    @Override
    public void move(double dx, double dy) {
        decoratee.move(dx, dy);
    }

    @Override
    public void resizeTo(Point point) {
        decoratee.resizeTo(point);
    }

    @Override
    public Shape peel() {
        return decoratee;
    }
}
